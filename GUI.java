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
            letters, wordDisplay, credits, hearts, logo, prompt;
    JTextField nameInput, playerInput;
    JButton enterNameButton, enterButton;
    JPanel panelName;

    String pInput, cInput;
    String lettersLeftDisplay = "<html>A B C D E F G H I J K<br/>L M N O P Q R S T U</html>";
    ArrayList<String> lettersLeft = new ArrayList<String>();
    boolean isInValid = true;

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
            System.out.println(playerName);
            nameFrame.setVisible(false);
            gameFrame.setVisible(true);
        }
    }

    //action listener for enter key NAME SCREEN
    class nameEnterKeyListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String playerName = nameInput.getText();
            nameInput.setText("");
            System.out.println(playerName);
            nameFrame.setVisible(false);
            gameFrame.setVisible(true);
        }
    }

    //game window
    public void createGameWindow(){
        //game screen
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
        logo = new JLabel("blow up bash!");
        credits = new JLabel("blow up bash! was inspired by JKLM's BombParty");
        playerInput = new JTextField();
        enterButton = new JButton("Enter");
        wordDisplay = new JLabel(pInput);
        prompt = new JLabel("prompt");

        gameFrame.setSize(700,500); //width, height
        gameFrame.setLayout(grid);
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
        gameFrame.add(logo);
        gameFrame.add(credits);
        gameFrame.add(playerInput);
        gameFrame.add(enterButton);
        gameFrame.add(wordDisplay);
        gameFrame.add(prompt);

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
        playerOne.setText(names[1]);
        playerTwo.setText(names[2]);
        playerThree.setText(names[3]);
        playerFour.setText(names[4]);
        playerFive.setText(names[5]);
        playerSix.setText(names[6]);
        playerSeven.setText(names[7]);
        playerEight.setText(names[8]);
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

    //returns player's input aka player's guess once it has been checked
    public String sendCInput(){
        if(pInput == null){
            cInput = "";
        } else {
            cInput = pInput.trim();
        }
        System.out.println(cInput);
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
