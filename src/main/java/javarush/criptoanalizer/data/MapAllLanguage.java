package javarush.criptoanalizer.data;

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
        String languageCut; //Use language name to reduce
        ArrayList<Character> charAlphabet; //Values for list of characters



        public Alphabet(String languageCut, ArrayList<Character> charAlphabet) {
            this.languageCut = languageCut;
            this.charAlphabet = charAlphabet;
        }
        //Constructor for Alphabet


    }
}
