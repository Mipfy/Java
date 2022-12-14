import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Main extends JFrame {
    static int frameWidth = 1920;
    static int frameHeight = 1080;
    private JPopupMenu popup;
    private JLabel[] productImgs;
    private String currentImgName;
    public static void main(String[] args) {
        new Main("lab6", frameWidth, frameHeight);
    }

    Main(String s, int w, int h) {
        super(s);
        setSize(w, h);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void drawProductInput(JPanel jpanel, JLabel label, JTextField name, JTextField price, int offsetY, int currentIndex) {
        Font textFont = new Font("Serif", Font.PLAIN, 20);
        Color textColor = Color.BLACK;
        label.setFont(textFont);
        label.setBounds(0, offsetY, 150, 50);
        label.setForeground(textColor);
        jpanel.add(label);

        name.setFont(textFont);
        name.setBounds(200, offsetY, 500, 50);
        name.setForeground(textColor);
        jpanel.add(name);

        price.setFont(textFont);
        price.setBounds(750, offsetY, 200, 50);
        price.setForeground(textColor);
        try {
            ImageIcon icon = new ImageIcon(
                    new ImageIcon(
                            Objects.requireNonNull(getClass().getResource("earth.jpg"))
                    ).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)
            );

            JLabel imgLabel = new JLabel(icon);
            imgLabel.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    showPopup(me, currentIndex);
                }
            }) ;
            imgLabel.setBounds(100, offsetY, 100, 100);
            productImgs[currentIndex] = imgLabel;
            jpanel.add(imgLabel);
        } catch (Exception e){
            System.out.println("Image not found");
        }

        jpanel.add(price);
    }

    public static void drawProductLine(JPanel jpanel, JLabel name, int offsetY) {
        int letterWidth = 20;
        Font textFont = new Font("Serif", Font.PLAIN, 20);
        Color textColor = Color.BLACK;
        name.setFont(textFont);
        name.setBounds(0, offsetY, frameWidth, 20);
        name.setForeground(textColor);

        jpanel.add(name);
        jpanel.repaint();
    }

    public String validateInput(JTextField[] names, JTextField[] prices){
        for (JTextField name: names) {
            if(Objects.equals(name.getText(), "")){
                return "Form contain empty product name";
            }
        }

        for (JTextField price: prices ) {
            if(Objects.equals(price.getText(), "")){
                return "Form contain empty product price";
            }
            if(Float.parseFloat(price.getText()) < 0){
                return "Form contain negative product price";
            }
        }
        return "";
    }

    private void showDialog(String message, boolean exitOnClose)
    {
        Font textFont = new Font("Serif", Font.PLAIN, 20);

        JDialog errorDialog = new JDialog(this, Dialog.ModalityType.APPLICATION_MODAL);
        errorDialog.setLayout(null);

        JLabel text = new JLabel(message);
        text.setFont(textFont);
        text.setBounds(0, 0, 600, 50);
        errorDialog.add(text);
        text.setHorizontalAlignment(SwingConstants.CENTER);

        String recallBtnText = "????????????????????";
        JButton recallBtn = new JButton(recallBtnText);
        recallBtn.addActionListener(actionEvent -> {
            errorDialog.setVisible(false);
            if(exitOnClose) System.exit(0);
        });

        recallBtn.setFont(textFont);
        recallBtn.setBounds(12, 100, 400, 70);
        errorDialog.add(recallBtn);

        errorDialog.setBounds(10, 200, 600, 300);
        errorDialog.setVisible(true);
    }

    public void calculate(JPanel jpanel, int productsCount, JTextField[] priceInput, JTextField[] namesInput, JLabel[] resultsLabels, JButton closeBtn){
        int minPrice = Integer.MAX_VALUE;
        int minPriceIndex = 0;

        for (int i = 0; i < productsCount; i++) {
            if (Objects.equals(priceInput[i].getText(), "")) {
                continue;
            }
            int price = Integer.parseInt(priceInput[i].getText());
            if (price < minPrice) {
                minPrice = price;
                minPriceIndex = i;
            }
        }
        resultsLabels[0].setText("?????????????????????? ??????????: " + namesInput[minPriceIndex].getText() + "    ????????: " + priceInput[minPriceIndex].getText());
        int maxPrice = Integer.MIN_VALUE;
        int maxPriceIndex = 0;
        for (int i = 0; i < productsCount; i++) {
            if (Objects.equals(priceInput[i].getText(), "")) {
                continue;
            }
            int price = Integer.parseInt(priceInput[i].getText());
            if (price > maxPrice) {
                maxPrice = price;
                maxPriceIndex = i;
            }
        }
        resultsLabels[1].setText("?????????????????????? ??????????: " + namesInput[maxPriceIndex].getText() + "    ????????: " + priceInput[maxPriceIndex].getText());
        closeBtn.setVisible(true);

        jpanel.repaint();
    }

    void showPopup(MouseEvent me, int currentIndex) {
        if(me.isPopupTrigger()) {
            popup.show(me.getComponent(), me.getX(), me.getY());
            popup.setName(String.valueOf(currentIndex));
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);
        jpanel.setBackground(new Color(185, 205, 229));
        Font textFont = new Font("Serif", Font.PLAIN, 30);

        int productsCount = 5;
        JTextField[] namesInput = new JTextField[productsCount];
        JTextField[] priceInput = new JTextField[productsCount];
        JLabel[] resultsLabels = new JLabel[2];
        productImgs = new JLabel[productsCount];
        for (int i = 0; i < productsCount; i++) {
            namesInput[i] = new JTextField();
            priceInput[i] = new JTextField();

            drawProductInput(
                    jpanel,
                    new JLabel(i + 1 + " ??????????"),
                    namesInput[i],
                    priceInput[i],
                    90 * i,
                    i
            );
        }

        JButton submitBtn = new JButton("??????????????????");

        submitBtn.setFont(textFont);
        submitBtn.setBounds(1000, 50 * (productsCount + 1), 150, 70);
        submitBtn.setBackground(Color.GREEN);
        jpanel.add(submitBtn);


        JButton closeBtn = new JButton("??????????");

        closeBtn.setFont(textFont);
        closeBtn.setBounds(1000, 67 * (productsCount + 1), 150, 70);
        closeBtn.setBackground(Color.RED);
        closeBtn.setVisible(false);
        jpanel.add(closeBtn);

        for (int i = 0; i < resultsLabels.length; i++) {
            resultsLabels[i] = new JLabel("");

            drawProductLine(
                    jpanel,
                    resultsLabels[i],
                    productsCount * 65 + 200 + 60 * i
            );
        }
        submitBtn.addActionListener(actionEvent -> {
            String formValidationError = validateInput(namesInput, priceInput);

            if(!Objects.equals(formValidationError, "")) {
                showDialog(formValidationError, false);
                return;
            }
            calculate(jpanel, productsCount, priceInput, namesInput, resultsLabels, closeBtn);
        });


        closeBtn.addActionListener(actionEvent -> {
            System.exit(0);
        });

        JMenuBar jMenuBar = new JMenuBar();
        JMenu program = new JMenu("????????????????");
        JMenu edit = new JMenu("????????????");
        jMenuBar.add(program);
        jMenuBar.add(edit);
        setJMenuBar(jMenuBar);

        JMenuItem check = program.add(new JMenuItem("??????????????????"));
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String formValidationError = validateInput(namesInput, priceInput);
                if(Objects.equals(formValidationError, "")) return;
                showDialog(formValidationError, false);
            }
        });
        program.add(new JSeparator());

        JMenuItem calculate = program.add(new JMenuItem("??????????????????"));
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String formValidationError = validateInput(namesInput, priceInput);
                if(!Objects.equals(formValidationError, "")) {
                    showDialog(formValidationError, false);
                    return;
                }

                calculate(jpanel, productsCount, priceInput, namesInput, resultsLabels, closeBtn);
            }
        });
        program.add(new JSeparator());

        JMenuItem quit = program.add(new JMenuItem("??????????"));
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        edit.add(new JMenuItem("??????????????????"));
        edit.add(new JMenuItem("????????????????"));

        popup = new JPopupMenu();
        JMenuItem change = new JMenuItem("??????????????");
        JMenuItem delete = new JMenuItem("????????????????");
        JMenuItem addBorder = new JMenuItem("???????????? ??????????");


        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (JLabel img: productImgs) {
                    img.setVisible(false);
                }
            }
        });

        addBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (JLabel img: productImgs) {
                    img.setBorder(BorderFactory.createLineBorder(Color.black));
                }
            }
        });

        popup.add(change);
        popup.add(addBorder);
        popup.add(delete);

        add(popup);

        add(jpanel);
    }


}