package com.datastucture.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeStrings {

    public static void main(String[] args) {
        ReorganizeStrings reorganizeStrings = new ReorganizeStrings();
        String result = reorganizeStrings.reorganizeString("bbcaaaaaaaaaa");
        System.out.println(result);
    }

    public String reorganizeString(String s) {
        String resultString = "";

        if (s == null || s.length() == 0 || s.length() == 1) {
            return resultString;
        }

        Map<Character, Integer> characterCountMap = new HashMap<>();

        for (char c: s.toCharArray()) {
            characterCountMap.put(c, characterCountMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> characterCountMap.get(b) - characterCountMap.get(a));

        priorityQueue.addAll(characterCountMap.keySet());

        StringBuilder result = new StringBuilder();

        while (priorityQueue.size() > 1 ) {

            char next = priorityQueue.remove();
            char nextToNext = priorityQueue.remove();
            result.append(next).append(nextToNext);
            characterCountMap.put(next, characterCountMap.get(next) - 1);
            characterCountMap.put(nextToNext, characterCountMap.get(nextToNext) - 1);

            if (characterCountMap.get(next) > 0) priorityQueue.add(next);
            if (characterCountMap.get(nextToNext) > 0) priorityQueue.add(nextToNext);
        }

        if (!priorityQueue.isEmpty()) {
            char c = priorityQueue.remove();

            if (characterCountMap.get(c) > 1) {
                return "";
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

}