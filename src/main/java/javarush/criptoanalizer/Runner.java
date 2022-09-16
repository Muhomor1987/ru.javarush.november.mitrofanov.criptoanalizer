package javarush.criptoanalizer;


import javarush.criptoanalizer.model.Language;
import javarush.criptoanalizer.utils.Decoder;
import javarush.criptoanalizer.utils.Encode;

import java.io.*;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws IOException {
        boolean toWork = true;
        while (toWork) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Нажмите 1 если хотите закодировать файл по методу цезаря");
            System.out.println("Нажмите 2 если хотите раскодировать файл");
            System.out.println("Нажмите 3 если хотите выйти из программы");
            String menu = scanner.next();
            String alphabet = new Language().getAlphabet();   // Запрос выбора алфавита
            if (menu.equals("1")) {
                Encode encode = new Encode();
                encode.encode(alphabet);
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

                    Decoder decoder = new Decoder();
                    System.out.println("Введите известный Вам ключ декодирования");
                    decoder.decode(alphabet,scanner.nextInt());
                }
                if(way.equals("2")) {
                    int key = 0;
                    Decoder decoder = new Decoder();
                    decoder.decode(alphabet,key);
                }
            }
        }
    }
}
