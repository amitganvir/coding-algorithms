package com.datastucture.dynamicprogramming;

public class PalindromeSubstrings {

    public static void main(String[] args) {
        PalindromeSubstrings palindromeSubstrings = new PalindromeSubstrings();
        palindromeSubstrings.countSubstrings("abc");
        palindromeSubstrings.countSubstrings("aaa");
    }

    public int countSubstrings(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += palindromeLength(s, i, i);
            result += palindromeLength(s, i, i+1);
        }

        //System.out.println(s + " --> " + result);
        return result;
    }

    private int palindromeLength(final String s, int leftIndex, int rightIndex) {
        int numberOfSubstring = 0;
        while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            numberOfSubstring++;
            leftIndex--;
            rightIndex++;
        }
        return numberOfSubstring;
    }
}
