package com.datastucture.strings;

import com.datastucture.ConsoleReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Panlindrome {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter a string: ");
        String inputString = ConsoleReader.readLine();
        System.out.println(new Panlindrome().isPalindrome(inputString));
    }

    public int isPalindrome(String A) {

        if (A == null || A.length() == 0) {
            return 0;
        }

        char[] arr = A.toCharArray();

        int leftIndex = 0;
        int rightIndex = A.length() - 1;

        while (leftIndex < rightIndex) {
            char leftChar = arr[leftIndex];
            char rightChar = arr[rightIndex];

            if (!Character.isAlphabetic(leftChar) && !Character.isDigit(leftChar)) {
                leftIndex++;
            } else if (!Character.isAlphabetic(rightChar) && !Character.isDigit(rightChar)) {
                rightIndex--;
            } else {

                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return 0;
                }
                leftIndex++;
                rightIndex--;
            }

        }

        return 1;
    }
}
