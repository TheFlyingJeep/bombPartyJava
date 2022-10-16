import java.util.ArrayList;
import java.io.*;
import java.rmi.server.UID;
import java.util.*; 
import java.util.Scanner;
import java.util.Random;
import java.util.TimerTask;

public class Game{
  Timer timer;
  Dictionary dictionary;
    public static void main(String[] args) {
      //make a method that calls dictionary class, .contains//

      //Variables

        //ArrayList for Players
        Scanner myName = new Scanner(System.in);
        ArrayList<String> playerNames = new ArrayList<String>();
        
        //Timer//
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        thread.start();
             
        
        //Random number generator//
        Random num = new Random();
        int ranNum = 0;

        //For loop runs through arrayList||Implements ranNum generator, if num=1 end players turn, if num=2,3 add seconds// 
        //for (int j = 0; j < playerNames.size(); j++) {
          for(int i = 0; i < 1; i++) {
              ranNum = num.nextInt(3);
              //System.out.println(ranNum);
          }

          if(ranNum == 1) {
            System.out.print("end");
          } else {
            //thread.start();
          }
        //}
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
    for(int i = 30; i >= 0; i--) { 
      try {
        Thread.sleep(1000);
        if (i == 0) {
          System.out.println("0");
          Random num = new Random();
          int ranNum = 0;
          ranNum = num.nextInt(3);
          if (ranNum == 0 || ranNum == 1) {
            break;
          } else {
            i +=5;
          }
        }
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


