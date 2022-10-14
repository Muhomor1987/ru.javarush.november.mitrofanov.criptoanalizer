package javarush.criptoanalizer.model;


import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LanguageMap {
    public String charts;
    public HashMap<Character, Character> encodeAlphabetMap = new HashMap<Character, Character>();
    public HashMap<Character, Character> decodeAlphabetMap = new HashMap<Character, Character>();
    private final String en = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ(.,””:-!? )";
    private final String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ(.,””:-!? )";
    private final String uk = "АаБбВвГгҐґДдЕеЄєЖжЗзИиІіЇїЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЬьЮюЯя(.,””:-!? )";
    private final String by = "АаБбВвГгДдДжджДздзЕеЁёЖжЗзІіЙйКкЛлМмНнОоПпРрСсТтУуЎўФфХхЦцЧчШшЫыЬьЭэЮюЯя(.,””:-!? )";


    public LanguageMap(Integer valueKey) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Выберите язык из списка, укажите его номер
                1 - Английский
                2 - Русский
                3 - Украинский
                4 - Белоруский
                """);
        boolean toWork = true;
        while (toWork) {

            try {
                charts = switch (scanner.nextInt()) {
                    case 1 -> en;
                    case 2 -> rus;
                    case 3 -> uk;
                    case 4 -> by;
                    default -> throw new IllegalStateException("Unexpected value");
                };
            } catch (RuntimeException e) {
                System.out.println("Введен неверный номер языка");
            }
            toWork = false;
        }
        toWork = true;
        while (toWork){
            try {
                // обработка значений ключа
                if (valueKey <= 0) {
                    throw new IOException();
                }
                valueKey = valueKey % charts.length();
                toWork =false;                           //Программа не крутит 5 раз, а сразу сбрасывает после обработки
            } catch (Exception e) {
                System.out.println("Значение не может быть отрицательным или равняться 0");
            }
        }


        for (int i = 0; i < charts.length(); i++) {
            if ((i + valueKey < charts.length())) {
                encodeAlphabetMap.put(charts.charAt(i), charts.charAt(i + valueKey));
            } else {
                encodeAlphabetMap.put(charts.charAt(i), charts.charAt((i + valueKey) - charts.length()));
            }

            for (i = 0; i < charts.length(); i++) {
                if ((i + valueKey < charts.length())) {
                    decodeAlphabetMap.put(charts.charAt(i + valueKey), charts.charAt(i));
                } else {
                    decodeAlphabetMap.put(charts.charAt((i + valueKey) - charts.length()), charts.charAt(i));
                }
            }
        }
    }
}




   /* public String getAlphabet(int num) {
        boolean choseLg = true;
        String language = null;
        System.out.println("Выберите язык из списка, укажите его номер\n" +
                "1 - Английский\n" +
                "2 - Русский\n" +
                "3 - Украинский\n" +
                "4 - Белоруский\n");

        while (choseLg) {
            try {
                language = switch (num) {
                    case 1 -> en;
                    case 2 -> rus;
                    case 3 -> uk;
                    case 4 -> by;
                    default -> throw new IllegalStateException("Unexpected value: " + num);
                };
            } catch (RuntimeException e) {
                System.out.println("Введено неверное значение");
            }
            choseLg=false;
        }
        return language;
    }*/
