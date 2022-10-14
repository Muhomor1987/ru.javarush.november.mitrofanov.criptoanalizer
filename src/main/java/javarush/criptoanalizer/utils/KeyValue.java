package javarush.criptoanalizer.utils;

import java.io.IOException;


public class KeyValue {
    public Integer value;

    public KeyValue(Integer key) {
        System.out.println("Введите целочисленый ключ шифрования");
        int result = key;
        int attempt = 5;
        while (attempt > 0) {
            try {
                // обработка значений ключа
                if (result < 0) {
                    throw new IOException();
                }
                result = result % alphabet.length();
                attempt = 0;                            //Программа не крутит 5 раз, а сразу сбрасывает после обработки
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных");
                System.out.println("Осталось " + (attempt - 1) + " попытки");
                attempt--;
            }
        }
        value = result;
    }
}

    /*public int getKey(String alphabet, int key) {
       System.out.println("Введите целочисленый ключ шифрования");
       int result = key;
        int attempt = 5;
        while (attempt > 0) {
            try {
                // обработка значений ключа
                if (result < 0) {
                    throw new IOException();
                }
                result = result % alphabet.length();
                attempt = 0;                            //Программа не крутит 5 раз, а сразу сбрасывает после обработки
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных");
                System.out.println("Осталось " + (attempt - 1) + " попытки");
                attempt--;
            }
        }

        return result;
    }
}*/