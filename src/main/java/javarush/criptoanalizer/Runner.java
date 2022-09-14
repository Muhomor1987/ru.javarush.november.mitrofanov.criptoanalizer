package javarush.criptoanalizer;



import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws IOException {
        boolean toWork = true;
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ(.,””:-!? )";
        while (toWork) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Нажмите 1 если хотите закодировать файл по методу цезаря");
            System.out.println("Нажмите 2 если хотите раскодировать файл");
            System.out.println("Нажмите 3 если хотите выйти из программы");
            String menu = scanner.next();
            if (menu.equals("1")) {
                System.out.println("""
                        Укажите путь к текстовым файлам(.txt),
                        Скопируйте нужный файл в данную траекторию и назовите его "Decode",
                        После выполнения программы в файле Encode.txt в указаной папке появиться зашифрованый текст""");
                String pathStr = scanner.next();
                try {
                    File file = new File(pathStr + "Encode.txt");
                } catch (Exception e) {
                    System.out.println("Ошибка создания файла записи");
                }
                //Decoder
                try (BufferedReader bufferReader = new BufferedReader(new FileReader(pathStr + "Decode.txt"));
                     BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(pathStr + "Encode.txt"))) {
                    HashMap<Character, Character> mapAlphabet = new HashMap<>();
                    System.out.println("Введите число для шифорвания");
                    int key = 0;
                    int attempt = 5;
                    while (attempt > 0) {
                        try {
                            key = Integer.parseInt(scanner.next());
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
            if (menu.equals("2")) {
                System.out.println("""
                        Выбирите способ раскодирования ...
                        1-методом цезаря
                        2-методом BruteForce
                        3-методом статистического анализа
                        Введите цифру с выбраным методом
                        """);
                String way = scanner.next();
                if (way.equals("1")) {
                    System.out.println("""
                            Укажите путь к текстовым файлам(.txt),
                            Скопируйте нужный файл в данную траекторию и назовите его "Encode",
                            После выполнения программы в файле Decode.txt в указаной папке появиться зашифрованый текст""");
                    String pathStr = scanner.next();
                    try {
                        File file = new File(pathStr + "Decode.txt");
                    } catch (Exception e) {
                        System.out.println("Ошибка создания файла записи");
                    }
                    //Decoder
                    try (BufferedReader bufferReader = new BufferedReader(new FileReader(pathStr + "Encode.txt"));
                         BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(pathStr + "Decode.txt"))) {
                        HashMap<Character, Character> mapAlphabet = new HashMap<>();
                        System.out.println("Введите ключ");
                        int key = 0;
                        int attempt = 5;
                        while (attempt > 0) {
                            try {
                                key = Integer.parseInt(scanner.next());
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
                        }   //Ввод ключа с клавиатуры
                        for (int i = 0; i < alphabet.length(); i++) {
                            if ((i + key < alphabet.length())) {
                                mapAlphabet.put(alphabet.charAt(i + key), alphabet.charAt(i));
                            } else {
                                mapAlphabet.put(alphabet.charAt((i + key) - alphabet.length()), alphabet.charAt(i));
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
                if (way.equals("3")) {
                    System.out.println("Программа закрыта");
                    toWork = false;
                }
            }
        }
    }
}
