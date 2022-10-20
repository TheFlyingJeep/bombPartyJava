import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
class Dictionary{


    List dictionary;
    static ArrayList<String> usedWords = new ArrayList<String>();

    public Dictionary(){
        try {

            List<String> set = Files.readAllLines(Paths.get("C:/JavaPrograms/InteliJ/bomb game/src/dictionary.txt"));
            File file = new File("C:/JavaPrograms/InteliJ/bomb game/src/dictionary.txt");
            dictionary = set;
        }
        catch (Exception e){
            e.printStackTrace();
            //does nothing cause its literallt not possible to have an error here idfk what replit is talking about
        }



    }
    //check if word contains the prompt
    public boolean validWord(String w, String p){
        if(w.contains(p)){
            return true;
        }
        return false;
    }


    // check if word exists in dictionary
    public boolean checkWord(String input) {
        input = input.toUpperCase();
        return dictionary.contains(input);
    }
    //create a 2 or 3 letter prompt
    public String createPrompt(){
        String[] prompts = {"con","hea","car","ivi","ump","ive","es","ic","ks","tr","to","bil","sts","tt","wr","omi","ti","ap","rk","en","op","ial","omp","arr","sm","ie","on","nis","ron","fl","ns","lo","ns","no","nds","tr","an","li","re","ut","tim","chi","an","oth","pe","ent","amp","is","al","mo","er","tio","fi","ilo","nes","ch","nt","in","gge","er","sti","bl","ha","din","un","le","in","sms","ba","bu","lu","ra","ina","ni","io","ari","ret","go","con","ion","er","he","no","om","der","ch","pe","al","ant","is","ing","om","olo","per","ula","nch","ss","tha","esi","ano","hob","es","mat","al","te","ic","es","ing","nst","of","rh","su","dr","re","lo","al","po","ho","yp","is","eat","na","er","erg","co","pp","ea","no","rma","io","her","st","war","nc","lay","fa","ize","ba","rip","ze","og","his","oli","mat","ch","ism","rco","az","nce","oun","ar","ic","ph","hi","dar","qui","end","pr","ata","api","ss","sh","iv","utt","ed","ct","rc","iz","ram","at","pe","ip","ti","ut","els","ls","ck","mis","der","mi","nt","re","im","bal","uli","dio","ac","ali"};
        int rand = (int) ((Math.random() * (187)));
        return prompts[rand];
    }

    //add a word to the list of used words
    public void addUsed(String word){
        usedWords.add(word);
    }

    //check if a word has already been used
    public boolean checkUsed(String word){
        for(String usedWord : usedWords){
            if(usedWord.equals(word)){
                return false;
            }

        }
        return true;
    }
}



