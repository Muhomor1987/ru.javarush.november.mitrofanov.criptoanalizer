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

        Pattern patternEN = Pattern.compile("[a-z]\\.\s[A-Z]");     //Используя регулные выражения
        Pattern patternRU = Pattern.compile("[а-я]\\.\s[А-Я]");     //Вводим парамтры поиска сопадений
        Pattern pattern = Pattern.compile("\\.\s");                 // для дешт=ифрованного текста, на предмет мал.буква точка пробел большая буква
        HashMap<Integer, Integer> mapCounterMain = new HashMap<>();       //Создаём мапу с значениями ключа использованого для дешифровки от 1 до размера алфавита -1
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathStr + "Decode.txt"))) {
            for (int i = 0; i < alphabet.length(); i++) {
                decoder.extracted(alphabet, pathStr, i);            //Используем метод декодирования со значением ключа равного i
                int counterMain = 0;
                int counterSecond = 0;
                int j = 0;
                while (bufferedReader.ready() || j < 100) {         //Берём по строчноиз декодированного текста данные не более 100 строк
                    checkString = bufferedReader.readLine();
                    Matcher matcherRU = patternRU.matcher(checkString);
                    Matcher matcherEN = patternEN.matcher(checkString);
                    Matcher matcher = pattern.matcher(checkString);
                    while (matcherEN.find()) {                       //И проверяем кол-во совпадений в строках, заиписываем их в переменную counter
                        if (matcherRU.matches()) {
                            counterMain++;
                        }
                    }
                    while (matcherEN.find()) {
                        if (matcherEN.matches()) {
                            counterMain++;
                        }
                    }
                    while (matcher.find()) {                        //Здесь так же обрабатываем значения точка пробел
                        if (matcher.matches()) {
                            counterSecond++;
                        }
                    }
                    j++;
                }

                mapCounterMain.put(i, counterMain);   // Записываем в мапу значения ключа и количесво сопадений по патерну
                if (counterMain < 2) {
                    mapCounterMain.put(i, counterSecond); //если кол -во совпадений По(а. А) меньше 2х записываем в мапу кол-во сопадений по (точка пробел).
                }
            }
        }
        return mapCounterMain;  //отдаём мапу со значениями ключ для шифрования(К) и кол-вом совпадений(V)
    }
}