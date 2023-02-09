package com.datastucture.dynamicprogramming;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
//        System.out.println(longestPalindromeSubstring.longestPalindrome("babad"));
//        System.out.println(longestPalindromeSubstring.longestPalindrome("longestPalindrome"));
//        System.out.println(longestPalindromeSubstring.longestPalindrome("cbbd"));
//        System.out.println(longestPalindromeSubstring.longestPalindrome("bb"));

        System.out.println(longestPalindromeSubstring.longestPalindrome("aaaaaa"));

    }

    public String longestPalindrome(final String s) {
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < s.length(); i++) {

            int subStringWithOddLength = palindromeLength(s, i, i);
            int subStringWithEvenLength = palindromeLength(s, i, i + 1);

            int length = Math.max(subStringWithEvenLength, subStringWithOddLength);

            if (length > (endIndex - startIndex)) {
                startIndex = Math.max(i - (length - 1)/ 2, 0);
                endIndex = i + (length / 2);
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    private int palindromeLength(final String s, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return rightIndex - leftIndex - 1;
    }
}
