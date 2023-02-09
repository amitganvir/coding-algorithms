package com.datastucture.numbers;

public class PalindromeWithoutStringFunctions {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10401));
    }

    private static boolean isPalindrome(int number) {

        int divisor = 1;

        while (number / divisor >= 10) {
            divisor *= 10;
        }

        while (number != 0) {
            int leadingDigits = number / divisor;
            int trailingDigits = number % 10;

            if (leadingDigits != trailingDigits) {
                return false;
            }

            number = (number % divisor) / 10;

            divisor = divisor / 100;
        }

        return true;
    }
}
