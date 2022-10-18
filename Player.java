import java.util.*;
import java.util.ArrayList;
import java.io.IOException;
import java.net.Socket;

class Player {
  String playerName = "";
  int lives = 3;
  ArrayList<String> lettersAvail = new ArrayList<String>();
  boolean isDead = false;
  boolean isTurn = false;
  static int nameAgain = 0;
  GUI gui;
  String guess = "";
  Client client;
  Socket socket;
  Thread clientThread;
  int playerNumber;

  public Player() {
    gui = new GUI();
    do{
      playerName = gui.getPlayerName();
      if(playerName.equals("") && nameAgain > 0){
        gui.updateNamePrompt();
      }
    }
    while(playerName == null || playerName.equals(""));
    try {
      socket = new Socket("flippinnublet.com", 7268);
    } catch (IOException e) {
      e.printStackTrace();
    }
    client = new Client(socket);
    clientThread = new Thread(client);
    clientThread.start();
    // try {
    //   Thread.sleep(100);
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    client.sendGuess(playerName);
    theLoop();
  }

  public void letterAdd() {
    lettersAvail.add("A");
    lettersAvail.add("B");
    lettersAvail.add("C");
    lettersAvail.add("D");
    lettersAvail.add("E");
    lettersAvail.add("F");
    lettersAvail.add("G");
    lettersAvail.add("H");
    lettersAvail.add("I");
    lettersAvail.add("J");
    lettersAvail.add("I");
    lettersAvail.add("K");
    lettersAvail.add("L");
    lettersAvail.add("M");
    lettersAvail.add("N");
    lettersAvail.add("O");
    lettersAvail.add("P");
    lettersAvail.add("Q");
    lettersAvail.add("R");
    lettersAvail.add("S");
    lettersAvail.add("T");
    lettersAvail.add("U");
  }

  public int lifeRemove(boolean timeGone) {
    if (timeGone) {
      lives--;
    }
    return lives;
  }

  public int lifeAdd() {
    if (lettersAvail.size() == 0) {
      lives++;
    }
    return lives;
  }

  public ArrayList<String> updateUsedLetters(String used) {
    for (int i = 0; i < lettersAvail.size(); i++) {
      String a = lettersAvail.get(i);
      if (used.equals(a)) {
        lettersAvail.remove(i);
      }
    }

    if (lettersAvail.size() == 0) {
      letterAdd();
    }
    return lettersAvail;
  }

  public ArrayList<String> sendLetters() {
    return lettersAvail;
  }

  public void theLoop() {
    while (true) {
      String data = client.data;
      System.out.println((data != null) ? data : "null");
      if (!data.equals("") && data != null) {
        if (data.equals("turn") && !isDead) {
          isTurn = true;
        }
        String[] dataArr = data.split(",");
        if (dataArr != null &&  !data.equals("turn")) {
          switch (dataArr[0].toLowerCase()) {
            case "prompt":
              gui.bombTicking();
              gui.getPrompt(dataArr);
              break;
            case "names":
              gui.getNames(dataArr);
              client.data = "";
              break;
            case "lives":
              gui.getLives(dataArr);
              client.data = "";
              break;
            case "correct":
              gui.setInputDisplay(dataArr);
              if (isTurn) {
                isTurn = false;
              }
              break;
            case "incorrect":
              gui.setInputDisplay(dataArr);
              break;
            case "timer":
              if (isTurn) {
                lives--;
                gui.updateLives(lives);
                gui.bombExplode();
                if (lives <= 0) {
                  isDead = true;
                  gui.setTurn("ur dead :(");
                }
                isTurn = false;
                gui.setTurn("Not your turn");
              }
              break;
            case "turn":
              if (dataArr[1].equals("true")) {
                isTurn = true;
                gui.setTurn("Your turn!");
              } else {
                isTurn = false;
                gui.setTurn("Not your turn!");
              }
              break;
            default:
              break;
          }
        }
        dataArr = null;
        data = "";
        client.data = "";
      }
      if (isTurn) {
        String guess = gui.sendCInput();
        if (!guess.equalsIgnoreCase("")) {
          client.sendGuess(guess);
          gui.resetGuesses();
        }
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
