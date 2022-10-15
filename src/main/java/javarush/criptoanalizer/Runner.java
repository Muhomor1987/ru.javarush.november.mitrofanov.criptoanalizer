package javarush.criptoanalizer;


import javarush.criptoanalizer.model.Language;
import javarush.criptoanalizer.utils.*;

import java.io.*;
import java.util.*;


public class Runner {
    public static void main(String[] args) throws IOException {
        while (true) {
            Language language = new Language();
            FileInitializer filesForWork = new FileInitializer();
            filesForWork.fileInitializer();
            Menu menu = new Menu();
            menu.startMenu(filesForWork, language);
        }
    }
}
