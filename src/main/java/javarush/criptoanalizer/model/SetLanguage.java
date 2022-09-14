package javarush.criptoanalizer.model;


import java.util.Scanner;

public class SetLanguage {


    String en = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ(.,””:-!? )";
    String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ(.,””:-!? )";
    String uk = "АаБбВвГгҐґДдЕеЄєЖжЗзИиІіЇїЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЬьЮюЯя(.,””:-!? )";
    String by = "АаБбВвГгДдДжджДздзЕеЁёЖжЗзІіЙйКкЛлМмНнОоПпРрСсТтУуЎўФфХхЦцЧчШшЫыЬьЭэЮюЯя(.,””:-!? )";


    public String getAlphabet() {
        boolean choseLg = true;
        String language = null;
        System.out.println("Выберите язык из списка, укажите его номер" +
                "1 - Английский" +
                "2 - Русский" +
                "3 - Украинский" +
                "4 - Белоруский");
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.next());
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
    }
}