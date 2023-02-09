package com.datastucture.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            String anagramString = getAnagramString(str);

            List<String> anagramListOrDefault = anagramMap.getOrDefault(anagramString, new ArrayList<String>());
            anagramListOrDefault.add(str);
            anagramMap.put(anagramString, anagramListOrDefault);
        }

        result.addAll(anagramMap.values());

        return result;
    }

    private String getAnagramString(final String str) {

        int[] charArray = new int[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charArray[c] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < charArray.length; c++) {

            if (charArray[c] > 0) {
                char currentChar = (char) c;
                for (int i = 0; i < charArray[c]; i++) {
                    sb.append(currentChar);
                }
            }
        }
        return sb.toString();
    }
}
