import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;

public class GUI {
    JFrame gameFrame, nameFrame;
    GridLayout grid;
    JLabel namePrompt, playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight, bomb,
            letters, wordDisplay, credits, hearts, logo, prompt, turnAnnouncement;
    JTextField nameInput, playerInput;
    JButton enterNameButton, enterButton;
    JPanel panelName;

    String pInput, cInput;
    String lettersLeftDisplay = "<html>A B C D E F G H I J K<br/>L M N O P Q R S T U</html>";
    ArrayList<String> lettersLeft = new ArrayList<String>();
    boolean isInValid = true;
//    BufferedImage[] bomb = [4];
//    BufferedImage[] explosion = [5];

    //building game window
    public GUI(){
        createNameWindow();
        createGameWindow();
    }

    //name input window
    public void createNameWindow() {
        nameFrame = new JFrame("blow up bash!");
        namePrompt = new JLabel("Enter Player name:");
        nameInput = new JTextField(20);
        panelName = new JPanel();
        enterNameButton = new JButton("Enter");

        nameFrame.getContentPane().add(BorderLayout.NORTH, panelName);
        nameFrame.setSize(500,100);
        nameFrame.setLocationRelativeTo(null);
        nameFrame.setVisible(true);
        nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelName.add(namePrompt);
        panelName.add(nameInput);
        panelName.add(enterNameButton);

        enterNameButton.setActionCommand("enterNameButton");
        enterNameButton.addActionListener(new nameEnterButtonListener());

        nameInput.setActionCommand("nameInput");
        nameInput.addActionListener(new nameEnterKeyListener());
    }

    //action listener for enter button NAME SCREEN
    class nameEnterButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String playerName = nameInput.getText();
            nameInput.setText("");
            getPlayerName(playerName);
            nameFrame.setVisible(false);
            gameFrame.setVisible(true);
        }
    }

    //action listener for enter key NAME SCREEN
    class nameEnterKeyListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String playerName = nameInput.getText();
            nameInput.setText("");
            getPlayerName(playerName);
            nameFrame.setVisible(false);
            gameFrame.setVisible(true);
        }
    }

    public String getPlayerName(String name){
        System.out.println(name);
        return name;
    }

    //game window
    public void createGameWindow(){
        //game screen
        gameFrame = new JFrame("blow up bash!");
        grid = new GridLayout(6,3); //row, columns
        playerOne = new JLabel("<html>Player 1<br/>lives:</html>");
        playerTwo = new JLabel("<html>Player 2<br/>lives:</html>");
        playerThree = new JLabel("<html>Player 3<br/>lives:</html>");
        playerFour = new JLabel("<html>Player 4<br/>lives:</html>");
        playerFive = new JLabel("<html>Player 5<br/>lives:</html>");
        playerSix = new JLabel("<html>Player 6<br/>lives:</html>");
        playerSeven = new JLabel("<html>Player 7<br/>lives:</html>");
        playerEight = new JLabel("<html>Player 8<br/>lives:</html>");
        BufferedImage imgBomb = null;
        try {
            imgBomb = ImageIO.read(new File("images/bomb1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgBomb = imgBomb.getScaledInstance(150, 150, Image.SCALE_SMOOTH); //resize dimensions currently hardcoded
        ImageIcon imageIconBomb = new ImageIcon(dimgBomb);
        bomb = new JLabel(imageIconBomb);
        letters = new JLabel(lettersLeftDisplay);
        //resizing image to fit
        //hearts = new JLabel();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("images/threeHearts.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(225, 150, Image.SCALE_SMOOTH); //resize dimensions currently hardcoded
        ImageIcon imageIcon = new ImageIcon(dimg);
        hearts = new JLabel(imageIcon);
        turnAnnouncement = new JLabel("Player 1's turn");
        credits = new JLabel("blow up bash! was inspired by JKLM's BombParty");
        playerInput = new JTextField();
        enterButton = new JButton("Enter");
        wordDisplay = new JLabel(pInput);
        prompt = new JLabel("prompt");
        logo = new JLabel("blow up bash!");

        gameFrame.setSize(700,500); //width, height
        gameFrame.setLayout(grid);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(false);

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
        gameFrame.add(turnAnnouncement);
        gameFrame.add(credits);
        gameFrame.add(playerInput);
        gameFrame.add(enterButton);
        gameFrame.add(wordDisplay);
        gameFrame.add(prompt);
        gameFrame.add(logo);

        enterButton.setActionCommand("enterButton");
        enterButton.addActionListener(new enterButtonListener());

        playerInput.setActionCommand("playerInput");
        playerInput.addActionListener(new enterKeyListener());
    }

    //action listener for enter key IN GAME
    class enterKeyListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            pInput = playerInput.getText();
            System.out.println(pInput); //debug print
            playerInput.setText("");
            refresh();
            updateLives(0);
            bombTicking();
        }
    }

    //action listener for enter button IN GAME
    class enterButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            pInput = playerInput.getText();
            System.out.println(pInput); //debug print
            playerInput.setText("");
            refresh();
            updateLives(2);
//            String[] n = {"s", "a", "b", "c", "d", "e", "f", "g", "h"};
//            setNames(n);
        }
    }

    //updates the letters display on GUI
    public void updateLetters(ArrayList lettersUnused){
        //params: letters unused by player from Player class
        for(int i = 0; i < lettersUnused.size(); i++){
            lettersLeftDisplay += lettersUnused.get(i);
            //System.out.println(lettersLeft.get(i));
        }
        letters.setText(lettersLeftDisplay); //displays letters left player's screen
        refresh();
    }

    //sets Player# labels to player names
    public void setNames(String[] names){
        //parameter will be name split by commas
        playerOne.setText("<html>"+names[1]+"<br/>lives: 3</html>");
        playerTwo.setText("<html>"+names[2]+"<br/>lives: 3</html>");
        playerThree.setText("<html>"+names[3]+"<br/>lives: 3</html>");
        playerFour.setText("<html>"+names[4]+"<br/>lives: 3</html>");
        playerFive.setText("<html>"+names[5]+"<br/>lives: 3</html>");
        playerSix.setText("<html>"+names[6]+"<br/>lives: 3</html>");
        playerSeven.setText("<html>"+names[7]+"<br/>lives: 3</html>");
        playerEight.setText("<html>"+names[8]+"<br/>lives: 3</html>");
    }

    //global (?) refreshes GUI
    public void refresh(){
        wordDisplay.setText(pInput.trim()); //displays word inputed on screens
    }

    //sets prompt text
    public void setPrompt(String p){
        prompt.setText(p);
    }

    //changes the image of hearts based on # lives the player has
    public void updateLives(int lives){
        BufferedImage img = null;
        if(lives == 3) {
            try {
                img = ImageIO.read(new File("images/threeHearts.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(lives == 2) {
            try {
                img = ImageIO.read(new File("images/twoHearts.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(lives == 1) {
            try {
                img = ImageIO.read(new File("images/oneHeart.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                img = ImageIO.read(new File("images/zeroHearts.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Image dimg = img.getScaledInstance(225, 150, Image.SCALE_SMOOTH); //resize dimensions currently hardcoded
        ImageIcon imageIcon = new ImageIcon(dimg);
        hearts.setIcon(imageIcon);
    }

    //bomb ticking animation
    public void bombTicking(){
        BufferedImage imgBomb = null;
        try {
            try {
                imgBomb = ImageIO.read(new File("images/bomb2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimgBomb = imgBomb.getScaledInstance(150, 150, Image.SCALE_SMOOTH); //resize dimensions currently hardcoded
            ImageIcon imageIconBomb = new ImageIcon(dimgBomb);
            bomb.setIcon(imageIconBomb);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            try {
                imgBomb = ImageIO.read(new File("images/bomb3.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimgBomb = imgBomb.getScaledInstance(150, 150, Image.SCALE_SMOOTH); //resize dimensions currently hardcoded
            ImageIcon imageIconBomb = new ImageIcon(dimgBomb);
            bomb.setIcon(imageIconBomb);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            try {
                imgBomb = ImageIO.read(new File("images/bomb2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimgBomb = imgBomb.getScaledInstance(150, 150, Image.SCALE_SMOOTH); //resize dimensions currently hardcoded
            ImageIcon imageIconBomb = new ImageIcon(dimgBomb);
            bomb.setIcon(imageIconBomb);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            try {
                imgBomb = ImageIO.read(new File("images/bomb1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimgBomb = imgBomb.getScaledInstance(150, 150, Image.SCALE_SMOOTH); //resize dimensions currently hardcoded
            ImageIcon imageIconBomb = new ImageIcon(dimgBomb);
            bomb.setIcon(imageIconBomb);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //bomb explosion animation
    public void bombExplode(){
        BufferedImage img = null;
        try {
            try {
                img = ImageIO.read(new File("images/explosion1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimg = img.getScaledInstance(250, 500, Image.SCALE_SMOOTH); //resize dimensions currently hardcoded
            ImageIcon imageIcon = new ImageIcon(dimg);
            bomb.setIcon(imageIcon);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // returns player's input aka player's guess once it has been checked
    public String sendCInput() {
        if (pInput == null) {
            cInput = "";
        } else {
            cInput = pInput.trim();
        }
        if (cInput != null && cInput != "") {
            // System.out.println(cInput);
        }
        return cInput;
    }

    //resets guess strings
    public void resetGuesses(){
        cInput = "";
        pInput = "";
    }

    public static void main(String[] args){
        new GUI();
    }
}
