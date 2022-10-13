package javarush.criptoanalizer.utils;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class FileSelection {
    public File selectFile(){
        Scanner scanner = new Scanner(System.in);
        Path pathStr  = null;
        String nameFile = null;
        boolean value = true;
        while (value) {
            System.out.println("Укажите путь к файлу с данными");
            try {
                pathStr = Path.of(scanner.nextLine());
                if(pathStr.isAbsolute()){
                    value=false;
                }
                else throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("Путь указан неверно");
            }
            System.out.println("Укажите имя файла");
            nameFile = scanner.nextLine();
        }
        return new File(pathStr.toUri() + "." + nameFile);
    }

}
