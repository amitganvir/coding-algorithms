package com.datastucture.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> priorityQueue;
    private int kthLargestValue;
    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        kthLargestValue = k;

        for (int num: nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() == kthLargestValue) {

            if (priorityQueue.peek() < val) {
                priorityQueue.poll();
                priorityQueue.add(val);
            }
        } else {
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
