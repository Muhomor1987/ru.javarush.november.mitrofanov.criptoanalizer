package javarush.criptoanalizer.utils;

import javarush.criptoanalizer.model.AlphabetMap;
import javarush.criptoanalizer.model.Language;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce {
    DecoderEncoder decoder = new DecoderEncoder();
    Pattern patternEN = Pattern.compile("[a-z]\\.\s[A-Z]");     //Используя регулные выражения
    Pattern patternRU = Pattern.compile("[а-я]\\.\s[А-Я]");     //Вводим парамтры поиска сопадений
    Pattern pattern = Pattern.compile("\\.\s");// для дешт=ифрованного текста, на предмет мал.буква точка пробел большая буква
    HashMap<Integer, Integer> mapCounterMatches = new HashMap<>();

    public HashMap<Integer, Integer> createMapCounterMatches(Language language, FileInitializer filesForWork) throws IOException {

        //Создаём мапу с значениями ключа использованого для дешифровки от 1 до размера алфавита -1
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filesForWork.fileResult))) {   //??попытка открыт поток
            for (int i = 0; i < language.charts.length(); i++) {
                AlphabetMap alphabetMap = new AlphabetMap(language.charts, i);
                decoder.decode_encode(alphabetMap.decodeAlphabetMap, filesForWork);
                //Используем метод декодирования со значением ключа равного i
                int counterMain = 0;
                int counterSecond = 0;
                int j = 0;
                StringBuilder checkString = new StringBuilder();
                while (bufferedReader.ready() || j < 100) {         //Берём по строчноиз декодированного текста данные не более 100 строк
                    checkString.append(bufferedReader.readLine());
                    j++;
                }
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
                mapCounterMatches.put(i, counterMain);   // Записываем в мапу значения ключа и количесво сопадений по патерну
                if (counterMain < 2) {
                    mapCounterMatches.put(i, counterSecond); //если кол -во совпадений По(а. А) меньше 2х записываем в мапу кол-во сопадений по (точка пробел).
                }
            }
        }
        return mapCounterMatches;
    }


    public void bruteForceAttack(Language language, FileInitializer filesForWork) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> mapKeyValue = createMapCounterMatches(language, filesForWork);   //Получаем мапу с кол-ом совпадений
        ArrayList<Integer> values = (ArrayList<Integer>) mapKeyValue.values();      // и переделываем её в отсортированый список ключей
        Collections.sort(values);                                                   // от большого кол-ва совпадений к меньшему
        ArrayList<Integer> keyCollection = new ArrayList<>();                       // Создаём новую колекцию для отсортерованых ключей от большего числа совпадений к меньшему
        for (
                Integer keyValue : mapKeyValue.keySet()) {
            for (int i = values.size() - 1; i >= 0; i--) {
                if (mapKeyValue.get(values) == values.get(i)) {
                    keyCollection.add(keyValue);                                    //Заполняем её сравнивая по результам совпадений. Получаем список значейний нужного ключа
                }
            }
        }
        System.out.println("Сейчас система напечатает все доступные варианты ключей для данного алфавита\n Выберерите из возможных вариантов совпадений,\n с наибольшим результатом совпадений");
        System.out.println("Система предложит наиболее подходящие варианты");
        System.out.println("Наиболее подходящие ключи для дешифровки");     // Выводим три наиболее вероятных ключа
        System.out.println("Максимальное количесво совпадений с ключом " + keyCollection.get(1));
        System.out.println("Максимальное количесво совпадений с ключом " + keyCollection.get(2));
        System.out.println("Максимальное количесво совпадений с ключом " + keyCollection.get(3));
        //Предлагаем пользователю их проверить
        System.out.println("Введите значения наиболее подходящего ключа и посмотретите дешифрованый файл result.txt");
        System.out.println("Если текст расщифрован напишите OK");
        String keyMax = scanner.nextLine();
        for (int i = 0;
             i < 3; i++) {
            if (!keyMax.equals("OK")) {
                try {
                    AlphabetMap alphabetMap = new AlphabetMap(language.charts, scanner.nextInt());
                    decoder.decode_encode(alphabetMap.decodeAlphabetMap, filesForWork);
                } catch (RuntimeException e) {
                    System.out.println("Ключ введён неверно");
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Делее выведен список с мением кол-вом сопадений");  // Если не подходят выводим список верояных ключей в зависимости от частоты совпадений
        for (
                int i = 3; i < keyCollection.size(); i++) {                         // от большего к меньшему числу совпадений
            System.out.print(keyCollection.get(i) + "##");
        }
        System.out.println("Пробуйте и проверяйте следующие ключи");
        while (true) {
            if (!keyMax.equals("OK")) {
                try {
                    AlphabetMap alphabetMap = new AlphabetMap(language.charts, scanner.nextInt());
                    decoder.decode_encode(alphabetMap.decodeAlphabetMap, filesForWork);             //Зациклиаем , выход из цикла "ОК"
                } catch (IllegalStateException e) {
                    System.out.println("Ключ введён неверно");
                    throw new RuntimeException(e);
                }
            } else break;
        }
    }
}