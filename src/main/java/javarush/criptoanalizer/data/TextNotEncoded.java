package javarush.criptoanalizer.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextNotEncoded {
    File textNotEncoder = new File("D:\\IJ\\ru.javarush.november.mitrofanov.criptoanalizer\\src\\main\\java\\javarush\\criptoanalizer\\files\\TextNotEncoder.txt");
    //Create path to file
    ArrayList<Character> letters = new ArrayList<Character>();
    //Create list of characters
    public ArrayList<Character> textNotEncoderToArray() throws IOException {      //can be converted into a separate method for reading files
        try(BufferedReader textReader = new BufferedReader(new FileReader(textNotEncoder))) {
            while (textReader.ready()) {
                letters.add((char) textReader.read());
            }
        }
        return letters;
    }
    //add method to create list of characters
}
