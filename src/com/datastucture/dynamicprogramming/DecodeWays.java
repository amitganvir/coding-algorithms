package com.datastucture.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        //decodeWays.numDecodings("226");
        //decodeWays.numDecodings("11106");
        decodeWays.numDecodings("111");
    }

    public int numDecodings(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }
        Map<String, Character> integerCharacterHashMap = buildNumberToCharacterMap();
        int result = dfs(s, 0, new Integer[s.length()]);
        System.out.println(s + " --> " + result);
        return result;
    }

    private int dfs(String s, int startIndex, Integer[] dp) {

        if (startIndex >= s.length()) {
            return 1;
        }

        if (s.charAt(startIndex) == '0') {
            return 0;
        }

        if (dp[startIndex] != null) {
            return dp[startIndex];
        }

        int count = dfs(s, startIndex + 1, dp);

        if (startIndex < s.length() - 1 && (s.charAt(startIndex) == '1' || s.charAt(startIndex) == '2' && s.charAt(startIndex + 1) <= '6')) {
            count += dfs(s, startIndex + 2, dp);
        }

        dp[startIndex] = count;

        return count;
    }

    private Map<String, Character> buildNumberToCharacterMap() {
        Map<String, Character> integerCharacterMap = new HashMap<>();

        char firstChar = 'A' - 1;
        for (int i = 1; i <= 26; i++) {
            integerCharacterMap.put(i + "", (char) (firstChar + i));
        }

        return integerCharacterMap;
    }
}
