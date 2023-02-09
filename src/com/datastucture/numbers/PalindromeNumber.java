package com.datastucture.numbers;

public class PalindromeNumber {

    public static void main(String args[]) {

        System.out.printf("%d is palindrome %s", 10, isNumberAPalindrome(10));

        System.out.printf("%d is palindrome %s", 12321, isNumberAPalindrome(12321));
        System.out.println();
        System.out.printf("%d is palindrome %s", 22, isNumberAPalindrome(22));
        System.out.println();
        System.out.printf("%d is palindrome %s", 334, isNumberAPalindrome(334));
    }

    public static boolean isNumberAPalindrome(int number) {

        if (number < 0) {
            return false;
        }

        int reversedNumber = 0;

        while (number > reversedNumber) {
            int remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number = number / 10;
        }

        return reversedNumber == number || number == reversedNumber / 10;
    }
}
