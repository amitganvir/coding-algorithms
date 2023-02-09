package com.datastucture.strings;

public class NumberOfPalindromesInAString {

    public static void main(String[] args) {
        findAllPalindromeSubstrings("aabbbaa");
        findAllPalindromeSubstrings("ababbccdeed");
    }

    public static int findAllPalindromeSubstrings(String input) {

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count += palindromeLength(input, i- 1, i + 1);
            count += palindromeLength(input, i, i + 1);
        }

        System.out.println(input + " --> " + count);
        return count;
    }

    private static int palindromeLength(String input, int leftIndex, int rightIndex) {

        int count = 0;
        while (leftIndex >= 0 && rightIndex < input.length() && input.charAt(leftIndex) == input.charAt(rightIndex)) {
            count++;
            leftIndex--;
            rightIndex++;
        }

        return count;
    }
}
