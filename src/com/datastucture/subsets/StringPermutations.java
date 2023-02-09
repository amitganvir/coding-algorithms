package com.datastucture.subsets;

import java.util.ArrayList;

public class StringPermutations {

    public static void main(String[] args) {
        permuteWord("abc");
    }

    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> arrayList = new ArrayList<>();
        permute(word, 0, arrayList);
        System.out.println(arrayList);
        return arrayList;
    }

    public static void permute(String word, int currentIndex, ArrayList<String> results) {

        if (currentIndex == word.length()) {
            results.add(word);
            return;
        }

        for (int i = currentIndex; i < word.length(); i++) {

            char[] wordArray = word.toCharArray();
            char iIndexChar = wordArray[i];
            char currentIndexChar = wordArray[currentIndex];

            wordArray[i] = currentIndexChar;
            wordArray[currentIndex] = iIndexChar;

            permute(new String(wordArray), currentIndex +1, results);
        }
    }
}
