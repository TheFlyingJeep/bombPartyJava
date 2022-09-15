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
        //Variables
        int times = 0;
        //ArrayList for Players
        Scanner myName = new Scanner(System.in);
        ArrayList<String> playerNames = new ArrayList<String>();

        playerNames.add();
        

        //Timer
        /*Timer timer = new Timer();
		    TimerTask task = new Helper();
        while(times < 5) {
        timer.schedule(task, 1000, 1000);
        times++;
        
        }
        timer.cancel();
        */
        //Random number generator
        Random num = new Random();
        int ranNum;

        //For loop runs through arrayList||Implements ranNum generator 
        for (int j = 0; j < playerNames.size(); j++) {
          for(int i = 0; i < 20; i++) {
              ranNum = num.nextInt(3);
              System.out.println(ranNum);
          }

          /*if(ranNum == 1) {
            
          } else {
            
          }*/
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

class Helper extends TimerTask {
  public static int i = 0;
  public void run() {
      System.out.println("Timer ran: " + ++i);     
  }
}


    


    

