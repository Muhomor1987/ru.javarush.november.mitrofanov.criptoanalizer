package javarush.criptoanalizer.utils;

import java.io.IOException;


public class KeyHandler {
   public int getKey(String alphabet, int key) {
       int result = key;
        int attempt = 5;
        while (attempt > 0) {

            try {
                // обработка значений ключа
                if (result < 0) {
                    throw new IOException();
                }
                result = result % alphabet.length();
                attempt = 0;
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных");
                System.out.println("Осталось " + (attempt - 1) + " попытки");
                attempt--;
            }
        }

        return result;
    }
}
