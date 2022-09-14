package javarush.criptoanalizer.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Decoder {
    public static void decode(String alphabet) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String pathStr = getPath(scanner);
        int key = scanner.nextInt();
        key = getKey(alphabet, key);
        extracted(alphabet, pathStr, key);
    }

    private static int getKey(String alphabet, int key) {
        int attempt = 5;
        while (attempt > 0) {
            try {
                // обработка значений ключа
                if (key < 0) {
                    throw new IOException();
                }
                if (key > alphabet.length()) {
                    key = alphabet.length() % key;
                }
                attempt = 0;
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных");
                System.out.println("Осталось " + (attempt - 1) + " попытки");
                attempt--;
            }
        }
        return key;
    }

    private static void extracted(String alphabet, String pathStr, int key) {
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(pathStr + "Encode.txt"));
             BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(pathStr + "Decode.txt"))) {
            HashMap<Character, Character> mapAlphabet = new HashMap<>();
  // Заполнение map алфавита для кодировки по Цезарю
            for (int i = 0; i < alphabet.length(); i++) {
                if ((i + key < alphabet.length())) {
                    mapAlphabet.put(alphabet.charAt(i + key), alphabet.charAt(i));
                } else {
                    mapAlphabet.put(alphabet.charAt((i + key) - alphabet.length()), alphabet.charAt(i));
                }
            }
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

    private static String getPath(Scanner scanner) {
        System.out.println("""
                    Укажите путь к текстовым файлам(.txt),
                    Скопируйте нужный файл в данную траекторию и назовите его "Encode.txt",
                    После выполнения программы в файле Decode.txt в указаной папке появиться рашифрованый текст""");
        String pathStr = scanner.next();
        try {
            File file = new File(pathStr + "Decode.txt");
        } catch (Exception e) {
            System.out.println("Ошибка создания файла записи");
        }
        System.out.println("Введите ключ");
        return pathStr;

    }
}
