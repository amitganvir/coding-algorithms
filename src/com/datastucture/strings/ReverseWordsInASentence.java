package com.datastucture.strings;

public class ReverseWordsInASentence {

    public static void main(String[] args) {

        reverseWords("Hello World".toCharArray());
        reverseWords("We love Java".toCharArray());

    }

    public static void reverseWords (char[] sentence) {

        int leftIndex = 0;
        int rightIndex = sentence.length - 1;

        while (leftIndex < rightIndex) {

            char temp = sentence[leftIndex];
            sentence[leftIndex] = sentence[rightIndex];
            sentence[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }

        leftIndex = 0;
        rightIndex = 0;

        while (rightIndex < sentence.length) {

            if (sentence[rightIndex] == ' ') {
                reverseWord(sentence, leftIndex, rightIndex - 1);
                rightIndex++;
                leftIndex = rightIndex;
            }
            rightIndex++;
        }
        reverseWord(sentence, leftIndex, sentence.length - 1);

        System.out.println(sentence);
    }

    private static void reverseWord(char[] sentence, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex) {
            char temp = sentence[leftIndex];
            sentence[leftIndex] = sentence[rightIndex];
            sentence[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }
}
