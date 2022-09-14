package javarush.criptoanalizer.utils;

import java.io.File;
import java.util.Scanner;

public class CreateFile {
    int numVar = 0;

    public void createFile(int numVar) {
        // Если параметр 1 создаем файл для раскодированного текста
        // Если параметр 2 создаём файл для закодированного текста
        Scanner scanner = new Scanner(System.in);
        if (numVar == 1) {
            System.out.println("""
                    Укажите путь к текстовым файлам(.txt),
                    Скопируйте нужный файл в данную траекторию и назовите его "Encode",
                    После выполнения программы в файле Encode.txt в указаной папке появиться зашифрованый текст""");
            String pathStr = scanner.next();
            try {
                File file = new File(pathStr + "Decode.txt");
            } catch (Exception e) {
                System.out.println("Ошибка создания файла записи");
            }
        }
        if (numVar == 2) {
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
        }
    }
}
