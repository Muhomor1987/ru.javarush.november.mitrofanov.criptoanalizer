package javarush.criptoanalizer;


import javarush.criptoanalizer.model.Language;
import javarush.criptoanalizer.utils.BruteForce;
import javarush.criptoanalizer.utils.Decoder;
import javarush.criptoanalizer.utils.Encode;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
                    decoder.decode(alphabet, scanner.nextInt());
                }
                if (way.equals("2")) {
                    BruteForce bruteForce = new BruteForce();
                    System.out.println("Сейчас система напечатает все доступные варианты ключей для данного алфавита\n Выберерите из возможных вариантов совпадений,\n с наибольшим результатом совпадений");
                    System.out.println("Система предложит наиболее подходящие варианты");

                    HashSet<Integer> k1ey = new HashSet<>();
                    ArrayList<Integer> value = (ArrayList<Integer>) bruteForce.bruteForceAttack(alphabet).values();
                    System.out.println("Наиболее подходящие ключи для дешифровки");
                    System.out.println("Максимальное количесво совпадений с ключом " + value.get(value.size() - 1));
                    System.out.println("Максимальное количесво совпадений с ключом " + value.get(value.size() - 2));
                    System.out.println("Максимальное количесво совпадений с ключом " + value.get(value.size() - 3));

                    System.out.println("Введите значения наиболее подходящего ключа и посмотретите дешифрованый файл Decode.txt");
                    System.out.println("Если текст расщифрован напишите OK");
                    Decoder decoder = new Decoder();
                    String keyMax = scanner.nextLine();
                    for (int i = 0; i < 3; i++) {
                        if (!keyMax.equals("OK")) {
                            try {
                                decoder.decode(alphabet, scanner.nextInt());
                            } catch (IOException e) {
                                System.out.println("Ключ введён неверно");
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    System.out.println("Делее выведен список с мением кол-вом сопадений");
                    for (int i = value.size()-4; i >=0; i--) {
                        System.out.println(value.get(i));
                    }
                    System.out.println("Пробуйте и проверяйте следующие ключи");
                    while (true) {
                        if (!keyMax.equals("OK")) {
                            try {
                                decoder.decode(alphabet, scanner.nextInt());
                            } catch (IOException e) {
                                System.out.println("Ключ введён неверно");
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
    }
}
