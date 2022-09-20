import java.util.ArrayList;
import java.io.*;
import java.rmi.server.UID;
import java.util.*; 
import java.util.Scanner;
import java.util.Random;

public class Game{
  Timer timer;
    public static void main(String[] args) {
        //Variables
        int times = 0;
        int timerLength = 0;

        //ArrayList for Players
        Scanner myName = new Scanner(System.in);
        ArrayList<String> playerNames = new ArrayList<String>();
        //playerNames.add();
        
        //Timer//
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        thread.start();
             
        
        //Random number generator//
        Random num = new Random();
        int ranNum = 0;

        //For loop runs through arrayList||Implements ranNum generator, if num=1 end players turn, if num=2,3 add seconds// 
        //for (int j = 0; j < playerNames.size(); j++) {
          for(int i = 0; i < 20; i++) {
              ranNum = num.nextInt(3);
              System.out.println(ranNum);
          }
          if(ranNum == 1) {
            timerLength = 0;
          } else {
            timerLength += 5;
          }
      }

    

    
    public void sendPlayerData(){

    }

    public void getPlayers(){

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

//Timer class//
class Timer implements Runnable{
  @Override
  public void run(){
    for(int i = 5; i > 0; i--) {
      try {
        Thread.sleep(1000);
        System.out.println(i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Player {
  String playerName;
  public void getPlayer(String playerName){
    this.playerName = playerName;
  }
  //return this.playerName;
}


