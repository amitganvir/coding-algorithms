package com.datastucture.slidingwindow;

public class PermutationInString {

    public static void main(String[] args) {

        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("hello", "ooolleoooleh"));
        System.out.println(permutationInString.checkInclusion("ab", "eidbaooo"));
        System.out.println(permutationInString.checkInclusion("adc", "dcda"));
        System.out.println(permutationInString.checkInclusion("abc", "bbbca"));
    }

    public boolean checkInclusion(String s1, String s2) {


        if (s2.length() < s1.length()) return false;

        //Create S1 Char Array
        int[] s1CharArray = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1CharArray[s1.charAt(i) - 'a'] += 1;
        }

        int numberOfCharactersInS2MatchingS1 = 0;

        //Initialize S2 Char Array for the first window which matches size of S1
        int[] s2CharArray = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int charIndex = s2.charAt(i) - 'a';
            s2CharArray[charIndex] += 1;
        }

        for (int i = 0; i < s2CharArray.length; i++) {
            if (s1CharArray[i] == s2CharArray[i]) {
                numberOfCharactersInS2MatchingS1++;
            }
        }

        int leftIndex = 0;
        int rightIndex = s1.length() - 1;

        while (numberOfCharactersInS2MatchingS1 != 26) {

            char leftIndexChar = s2.charAt(leftIndex);

            int leftIndexCharReferenceIndex = leftIndexChar - 'a';

            boolean currentLeftIndexCountMatching = s1CharArray[leftIndexCharReferenceIndex] == s2CharArray[leftIndexCharReferenceIndex];


            s2CharArray[leftIndexCharReferenceIndex] -= 1;

            if (s1CharArray[leftIndexCharReferenceIndex] == s2CharArray[leftIndexCharReferenceIndex]) {
                numberOfCharactersInS2MatchingS1++;
            } else {
                if (currentLeftIndexCountMatching) {
                    numberOfCharactersInS2MatchingS1--;
                }
            }

            leftIndex++;

            if (leftIndex >= s2.length() || rightIndex + 1 >= s2.length()) {
                break;
            }

            rightIndex++;

            char nextRightIndexChar = s2.charAt(rightIndex);
            int nextRightIndexCharReference = nextRightIndexChar - 'a';
            boolean rightIndexCountMatching = s1CharArray[nextRightIndexCharReference] == s2CharArray[nextRightIndexCharReference];

            s2CharArray[nextRightIndexCharReference] += 1;
            if (s1CharArray[nextRightIndexCharReference] == s2CharArray[nextRightIndexCharReference]) {
                numberOfCharactersInS2MatchingS1++;
            } else {
                if (rightIndexCountMatching) {
                    numberOfCharactersInS2MatchingS1--;
                }
            }
        }


        return numberOfCharactersInS2MatchingS1 == 26;
    }

}
