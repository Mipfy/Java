import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Main extends JFrame {
    static int frameWidth = 1280;
    static int frameHeight = 960;
    public static void main(String[] args) {
        new Main("лаба 4", frameWidth, frameHeight);
    }

    Main(String s, int w, int h) {
        super(s);
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JLabel title = new JLabel("Авторизація входу");
        title.setFont(titleFont);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(0, yOffset, frameWidth, 50);
        title.setForeground(textColor);
        jpanel.add(title);

        JLabel phoneLabel = new JLabel("Телефон");
        phoneLabel.setFont(textFont);
        phoneLabel.setBounds(xOffset, yOffset * 2 + 50, 300, 50);
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

        recallBtn.setFont(textFont);
        recallBtn.setBounds(xOffset, yOffset * 2 + 300, recallBtnWidth, 70);
        jpanel.add(recallBtn);

        String sendBtnText = "Надіслати";
        JButton sendBtn = new JButton(sendBtnText);
        int sendBtnWidth = letterWidth  * sendBtnText.length();

        sendBtn.setFont(textFont);
        sendBtn.setBounds(xOffset + recallBtnWidth, yOffset * 2 + 300, sendBtnWidth, 70);
        jpanel.add(sendBtn);

        String cancelBtnText = "Відмінити";
        JButton cancelBtn = new JButton(cancelBtnText);
        int cancelBtnWidth = letterWidth  * cancelBtnText.length();

        cancelBtn.setFont(textFont);
        cancelBtn.setBounds(xOffset + recallBtnWidth + sendBtnWidth, yOffset * 2 + 300, cancelBtnWidth, 70);
        jpanel.add(cancelBtn);
        add(jpanel);
    }
}