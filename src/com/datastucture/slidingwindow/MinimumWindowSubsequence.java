package com.datastucture.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubsequence {

    public static void main(String[] args) {

        minWindow("abcdebdde", "bde");
        minWindow("michmznaitnjdnjkdsnmichmznait", "michmznait");
        minWindow("afgegrwgwga", "aa");
        minWindow("abababa", "ba");
        minWindow("cnhczmccqouqadqtmjjzl" , "cm");
        minWindow("fgrqsqsnodwmxzkzxwqegkndaa", "kzed");
    }

    public static String minWindow(String s, String t) {
        int tIndex = 0;
        int startIndex = -1;
        String result = "";

        Map<Character, Integer> sourceMapCount = new HashMap<>();
        Map<Character, Integer> targetMapCount = new HashMap<>();

        for (char character : t.toCharArray()) {
            targetMapCount.put(character, targetMapCount.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(tIndex)) {

                if (startIndex == -1) {
                    startIndex = i;
                }

                int currentCharCountValue = sourceMapCount.getOrDefault(s.charAt(i), 0) + 1;
                sourceMapCount.put(s.charAt(i), currentCharCountValue);

                tIndex++;
            } else if (targetMapCount.containsKey(s.charAt(i)) && startIndex > -1 ) {
                sourceMapCount.put(s.charAt(i), sourceMapCount.getOrDefault(s.charAt(i), 0) + 1);
            }

            if (tIndex >= t.length()) {
                if (result.isEmpty()) {
                    result = s.substring(startIndex, i + 1);
                }

                while (startIndex < i) {
                    char leftMostChar = s.charAt(startIndex);
                    if (targetMapCount.containsKey(leftMostChar)) {
                        sourceMapCount.put(leftMostChar, sourceMapCount.get(leftMostChar) - 1);
                        if (sourceMapCount.get(leftMostChar) < targetMapCount.get(leftMostChar)) {
                            break;
                        }
                    }
                    startIndex++;
                }
                int length = i + 1 - startIndex;
                if (result.length() > length && s.charAt(startIndex) == t.charAt(0)) {
                    result = s.substring(startIndex, i + 1);
                }

                sourceMapCount.clear();
                startIndex = -1;
                tIndex = 0;
            }
        }
        //System.out.println(String.format("%s %s Output = %s", s, t, result));
        return result;
    }
}
