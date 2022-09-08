import javax.swing.*;
import java.awt.*;

public class GUI{
    JFrame frame;
    JPanel panel;

    public GUI(){
        frame = new JFrame("Bomb Party (Java)");
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new GUI();
    }
}