package javarush.criptoanalizer;

import javarush.criptoanalizer.IO.DownloadAlphabet;
import javarush.criptoanalizer.data.MapAllLanguage;


import java.io.IOException;



public class Runner {
    public static void main(String[] args) throws IOException {
        DownloadAlphabet downloadAlphabet = new DownloadAlphabet(); //Creates a new DownloadAlphabet object
        System.out.println(downloadAlphabet.alphabetCreate());//Check download Alphabet is right
        MapAllLanguage mapAllLanguage = new MapAllLanguage(); //Creates a new MapAll
        MapAllLanguage.Alphabet alphabetRus = new MapAllLanguage.Alphabet("RUS",downloadAlphabet.alphabetCreate());
        //mapAllLanguage.alphabetAdd(alphabetRus);     //don`t work                      //add alphabet to alphabet map
        //System.out.println(mapAllLanguage.alphabetGet("RUS"));      //get alphabet from alphabet mapAllLanguage
        //Сan add other languages and language recognition...

    }
}
