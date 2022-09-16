package javarush.criptoanalizer.utils;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce {
    public HashMap<Integer, Integer> bruteForceAttack(String alphabet) throws IOException {
        Decoder decoder = new Decoder();
        Scanner scanner = new Scanner(System.in);
        String pathStr = decoder.getPath(scanner);
        String checkString = null;

        Pattern patternEN = Pattern.compile("[a-z]\\.\s[A-Z]");
        Pattern patternRU = Pattern.compile("[а-я]\\.\s[А-Я]");
        Pattern pattern = Pattern.compile("\\.\s");
        HashMap<Integer, Integer> mapCounterMain = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathStr + "Decode.txt"))) {
            for (int i = 0; i < alphabet.length(); i++) {
                decoder.extracted(alphabet, pathStr, i);
                int counterMain = 0;
                int counterSecond = 0;
                int j = 0;
                while (bufferedReader.ready() || j < 100) {
                    checkString = bufferedReader.readLine();
                    Matcher matcherRU = patternRU.matcher(checkString);
                    Matcher matcherEN = patternEN.matcher(checkString);
                    Matcher matcher = pattern.matcher(checkString);
                    while (matcherEN.find()) {
                        if (matcherRU.matches()) {
                            counterMain++;
                        }
                    }
                    while (matcherEN.find()) {
                        if (matcherEN.matches()) {
                            counterMain++;
                        }
                    }
                    while (matcher.find()) {
                        if (matcher.matches()) {
                            counterSecond++;
                        }
                    }
                    j++;
                }

                mapCounterMain.put(i, counterMain);   // Записываем результаты в мапу
                if (counterMain < 2) {
                    mapCounterMain.put(i, counterSecond);
                }
            }
        }
        return mapCounterMain;
    }
}