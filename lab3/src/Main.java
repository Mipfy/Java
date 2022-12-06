import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        new Main("Лаба 3", 1350, 960);
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
        Font textFont = new Font("Serif", Font.ITALIC, 18);
        Color textColor = new Color(92, 29, 204);

        JLabel polygonLabel = new JLabel("червоний пʼятикутник");
        polygonLabel.setFont(textFont);
        polygonLabel.setForeground(textColor);
        polygonLabel.setBounds(250, 300, 250 ,105);

        int xOffset = 0;

        g.setColor(Color.RED);
        g.fillPolygon(
                new int[] {
                        300 + xOffset,
                        400 + xOffset,
                        350 + xOffset,
                        250 + xOffset,
                        200 + xOffset,
                },
                new int[] {100, 200, 300, 300, 200},
                5
        );
        xOffset += 300;

        JLabel triangleLabel = new JLabel("синій трикутник");
        triangleLabel.setFont(textFont);
        triangleLabel.setForeground(textColor);
        triangleLabel.setBounds(300 + xOffset, 300, 250 ,105);

        g.setColor(Color.BLUE);
        g.fillPolygon(
                new int[] {
                        300 + xOffset,
                        200 + xOffset,
                        400 + xOffset
                },
                new int[] {100, 200, 200},
                3
        );
        xOffset += 300;

        JLabel ovalLabel = new JLabel("зелений овал");
        ovalLabel.setFont(textFont);
        ovalLabel.setForeground(textColor);
        ovalLabel.setBounds(250 + xOffset, 300, 250 ,105);

        g.setColor(Color.GREEN);
        g.fillOval(250 + xOffset, 100, 100, 100);

        jpanel.add(polygonLabel);
        jpanel.add(triangleLabel);
        jpanel.add(ovalLabel);

        add(jpanel);
    }
}