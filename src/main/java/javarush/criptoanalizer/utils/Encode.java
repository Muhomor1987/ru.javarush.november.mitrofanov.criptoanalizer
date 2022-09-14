package javarush.criptoanalizer.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Encode {
    public void encode(String alphabet){
        Scanner scanner = new Scanner(System.in);
        String pathStr = getString(scanner);
        //Decoder
        System.out.println("Введите число для шифорвания");
        int key = scanner.nextInt();
        encode(alphabet, pathStr, key);

    }

    private static void encode(String alphabet, String pathStr, int key) {
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(pathStr + "Decode.txt"));
             BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(pathStr + "Encode.txt"))) {
            HashMap<Character, Character> mapAlphabet = new HashMap<>();
            int attempt = 5;
            while (attempt > 0) {
                try {
                    if (key < 0) {
                        throw new IOException();
                    }
                    if (key > alphabet.length()) {
                        key = alphabet.length() % key;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Некорректный ввод данных");
                    System.out.println("Осталось " + (attempt - 1) + " попытки");
                    attempt--;
                }
            }   //Ввод ключа с клавиатуры
            System.out.println("Идёт обработка");
            for (int i = 0; i < alphabet.length(); i++) {
                if ((i + key < alphabet.length())) {
                    mapAlphabet.put(alphabet.charAt(i), alphabet.charAt(i + key));
                } else {
                    mapAlphabet.put(alphabet.charAt(i), alphabet.charAt((i + key) - alphabet.length()));
                }

            }// Заполнение map алфавита для кодировки по Цезарю
            //ЗАПИСЫВАЕМ В СТРИГ БИЛДЕР значения буфера считаного текста и сразу обрабатываем строку и записываем в файл
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
            System.out.println("Указаный файл отсутвует по данному адресу");
        }
    }

    private static String getString(Scanner scanner) {
        System.out.println("""
                        Укажите путь к текстовым файлам(.txt),
                        Скопируйте нужный файл в данную траекторию и назовите его "Decode.txt",
                        После выполнения программы в файле Encode.txt в указаной папке появиться зашифрованый текст""");
        String pathStr = scanner.next();
        try {
            File file = new File(pathStr + "Encode.txt");
        } catch (Exception e) {
            System.out.println("Ошибка создания файла записи");
        }
        return pathStr;
    }
}
