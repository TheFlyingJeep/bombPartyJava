import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI {
    JFrame frame;
    GridLayout grid;
    JLabel playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight, timer,
            letters, wordDisplay, credits, hearts, logo;
    JTextField playerInput;
    JButton enter;

    String guess, lettersLeftDisplay;
    ArrayList<String> lettersLeft = new ArrayList<String>();

    //building game window
    public GUI(){
        frame = new JFrame("Bomb Party (Java)");
        grid = new GridLayout(6,3); //row, columns
        playerOne = new JLabel("Player 1");
        playerTwo = new JLabel("Player 2");
        playerThree = new JLabel("Player 3");
        playerFour = new JLabel("Player 4");
        playerFive = new JLabel("Player 5");
        playerSix = new JLabel("Player 6");
        playerSeven = new JLabel("Player 7");
        playerEight = new JLabel("Player 8");
        timer = new JLabel("timer");
        letters = new JLabel("<html>A B C D E F G H I J K<br/>L M N O P Q R S T U</html>");
        playerInput = new JTextField();
        enter = new JButton("Enter");
        wordDisplay = new JLabel(guess);
        credits = new JLabel("BombParty (Java) was inspired by JKLM's BombParty");
        hearts = new JLabel("hearts");
        logo = new JLabel("blow up bash!");

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
        frame.add(letters);
        frame.add(hearts);
        frame.add(logo);
        frame.add(credits);
        frame.add(playerInput);
        frame.add(enter);
        frame.add(wordDisplay);

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
            refresh();
        }
    }

    //action listener for enter button
    class enterButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            guess = playerInput.getText();
            System.out.println(guess);
            playerInput.setText("");
            refresh();
        }
    }

    //updates the letters display on GUI
    public void updateLetters(){
        //params: letters unused by player from Player class
        for(int i = 0; i < lettersLeft.size(); i++){
            lettersLeftDisplay += lettersLeft.get(i);
            System.out.println(lettersLeftDisplay);
        }
        refresh();
    }

    //refreshes GUI
    public void refresh(){
        wordDisplay.setText(guess); //displays word inputed on screens
    }

    //returns player's input aka player's guess
    public String sendGuess(){
        return guess;
    }

    public static void main(String[] args){
        new GUI();
    }
}