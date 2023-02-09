package com.datastucture.strings;

import java.util.Scanner;

public class ValidPalindromeByRemovingOneChar {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean result = new ValidPalindromeByRemovingOneChar().validPalindrome(input.nextLine());
        System.out.println("Result = " + result);
    }

    public boolean validPalindrome(String s) {

        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        boolean charSkipped = false;

        while (leftIndex < rightIndex) {

            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {

                if (isPalindrome(s, leftIndex+1, rightIndex) || isPalindrome(s, leftIndex, rightIndex-1)) {
                    return true;
                }

                return false;
            }

            leftIndex++;
            rightIndex--;
        }


        return true;
    }

    private boolean isPalindrome(String s, int leftIndex, int rightIndex) {

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
