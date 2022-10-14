package javarush.criptoanalizer.utils;

import javarush.criptoanalizer.model.LanguageMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public void startMenu(FileInitializer filesForWork) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Нажмите 1 если хотите закодировать файл по методу цезаря");
        System.out.println("Нажмите 2 если хотите раскодировать по Методу Цезаря");
        System.out.println("Нажмите 3 если хотите раскодировать по Методу BruteForce");
        String numMenuMethod = scanner.next();
        // Запрос выбора алфавита
        if (numMenuMethod.equals("1")) {
            System.out.println("Введите значения ключа шифрования");
            LanguageMap languageMap = new LanguageMap(scanner.nextInt());
            DecoderEncoder encoder = new DecoderEncoder();
            encoder.decode_encode(languageMap.encodeAlphabetMap, filesForWork );
        }
        if (numMenuMethod.equals("2")) {
            System.out.println("Введите значения ключа шифрования");
            LanguageMap languageMap = new LanguageMap(scanner.nextInt());
            DecoderEncoder decoder = new DecoderEncoder();
            decoder.decode_encode(languageMap.decodeAlphabetMap, filesForWork );
        }
        if (numMenuMethod.equals("3")) {
            BruteForce bruteForce = new BruteForce();
            bruteForce.bruteForceAttack()
            System.out.println("Сейчас система напечатает все доступные варианты ключей для данного алфавита\n Выберерите из возможных вариантов совпадений,\n с наибольшим результатом совпадений");
            System.out.println("Система предложит наиболее подходящие варианты");


            Map<Integer, Integer> mapKeyValue = bruteForce.bruteForceAttack(alphabet);   //Получаем мапу с наибольшими кол-ом совпадений
            ArrayList<Integer> values = (ArrayList<Integer>) mapKeyValue.values();      // и переделываем её в отсортированый список ключей
            Collections.sort(values);                                                   //от большого кол-ва совпадений к меньшему
            ArrayList<Integer> keyCollection = new ArrayList<Integer>();
            ArrayList arrayList = new ArrayList<Integer>();
            for (Integer keyValue : mapKeyValue.keySet()) {
                for (int i = values.size() - 1; i >= 0; i--) {
                    if (mapKeyValue.get(values) == values.get(i)) {
                        keyCollection.add(keyValue);
                    }
                }
            }
        }
    }
}
