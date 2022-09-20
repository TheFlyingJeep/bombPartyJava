import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
class Dictionary{

    String word= "";

    static ArrayList<String> usedWords = new ArrayList<String>();
    static ArrayList<String> usedPrompts = new ArrayList<String>();

    public Dictionary(){

    }

    public Dictionary(String input){
        word = input;
    }


    public boolean checkWord(String input){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        input = input.toUpperCase();
        int start = 0;
        int stop = 0;
        if(input.charAt(0) == 'A'){
            start = 0;
            stop = 3479;
        }
        else if(input.charAt(0) == 'B'){
            start = 3480;
            stop = 6689;
        }
        else if(input.charAt(0) == 'C'){
            start = 6690;
            stop = 12182;
        }
        else if(input.charAt(0) == 'D'){
            start = 12183;
            stop = 15958;
        }
        else if(input.charAt(0) == 'E'){
            start = 15959;
            stop = 18546;
        }
        else if(input.charAt(0) == 'F'){
            start = 18547;
            stop = 21103;
        }
        else if(input.charAt(0) == 'G'){
            start = 21104;
            stop = 22939;
        }
        else if(input.charAt(0) == 'H'){
            start = 22940;
            stop = 24965;
        }
        else if(input.charAt(0) == 'I'){
            start = 24966;
            stop = 27638;
        }
        else if(input.charAt(0) == 'J'){
            start = 27639;
            stop = 28111;
        }
        else if(input.charAt(0) == 'K'){
            start = 28112;
            stop = 28465;
        }
        else if(input.charAt(0) == 'L'){
            start = 28466;
            stop = 30302;
        }
        else if(input.charAt(0) == 'M'){
            start = 30303;
            stop = 33246;
        }
        else if(input.charAt(0) == 'N'){
            start = 33247;
            stop = 34165;
        }
        else if(input.charAt(0) == 'O'){
            start = 34166;
            stop = 35553;
        }
        else if(input.charAt(0) == 'P'){
            start = 35554;
            stop = 40116;
        }
        else if(input.charAt(0) == 'q'){
            start = 40117;
            stop = 40406;
        }
        else if(input.charAt(0) == 'R'){
            start = 40407;
            stop = 44040;
        }
        else if(input.charAt(0) == 'S'){
            start = 44041;
            stop = 50710;
        }
        else if(input.charAt(0) == 'T'){
            start = 50711;
            stop = 53591;
        }
        else if(input.charAt(0) == 'U'){
            start = 53592;
            stop = 55512;
        }
        else if(input.charAt(0) == 'V'){
            start = 55513;
            stop = 56323;
        }
        else if(input.charAt(0) == 'W'){
            start = 56324;
            stop = 57865;
        }
        else if(input.charAt(0) == 'X'){
            start = 57865;
            stop = 57879;
        }
        else if(input.charAt(0) == 'Y'){
            start = 57880;
            stop = 58023;
        }
        else if(input.charAt(0) == 'Z'){
            start = 58024;
            stop = 58109;
        }
        try {

            File file = new File("C:/JavaPrograms/InteliJ/bomb game/src/dictionary.txt");

            // Scanner scan = new Scanner(file);
            if(alphabet.indexOf(input.charAt(1)) < 12) {
                while (start <= stop) {
                    String line = Files.readAllLines(Paths.get("C:/JavaPrograms/InteliJ/bomb game/src/dictionary.txt")).get(start);
                    System.out.println(input.charAt(1));
                    if (input.equals(line)) {
                        return true;
                    }
                    start++;
                }
                return false;
            }
            else{
                int temp = start;
                start = stop;
                stop = temp;
                while (start >= stop) {
                    String line = Files.readAllLines(Paths.get("C:/JavaPrograms/InteliJ/bomb game/src/dictionary.txt")).get(start);
                    System.out.println(line);
                    if (input.equals(line)) {
                        return true;
                    }
                    start--;
                }
                return false;
            }

        } catch (Exception e){
            e.printStackTrace();
            return false;
            //does nothing cause its literallt not possible to have an error here idfk what replit is talking about
        }
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


