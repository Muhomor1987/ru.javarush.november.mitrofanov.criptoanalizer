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
                switch (scanner.nextInt()) {
                    case 1 -> charts = en;
                    case 2 -> charts = rus;
                    case 3 -> charts = uk;
                    case 4 -> charts = by;
                    default -> throw new IllegalStateException("Unexpected value");
                };
            } catch (IllegalStateException e) {
                System.out.println("Введен неверный номер языка");
            }
            toWork = false;
        }
    }
}
