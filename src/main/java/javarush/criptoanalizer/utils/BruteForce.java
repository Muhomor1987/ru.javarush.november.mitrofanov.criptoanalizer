package javarush.criptoanalizer.utils;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce {
    public void bruteForceAttack(String alphabet) throws IOException {
        Decoder decoder = new Decoder();
        Scanner scanner = new Scanner(System.in);
        String pathStr = decoder.getPath(scanner);
        String checkString = null;
        int counter = 0;
        Pattern patternEN = Pattern.compile("[a-z]\\.\s[A-Z]");
        Pattern patternRUS = Pattern.compile("[а-я]\\.\s[А-Я]");
        Pattern patternUK = Pattern.compile("[а-я]\\.\s[А-Я]");
        Pattern patternBY = Pattern.compile("[а-я]\\.\s[А-Я]");
        for (int i = 0; i < alphabet.length(); i++) {
            decoder.extracted(alphabet, pathStr, i);

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathStr + "Decode.txt"))) {
                checkString = bufferedReader.readLine();
                Matcher matcher = pattern.matcher(checkString);
                if(matcher.matches()){
                    counter++;
                }
            }
            // Проверку делаем файла
        }

    }
}