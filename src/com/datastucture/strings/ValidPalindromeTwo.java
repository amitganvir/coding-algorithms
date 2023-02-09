package com.datastucture.strings;

import java.util.Arrays;
import java.util.HashMap;

public class ValidPalindromeTwo {

    public static void main(String[] args) {
        System.out.println(validPalindrome("tebbem"));
    }

    public static boolean validPalindrome(String s) {
        int[] charCountArray = new int[200];
        char[] inputCharArray = s.toCharArray();
        Arrays.fill(charCountArray,  0);

        for (int i = 0; i < inputCharArray.length; i++) {
            charCountArray[inputCharArray[i]] += 1;
        }

        int numberOfOddChars = 0;
        for (int charCount: charCountArray) {

            if (charCount != 0) {
                if (charCount % 2 != 0) {
                    numberOfOddChars++;
                }
            }
        }

        boolean isEvenLength = s.length() % 2 == 0;
        if (isEvenLength && numberOfOddChars <= 1) {
            return true;
        }

        if (!isEvenLength && numberOfOddChars == 1) {
            return true;
        }

        return false;
    }

    private static boolean isPalindromeExisting(String str) {

        int leftIndex = 0;
        int rightIndex = str.length() - 1;

        while (leftIndex < rightIndex) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }


    public static boolean isPalindrome(String s) {

        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {

            if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                leftIndex++;
                rightIndex--;
            } else {
                return isPalindromeEducative(s, leftIndex + 1, rightIndex) || isPalindromeEducative(s, leftIndex, rightIndex - 1);
            }
        }

        return true;
    }

    private static boolean isPalindromeEducative(String s, int leftIndex, int rightIndex) {

        while (leftIndex < rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }




}
