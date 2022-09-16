import java.util.*;
import java.util.ArrayList;


class Player {
  String playerName = "";
  int lives = 3;
  ArrayList<String> lettersAvail = new ArrayList<String>();
  boolean isDead = false;
  boolean isTurn = false; 
  GUI gui = new GUI();
  String guess = "";

  public String getGuess() {
    return gui.sendGuess();
  }

  public void inputName(String name) {
      playerName = name;
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

    
}
