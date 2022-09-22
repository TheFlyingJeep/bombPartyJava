import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;

public class GUI {
    JFrame gameFrame;
    GridLayout grid;
    JLabel playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight, bomb,
            letters, wordDisplay, credits, hearts, logo;
    JTextField playerInput;
    JButton enter;

    String guess, lettersLeftDisplay;
    ArrayList<String> lettersLeft = new ArrayList<String>();
    boolean gameScreen = true;
    boolean menuScreen = true;

    //building game window
    public GUI(){
        gameFrame = new JFrame("blow up bash!");
        grid = new GridLayout(6,3); //row, columns
        playerOne = new JLabel("Player 1");
        playerTwo = new JLabel("Player 2");
        playerThree = new JLabel("Player 3");
        playerFour = new JLabel("Player 4");
        playerFive = new JLabel("Player 5");
        playerSix = new JLabel("Player 6");
        playerSeven = new JLabel("Player 7");
        playerEight = new JLabel("Player 8");
        bomb = new JLabel("bomb");
        letters = new JLabel("<html>A B C D E F G H I J K<br/>L M N O P Q R S T U</html>");
        //resizing image to fit
        //hearts = new JLabel();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("images/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); //resize dimensions currently hardcoded
        ImageIcon imageIcon = new ImageIcon(dimg);
        hearts = new JLabel(imageIcon);
        logo = new JLabel("blow up bash!");
        credits = new JLabel("blow up bash! was inspired by JKLM's BombParty");
        playerInput = new JTextField();
        enter = new JButton("Enter");
        wordDisplay = new JLabel(guess);

        gameFrame.setSize(700,500); //width, height
        gameFrame.setLayout(grid);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(gameScreen);

        gameFrame.add(playerOne);
        gameFrame.add(playerTwo);
        gameFrame.add(playerThree);
        gameFrame.add(playerFour);
        gameFrame.add(bomb);
        gameFrame.add(playerFive);
        gameFrame.add(playerSix);
        gameFrame.add(playerSeven);
        gameFrame.add(playerEight);
        gameFrame.add(letters);
        gameFrame.add(hearts);
        gameFrame.add(logo);
        gameFrame.add(credits);
        gameFrame.add(playerInput);
        gameFrame.add(enter);
        gameFrame.add(wordDisplay);

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