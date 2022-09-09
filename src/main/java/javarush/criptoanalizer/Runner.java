package javarush.criptoanalizer;

import javarush.criptoanalizer.IO.DownloadAlphabet;
import javarush.criptoanalizer.data.Key;
import javarush.criptoanalizer.data.MapAllLanguage;
import javarush.criptoanalizer.data.TextEncoded;
import javarush.criptoanalizer.data.TextNotEncoded;
import javarush.criptoanalizer.util.CipherByCaesar;


import java.io.IOException;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws IOException {
        DownloadAlphabet downloadAlphabet = new DownloadAlphabet(); //Creates a new DownloadAlphabet object
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
        cipherByCaesar.encrypt(cipherByCaesar); // do method encrypt
    }
}
