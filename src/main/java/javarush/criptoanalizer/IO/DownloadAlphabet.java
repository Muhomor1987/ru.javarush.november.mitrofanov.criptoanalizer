package javarush.criptoanalizer.IO;

import java.io.*;
import java.util.ArrayList;

public class DownloadAlphabet  {
    File alphabetText = new File("D:\\IJ\\ru.javarush.november.mitrofanov.criptoanalizer\\src\\main\\java\\javarush\\criptoanalizer\\files\\RUS_Alphabet.txt");
    //Create path to file
    ArrayList<Character> letters = new ArrayList<Character>();
    //Create list of characters
    public ArrayList<Character> alphabetCreate() throws IOException {
        try(BufferedReader alphabetReader = new BufferedReader(new FileReader(alphabetText))) {
            while (alphabetReader.ready()) {
                    letters.add((char) alphabetReader.read());
            }
        }
        return letters;
    }
    //add method to create list of characters
}
