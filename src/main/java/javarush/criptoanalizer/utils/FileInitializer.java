package javarush.criptoanalizer.utils;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class FileInitializer {
    File fileData = null;
    File fileResult = null;

    public void fileInitializer() {
        Scanner scanner = new Scanner(System.in);
        boolean value = true;
        while (value) {
            System.out.println("Укажите путь к файлу с данными");
            try {
                Path pathStr = Path.of(scanner.nextLine());
                if (pathStr.isAbsolute()) {
                    System.out.println("Укажите имя файла");
                    String nameFile = scanner.nextLine();
                    value = false;
                    fileData = new File(pathStr.toUri() + nameFile);
                    fileResult = new File(pathStr.toUri() + "result.txt");
                } else throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("Путь указан неверно");
            }
        }
    }
}
