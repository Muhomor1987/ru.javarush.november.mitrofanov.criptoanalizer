package javarush.criptoanalizer.model;


import java.util.HashMap;
import java.util.Scanner;

public class Language {
    public String charts;

    private final String en = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ(.,””:-!? )";
    private final String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ(.,””:-!? )";
    private final String uk = "АаБбВвГгҐґДдЕеЄєЖжЗзИиІіЇїЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЬьЮюЯя(.,””:-!? )";
    private final String by = "АаБбВвГгДдДжджДздзЕеЁёЖжЗзІіЙйКкЛлМмНнОоПпРрСсТтУуЎўФфХхЦцЧчШшЫыЬьЭэЮюЯя(.,””:-!? )";


    public Language() {
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
