import java.util.ArrayList;
import java.io.*;
import java.rmi.server.UID;
import java.util.*; 
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        //ArrayList for Players
        Scanner myName = new Scanner(System.in);
        ArrayList<UUID> playerNames = new ArrayList<UUID>();
        //UUID id = playerNames.getUniqueID();
        for(int i = 0; i < 5; i++) {
            playerNames.add(playerNames);
        }

        //Random number generator
        Random num = new Random();
        int ranNum;
        //
        for (int j = 0; j < playerNames.size(); j++) {
          for(int i = 0; i < 20; i++) {
              ranNum = num.nextInt(3);
              System.out.println(ranNum);
          }

          if(ranNum == 1) {
            
        } 
      }

    }
    public void sendPlayerData(){

    }
    /*public static String prompt(){
        //testing alphatbet 
        String alphabet = "aeioumnlprt";
        int numChars = (int) ((Math.random() * (4 - 2)) + 2);
        String prompt = "";
    
        for(int i = 0; i < numChars; i++){
          int rand = (int) ((Math.random() * (11 - 1)) + 1);
        prompt += alphabet.charAt(rand);
        }
    
    
    
        while(!checkPrompt(prompt)){
          prompt = ""; 
          for(int i = 0; i < numChars; i++){
            int rand = (int) ((Math.random() * (11 - 1)) + 1);
            prompt += alphabet.charAt(rand);
          }
        }
    
        usedPrompts.add(prompt); 
        return prompt; 
      }*/
}

/*class Helper extends TimerTask {
    
}*/

    


    

