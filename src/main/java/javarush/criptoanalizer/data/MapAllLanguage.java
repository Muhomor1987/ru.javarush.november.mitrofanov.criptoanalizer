package javarush.criptoanalizer.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MapAllLanguage {
HashMap<String, Alphabet> mapAllLanguage;  //Map of language
    public void alphabetAdd(Alphabet alphabet) {
        mapAllLanguage.put(alphabet.languageCut, alphabet);
    }
    //add a new alphabet to the list
    public Alphabet alphabetGet(String languageCut){
        return mapAllLanguage.get(languageCut);
    }
    //Get the language from the map
    public static class Alphabet {
        File alphabet = new File("D:\\ProjectMy\\ru.javarush.november.mitrofanov.criptoanalizer\\src\\main\\java\\javarush\\criptoanalizer\\files\\RUS_Alphabet.txt");
        String languageCut; //Use language name to reduce
        ArrayList<Character> charAlphabet; //Values for list of characters
        int length=0;



        public Alphabet(String languageCut, ArrayList<Character> charAlphabet) {
            this.languageCut = languageCut;
            this.charAlphabet = charAlphabet;
        }
        //Constructor for Alphabet

        public ArrayList<Character> alphabetToArray() throws IOException {      //can be converted into a separate method for reading files
            try(BufferedReader textReader = new BufferedReader(new FileReader(alphabet))) {
                while (textReader.ready()) {
                    charAlphabet.add((char) textReader.read());
                }
            }
            return charAlphabet;
        }
        public int length(Alphabet alphabet) throws IOException {
            return alphabet.alphabetToArray().size();
        }

    }
}
