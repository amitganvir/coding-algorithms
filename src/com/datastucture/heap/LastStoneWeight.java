package com.datastucture.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        lastStoneWeight.lastStoneWeightArray(new int[]{2, 7, 4, 1, 8, 1});
        lastStoneWeight.lastStoneWeightArray(new int[]{1});
    }

    public int lastStoneWeightHeap(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(stones).forEach(queue::add);

        while (queue.size() > 1) {

            int firstElement = queue.poll();
            int secondElement = queue.poll();

            int remainder = Math.abs(secondElement - firstElement);
            if (remainder > 0) queue.add(remainder);
        }

        int result = queue.size() > 0 ? queue.poll() : 0;
        System.out.println(Arrays.toString(stones) + " --> " + result);
        return result;
    }

    public int lastStoneWeightArray(int[] stones) {
        Arrays.sort(stones);

        Integer remainder = null;
        int index = stones.length - 1;

        while (index >= 0) {

            int currentElement = stones[index];

            if (index - 1 < 0) {

                if (remainder != null)
                    remainder = Math.abs(remainder - currentElement);
                break;
            }
            int previousElement = stones[index - 1];

            if (remainder == null) {
                if (currentElement != previousElement) {
                    remainder = Math.abs(currentElement - previousElement);
                } else {
                    remainder = 0;
                }
                index = index - 2;
                continue;
            }

            remainder = Math.abs(remainder - currentElement);
            index--;
        }

        int result = remainder != null ? remainder : stones[0];

       // System.out.println(Arrays.toString(stones) + " --> " + result);

        return result;
    }
}
