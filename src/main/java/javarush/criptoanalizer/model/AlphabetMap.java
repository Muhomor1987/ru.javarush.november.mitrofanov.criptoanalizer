package javarush.criptoanalizer.model;

import java.io.IOException;
import java.util.HashMap;

public class AlphabetMap {
    public HashMap<Character, Character> encodeAlphabetMap = new HashMap<Character, Character>();
    public HashMap<Character, Character> decodeAlphabetMap = new HashMap<Character, Character>();

    public AlphabetMap(String charts, Integer valueKey) {
        boolean toWork = true;
        while (toWork) {
            try {
                // обработка значений ключа
                if (valueKey <= 0) {
                    throw new IOException();
                }
                valueKey = valueKey % charts.length();
                toWork = false;                           //Программа не крутит 5 раз, а сразу сбрасывает после обработки
            } catch (Exception e) {
                System.out.println("Значение не может быть отрицательным или равняться 0");
            }
        }


        for (int i = 0; i < charts.length(); i++) {
            if ((i + valueKey < charts.length())) {
                encodeAlphabetMap.put(charts.charAt(i), charts.charAt(i + valueKey));
            } else {
                encodeAlphabetMap.put(charts.charAt(i), charts.charAt((i + valueKey) - charts.length()));
            }
        }
        for (int i = 0; i < charts.length(); i++) {
            if ((i + valueKey < charts.length())) {
                decodeAlphabetMap.put(charts.charAt(i + valueKey), charts.charAt(i));
            } else {
                decodeAlphabetMap.put(charts.charAt((i + valueKey) - charts.length()), charts.charAt(i));
            }
        }
    }
}
