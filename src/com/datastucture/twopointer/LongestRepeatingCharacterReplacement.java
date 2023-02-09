package com.datastucture.twopointer;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println("AABABBA => " + longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1));
        System.out.println("ABAB => " + longestRepeatingCharacterReplacement.characterReplacement("ABAB", 2));
        System.out.println("ABAA => " + longestRepeatingCharacterReplacement.characterReplacement("ABAA", 0));
          System.out.println("ABBB => " + longestRepeatingCharacterReplacement.characterReplacement("ABBB", 2));
        System.out.println("ABCDE => " + longestRepeatingCharacterReplacement.characterReplacement("ABCDE", 1));
    }

    public int characterReplacement(String s, int k) {

        if (s.length() == 1) {
            return 1;
        }

        if (s.length() == 2) {
            if (s.charAt(0) != s.charAt(1) && k > 0) {
                return 2;
            }
            return 1;
        }

        int result = 0;
        int[] charCountArray = new int[26];

        int leftIndex = 0, rightIndex = 0;
        int frequentCharCount = 0;

        while (leftIndex <= rightIndex && rightIndex < s.length()) {

            char currentChar = s.charAt(rightIndex);
            charCountArray[currentChar - 'A']++;
            frequentCharCount = Math.max(frequentCharCount, charCountArray[currentChar - 'A']);

            if ((rightIndex - leftIndex + 1) - frequentCharCount <= k) {
                result = Math.max((rightIndex - leftIndex) + 1, result);
                rightIndex++;
            } else {
                charCountArray[s.charAt(leftIndex) - 'A'] -= 1;
                charCountArray[s.charAt(rightIndex) - 'A'] -= 1;
                leftIndex++;
            }

        }


        return result;
    }

    private int frequentCharCount(int[] charCount) {

        int result = 0;

        for (int count: charCount) {
            result = Math.max(result, count);
        }

        return result;
    }
}
