import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    JFrame frame;
    GridLayout grid;
    JLabel playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight, timer, letters;
    JTextField playerInput;
    JButton enter;

    String guess = "";

    //building game window
    public GUI(){
        frame = new JFrame("Bomb Party (Java)");
        grid = new GridLayout(4,3); //row, columns
        playerOne = new JLabel("Player 1");
        playerTwo = new JLabel("Player 2");
        playerThree = new JLabel("Player 3");
        playerFour = new JLabel("Player 4");
        playerFive = new JLabel("Player 5");
        playerSix = new JLabel("Player 6");
        playerSeven = new JLabel("Player 7");
        playerEight = new JLabel("Player 8");
        timer = new JLabel("timer");
        lettersLeft = new JLabel("<html>A B C D E F G H I J K L<br/>M N O P Q R S T U V</html>");
        playerInput = new JTextField(10);
        enter = new JButton("Enter");

        frame.setSize(700,500); //width, height
        frame.setLayout(grid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(playerOne);
        frame.add(playerTwo);
        frame.add(playerThree);
        frame.add(playerFour);
        frame.add(timer);
        frame.add(playerFive);
        frame.add(playerSix);
        frame.add(playerSeven);
        frame.add(playerEight);
        frame.add(lettersLeft);
        frame.add(playerInput);
        frame.add(enter);

        enter.setActionCommand("enter");
        enter.addActionListener(new enterButtonListener());

        playerInput.setActionCommand("playerInput");
        playerInput.addActionListener(new enterKeyListener());
    }

    //action listener for enter key
    class enterKeyListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            guess = playerInput.getText();
            System.out.println(guess);
            playerInput.setText("");
        }
    }

    //action listener for enter button
    class enterButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            guess = playerInput.getText();
            System.out.println(guess);
            playerInput.setText("");
        }
    }

    //updates the letters display on GUI
    public void updateLetters(){
        //params: letters used or letters unused by player from Player class
    }

    //refreshes GUI
    public void refresh(){
    }

    //returns player's input aka player's guess
    public String getGuess(){
        return guess;
    }

    public static void main(String[] args){
        new GUI();
    }
}