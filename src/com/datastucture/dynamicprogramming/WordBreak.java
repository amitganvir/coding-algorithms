package com.datastucture.dynamicprogramming;

import java.util.*;

public class WordBreak {

    Map<String, Boolean> stringBooleanMap = new HashMap<>();

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
//        boolean result = wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
//        System.out.println(result);

            boolean result = wordBreak.wordBreakDp("catsandog", List.of("cats","dog","sand","and","cat"));
            System.out.println(result);

//        boolean result = wordBreak.wordBreak("neetcode", List.of("neet", "leet", "code"));
//        System.out.println(result);
//        boolean result = wordBreak.wordBreak("aaaaaaa", List.of("aaaa", "aaa"));
//        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //return wordBreakDfs(s, wordDict, new HashMap<>());
        return wordBreakDp(s, wordDict);
    }

    private boolean wordBreakDp(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i);
            for (String word: wordDict) {
                if (i + word.length() <= s.length()) {
                    if (str.startsWith(word)) {
                        dp[i+word.length() - 1] = dp[i - 1];
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    private boolean wordBreakDfs(String s, List<String> wordDict, Map<String, Boolean> wordCache) {

        if (s.isEmpty()) return true;
        if (wordCache.containsKey(s)) return wordCache.get(s);

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String newString = s.substring(word.length());
                boolean result = wordBreakDfs(newString, wordDict, wordCache);
                if (result) {
                    wordCache.put(newString, true);
                    return true;
                }
            }
        }
        wordCache.put(s, false);
        return false;
    }
}