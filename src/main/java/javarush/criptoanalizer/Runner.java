package javarush.criptoanalizer;

import javarush.criptoanalizer.IO.DownloadAlphabet;
import javarush.criptoanalizer.data.Key;
import javarush.criptoanalizer.data.MapAllLanguage;
import javarush.criptoanalizer.data.TextEncoded;
import javarush.criptoanalizer.data.TextNotEncoded;
import javarush.criptoanalizer.util.CipherByCaesar;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws IOException {
        boolean toWork = true;
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ(.,””:-!? )";
        while (toWork) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Нажмите 1 если хотите закодировать файл по методу цезаря");
            System.out.println("Нажмите 2 если хотите раскодировать файл");
            System.out.println("Нажмите 3 если хотите выйти из программы");
            String menu = scanner.next();
            if (menu.equals("1")) {
                System.out.println("""
                        Укажите путь к текстовым файлам(.txt),
                        Скопируйте нужный файл в данную траекторию и назовите его "Encode",
                        После выполнения программы в файле Decoder.txt в указаной папке появиться рашифрованый текст""");
                String pathStr = scanner.next();
                try {
                    File file = new File(pathStr+"Decode.txt");
                } catch (Exception e) {
                    System.out.println("Ошибка создания файла записи");
                }
/*                Path path = Path.of(pathStr);
                Files.createTempFile(,pathStr);*/
                try (BufferedReader bufferReader = new BufferedReader(new FileReader(pathStr + "Encode.txt"));
                     BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(pathStr + "Decode.txt"))) {
                    HashMap<Character, Character> mapAlphabet = new HashMap<>();
                    System.out.println("Введите число для шифорвания");
                    int key=0;
                    int attempt = 5;
                    while (attempt>0) {
                        try {
                            key = Integer.parseInt(scanner.next());
                            if(key<0){
                                throw new IOException();
                            }
                            if(key>alphabet.length()){
                                key = alphabet.length()%key;
                            }
                        } catch (Exception e) {
                            System.out.println("Некорректный ввод данных");
                            System.out.println("Осталось "+ (attempt-1)+ " попытки");
                            attempt--;
                        }
                    }   //Ввод ключа с клавиатуры
                    for (int i = 0; i < alphabet.length(); i++) {
                        if ((i+key<alphabet.length())) {
                            mapAlphabet.put(alphabet.charAt(i),alphabet.charAt(i+key));
                        } else {
                            mapAlphabet.put(alphabet.charAt(i),alphabet.charAt((i + key) - alphabet.length()));
                        }

                    }// Заполнение map алфавита для кодировки по Цезарю
                    //ЗАПИСЫВАЕМ В СТРИГ БИЛДЕР значения буфера считаного текста и сразу обрабатываем строку и записываем в файл
                    StringBuilder stringBuilder = new StringBuilder();
                    while (bufferReader.ready()){
                        stringBuilder.append(bufferReader.)
                    }

                } catch (Exception e) {
                    System.out.println("Указаный файл отсутвует по данному адресу");
                }
            }
            if (menu.equals("2")) {
                System.out.println("""
                        Выбирите способ раскодирования ...
                        1-методом цезаря
                        2-методом BruteForce
                        3-методом статистического анализа
                        Введите цифру с выбраным методом
                        """);
                String way = scanner.next();
                if (way.equals("1")) {
                    //вынести метод в класс

                }
                if(way.equals("3")) {
                    System.out.println("Программа закрыта");
                    toWork=false;
                }
            }
        }




/*        DownloadAlphabet downloadAlphabet = new DownloadAlphabet(); //Creates a new DownloadAlphabet object
        System.out.println(downloadAlphabet.alphabetCreate());//Check download Alphabet is right
        MapAllLanguage mapAllLanguage = new MapAllLanguage(); //Creates a new MapAll
        MapAllLanguage.Alphabet alphabetRus = new MapAllLanguage.Alphabet("RUS",downloadAlphabet.alphabetCreate());
        //mapAllLanguage.alphabetAdd(alphabetRus);     //don`t work                      //add alphabet to alphabet map
        //System.out.println(mapAllLanguage.alphabetGet("RUS"));      //get alphabet from alphabet mapAllLanguage
        //Сan add other languages and language recognition...
        System.out.println("Введите значения ключа для шифорвания: ");
        Scanner scannerConsole = new Scanner(System.in);
        int key = scannerConsole.nextInt();   //make a key check throws IOException
        Key keyCode  = new Key(key); //make a key check throws IOException
        //метод запускаем кодирования с параметром Кей
        TextEncoded textEncoder = new TextEncoded(); //Create object
        TextNotEncoded textNotEncoder = new TextNotEncoded();//Create object
        CipherByCaesar cipherByCaesar = new CipherByCaesar(textNotEncoder,textEncoder,alphabetRus,keyCode);//Create object
        cipherByCaesar.encrypt(cipherByCaesar); // do method encrypt*/
    }
}
