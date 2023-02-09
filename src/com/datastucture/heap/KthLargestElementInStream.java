package com.datastucture.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
    private final int limit;

    public KthLargestElementInStream(int k, int[] nums) {
        this.limit = k;
        for (int num: nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
    }
    // adds element in the topKHeap
    public int add(int val) {

        priorityQueue.add(val);
        if (priorityQueue.size() > limit) {
            priorityQueue.poll();
        }

        return returnKthLargest();
    }

    public int returnKthLargest() {
        assert !priorityQueue.isEmpty();
        return priorityQueue.peek();
    }
}
