import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main extends JFrame {
    static int frameWidth = 1280;
    static int frameHeight = 960;

    public static void main(String[] args) {
        new Main("лаба 5", frameWidth, frameHeight);
    }

    Main(String s, int w, int h) {
        super(s);
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showDialog(String message, boolean exitOnClose)
    {
        Font textFont = new Font("Serif", Font.PLAIN, 30);

        JDialog errorDialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);
        errorDialog.setLayout(null);

        JLabel text = new JLabel(message);
        text.setFont(textFont);
        text.setBounds(0, 0, 600, 50);
        errorDialog.add(text);
        text.setHorizontalAlignment(SwingConstants.CENTER);

        String recallBtnText = "Продовжити";
        JButton recallBtn = new JButton(recallBtnText);
        recallBtn.addActionListener(actionEvent -> {
            errorDialog.setVisible(false);
            if(exitOnClose) System.exit(0);
        });

        recallBtn.setFont(textFont);
        recallBtn.setBounds(100, 100, 400, 70);
        errorDialog.add(recallBtn);

        errorDialog.setBounds(300, 200, 600, 300);
        errorDialog.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);
        jpanel.setBackground(new Color(185,205,229));
        Font textFont = new Font("Serif", Font.PLAIN, 30);
        Font titleFont = new Font("Serif", Font.BOLD, 42);
        Color textColor = Color.BLACK;
        int xOffset = 30;
        int yOffset = 20;
        String code = "1986";
        JLabel title = new JLabel("Авторизація входу");
        title.setFont(titleFont);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(0, yOffset, frameWidth, 50);
        title.setForeground(textColor);
        jpanel.add(title);

        JLabel phoneLabel = new JLabel("Телефон");
        phoneLabel.setFont(textFont);
        phoneLabel.setBounds(xOffset, yOffset * 2 + 50, 200, 50);
        phoneLabel.setForeground(textColor);
        jpanel.add(phoneLabel);

        JTextField phoneInput = new JTextField();
        phoneInput.setBorder(new LineBorder(Color.YELLOW,1));
        phoneInput.setFont(textFont);
        phoneInput.setBounds(xOffset + 200, yOffset * 2 + 50, 400, 50);
        jpanel.add(phoneInput);


        JLabel codeLabel = new JLabel("<HTML> Введіть чотири останні цифри номеру, <br> з якого Вам телефонують:</HTML>");
        codeLabel.setFont(textFont);
        codeLabel.setBounds(xOffset + 300, yOffset * 3 + 100, 700, 100);
        codeLabel.setForeground(textColor);
        jpanel.add(codeLabel);

        JTextField codeInput = new JTextField();
        codeInput.setBorder(new LineBorder(Color.RED,1));
        codeInput.setFont(textFont);
        codeInput.setBounds(xOffset + 500, yOffset * 3 + 200, 150, 50);
        jpanel.add(codeInput);



        int letterWidth = 30;
        String recallBtnText = "Повторний дзвінок";
        int recallBtnWidth = letterWidth  * recallBtnText.length();
        JButton recallBtn = new JButton(recallBtnText);

        recallBtn.addActionListener(actionEvent -> {
            codeInput.setText("");
            recallBtn.setEnabled(false);
        });

        recallBtn.setFont(textFont);
        recallBtn.setBounds(xOffset, yOffset * 2 + 300, recallBtnWidth, 70);

        jpanel.add(recallBtn);

        String sendBtnText = "Надіслати";
        JButton sendBtn = new JButton(sendBtnText);
        sendBtn.setEnabled(false);
        int sendBtnWidth = letterWidth  * sendBtnText.length();

        sendBtn.setFont(textFont);
        sendBtn.setBounds(xOffset * 2 + recallBtnWidth, yOffset * 2 + 300, sendBtnWidth, 70);

        jpanel.add(sendBtn);

        sendBtn.addActionListener(actionEvent -> {
            Pattern phonePattern = Pattern.compile("((\\+38)?\\(?\\d{3}\\)?[\\s\\.-]?(\\d{7}|\\d{3}[\\s\\.-]\\d{2}[\\s\\.-]\\d{2}|\\d{3}-\\d{4}))");
            Matcher phoneMatcher = phonePattern.matcher(phoneInput.getText());

            Pattern codePattern = Pattern.compile("\\d{4}");
            Matcher codeMatcher = codePattern.matcher(codeInput.getText());
            if(!phoneMatcher.matches()){
                showDialog("неправильний номер", false);
                return;
            }
            if(!codeMatcher.matches()){
                showDialog("невірний код", false);
                return;
            }
            if(Objects.equals(codeInput.getText(), code)){
                showDialog("Ви увійшли", true);
            } else {
                recallBtn.setEnabled(true);
            }
        });

        String cancelBtnText = "Відмінити";
        JButton cancelBtn = new JButton(cancelBtnText);
        int cancelBtnWidth = letterWidth  * cancelBtnText.length();

        cancelBtn.setFont(textFont);
        cancelBtn.setBounds(xOffset * 3 + recallBtnWidth + sendBtnWidth, yOffset * 2 + 300, cancelBtnWidth, 70);
        jpanel.add(cancelBtn);
        add(jpanel);

        cancelBtn.addActionListener(actionEvent -> {
            System.out.println("cancel");
            System.exit(0);
        });

        phoneInput.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(Objects.equals(codeInput.getText(), "") || Objects.equals(phoneInput.getText(), "")){
                    sendBtn.setEnabled(false);
                } else {
                    sendBtn.setEnabled(true);
                }
            }
        });


        codeInput.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(Objects.equals(codeInput.getText(), "") || Objects.equals(phoneInput.getText(), "")){
                    sendBtn.setEnabled(false);
                    sendBtn.setBackground(Color.GRAY);
                } else {
                    sendBtn.setEnabled(true);
                    sendBtn.setBackground(Color.GREEN);
                }
                recallBtn.setEnabled(false);
                recallBtn.setBackground(Color.GRAY);
            }

        });
    }
}