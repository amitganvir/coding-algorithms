package com.datastucture.heap;

import java.util.*;

public class TopKElements {

    public static void main(String[] args) {
        TopKElements topKElements = new TopKElements();
        topKElements.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
    }

    public static List<Integer> topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(comparator);

        for (int i = 0; i < arr.length; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                if (queue.peek().getValue() < entry.getValue()) {
                    queue.poll();
                    queue.add(entry);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (queue.size() > 0) result.add(queue.poll().getKey());

        //System.out.println(Arrays.toString(resultArray));
        return result;
    }
}
