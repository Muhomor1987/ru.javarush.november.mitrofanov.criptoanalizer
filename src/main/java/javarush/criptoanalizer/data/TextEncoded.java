package javarush.criptoanalizer.data;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TextEncoded {
    File textNotEncoder = new File("D:\\IJ\\ru.javarush.november.mitrofanov.criptoanalizer\\src\\main\\java\\javarush\\criptoanalizer\\files\\TextEncoder.txt");
    public void writer(ArrayList<Character> chars) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(textNotEncoder))){
            writer(chars);
        }
    }
}
