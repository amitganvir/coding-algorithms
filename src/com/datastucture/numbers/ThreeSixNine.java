package com.datastucture.numbers;

import java.util.Arrays;

public class ThreeSixNine {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solve(16)));
    }

    public static String[] solve(int n) {

        String[] result = new String[n];
        int index = 0;
        int number = 1;

        while (number <= n) {

            if (number % 3 == 0 || hasThreeSixNine(number)) {
                result[index] = "clap";
            } else {
                result[index] = String.valueOf(number);
            }
            number++;
            index++;
        }

        return result;

    }

    private static boolean hasThreeSixNine(int num) {

        while (num >= 10) {

            int leadingDigit = num % 10;

            if (leadingDigit == 3 || leadingDigit == 6 || leadingDigit == 9) {
                return true;
            }

            num = num / 10;
        }

        if (num == 3 || num == 6 || num == 9) {
            return true;
        }

        return false;
    }
}
