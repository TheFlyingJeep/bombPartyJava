//not github

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
class Dictionary{
    HashSet<String> set = new HashSet();


    static ArrayList<String> usedWords = new ArrayList<String>();
    static ArrayList<String> usedPrompts = new ArrayList<String>();

    public Dictionary(){

    }


    public void start(){
        int start = 0;
        int stop = 58108;
        try {

            File file = new File("C:/JavaPrograms/InteliJ/bomb game/src/dictionary.txt");
            while (start <= stop) {
                String line = Files.readAllLines(Paths.get("C:/JavaPrograms/InteliJ/bomb game/src/dictionary.txt")).get(start);
              System.out.println(line);
                set.add(line);
                start++;
            }


        }
        catch (Exception e){
            e.printStackTrace();
            //does nothing cause its literallt not possible to have an error here idfk what replit is talking about
        }

    }

    public boolean checkWord(String input) {
        input = input.toUpperCase();
        return set.contains(input);
    }

    public void addUsed(String word){
        usedWords.add(word);
    }

    public boolean checkUsed(String word){
        for(String usedWord : usedWords){
            if(usedWord.equals(word)){
                return false;
            }

        }
        return true;
    }

    public void addPrompt(String prompt){
        usedPrompts.add(prompt);
    }

    public boolean checkPrompt(String prompt){
        for(String usedPrompt : usedPrompts){
            if(usedPrompt.equals(prompt)){
                return false;
            }

        }
        return true;
    }
}