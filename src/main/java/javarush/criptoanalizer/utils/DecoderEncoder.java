package javarush.criptoanalizer.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class DecoderEncoder {
    public void decode_encode(HashMap<Character, Character> mapAlphabet, FileInitializer filesForWork) {

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(filesForWork.fileData));
             BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(filesForWork.fileResult))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferReader.ready()) {
                char symbol = (char) bufferReader.read();
                if (mapAlphabet.containsKey(symbol)) {
                    stringBuilder.append(mapAlphabet.get(symbol));
                } else {
                    stringBuilder.append(symbol);
                }
            }
            bufferWriter.append(stringBuilder);
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
