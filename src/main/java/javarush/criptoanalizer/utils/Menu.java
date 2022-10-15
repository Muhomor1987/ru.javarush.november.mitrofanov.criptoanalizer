package javarush.criptoanalizer.utils;

import javarush.criptoanalizer.model.AlphabetMap;
import javarush.criptoanalizer.model.Language;

import java.io.IOException;

import java.util.Scanner;

public class Menu {
    public void startMenu(FileInitializer filesForWork, Language language) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нажмите 1 если хотите закодировать файл по методу цезаря");
        System.out.println("Нажмите 2 если хотите раскодировать по Методу Цезаря");
        System.out.println("Нажмите 3 если хотите раскодировать по Методу BruteForce");
        String numMenuMethod = scanner.next();
        // Запрос выбора алфавита
        if (numMenuMethod.equals("1")) {
            System.out.println("Введите значения ключа шифрования");
            AlphabetMap alphabetMap = new AlphabetMap(language.charts, scanner.nextInt());
            DecoderEncoder encoder = new DecoderEncoder();
            encoder.decode_encode(alphabetMap.encodeAlphabetMap, filesForWork);
        }
        if (numMenuMethod.equals("2")) {
            System.out.println("Введите значения ключа шифрования");
            AlphabetMap alphabetMap = new AlphabetMap(language.charts, scanner.nextInt());
            DecoderEncoder decoder = new DecoderEncoder();
            decoder.decode_encode(alphabetMap.decodeAlphabetMap, filesForWork);
        }
        if (numMenuMethod.equals("3")) {
            BruteForce bruteForce = new BruteForce();
            bruteForce.bruteForceAttack(language, filesForWork);
        }
    }
}

