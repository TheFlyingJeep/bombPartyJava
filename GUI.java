import javax.swing.*;
import java.awt.*;

public class GUI{
    JFrame frame;
    GridLayout grid;
    JLabel playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight, timer;
    JTextField playerInput;

    public GUI(){
        frame = new JFrame("Bomb Party (Java)");
        grid = new GridLayout(4,3);
        playerOne = new JLabel("Player 1");
        playerTwo = new JLabel("Player 2");
        playerThree = new JLabel("Player 3");
        playerFour = new JLabel("Player 4");
        playerFive = new JLabel("Player 5");
        playerSix = new JLabel("Player 6");
        playerSeven = new JLabel("Player 7");
        playerEight = new JLabel("Player 8");
        timer = new JLabel("timer");
        playerInput = new JTextField(10);

        frame.setSize(500,500);
        frame.setLayout(grid);

        frame.add(playerOne);
        frame.add(playerTwo);
        frame.add(playerThree);
        frame.add(playerFour);
        frame.add(timer);
        frame.add(playerFive);
        frame.add(playerSix);
        frame.add(playerSeven);
        frame.add(playerEight);
        frame.add(playerInput);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new GUI();
    }
}