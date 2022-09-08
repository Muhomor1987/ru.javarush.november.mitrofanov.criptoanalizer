package javarush.criptoanalizer.util;

import javarush.criptoanalizer.data.Key;
import javarush.criptoanalizer.data.MapAllLanguage;
import javarush.criptoanalizer.data.TextEncoded;
import javarush.criptoanalizer.data.TextNotEncoded;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CipherByCaesar {
    TextNotEncoded textNotEncoder;
    TextEncoded textEncoder;
    Key key;
    MapAllLanguage.Alphabet alphabet;

    public CipherByCaesar(TextNotEncoded textNotEncoder, TextEncoded textEncoder, MapAllLanguage.Alphabet alphabet, Key key) {
        this.textNotEncoder = textNotEncoder;   //Check for null
        this.textEncoder = textEncoder;
        this.alphabet = alphabet;
        this.key = key;
    }

    public void encrypt(CipherByCaesar cipherByCaesar) throws IOException {
        ArrayList<Character> alphabetList = new ArrayList<>();
        ArrayList<Character> lettersText = new ArrayList<Character>();
        ArrayList<Character> lettersEncoder = new ArrayList<Character>();
        alphabetList = cipherByCaesar.alphabet.alphabetToArray();
        lettersText = textNotEncoder.textNotEncoderToArray();
        int lengthAlphabet = alphabet.length(cipherByCaesar.alphabet);
        int key = 0;
        if (cipherByCaesar.key.getKey() >= lengthAlphabet) {
            key = cipherByCaesar.key.getKey() % lengthAlphabet;
        } else key = cipherByCaesar.key.getKey();
        HashMap<Character, Character> mapAlphabet = new HashMap<Character, Character>();
        for (int i = 0; i < alphabetList.size(); i++) {
            mapAlphabet.put(alphabetList.get(i), alphabetList.get(i + key));
        }
        for (Character charText : lettersText
        ) {
            if (mapAlphabet.containsKey(charText)){
                lettersEncoder.add(mapAlphabet.get(charText));
            }
            else lettersEncoder.add(charText);
        }
            cipherByCaesar.textEncoder.writer(lettersEncoder);


    }
}
