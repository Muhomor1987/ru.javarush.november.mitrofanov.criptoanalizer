package javarush.criptoanalizer;

import javarush.criptoanalizer.IO.DownloadAlphabet;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        DownloadAlphabet downloadAlphabet = new DownloadAlphabet(); //Creates a new DownloadAlphabet object
        System.out.println(downloadAlphabet.alphabetCreate());      //Check download Alphabet is right


    }
}
