package com.datastucture.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedium {

    public static void main(String[] args) {
        SlidingWindowMedium slidingWindowMedium = new SlidingWindowMedium();
        slidingWindowMedium.medianSlidingWindow(new int[]{1, 3, -1, 2, -2, -3, 5, 1, 5, 3}, 4);
        //medianSlidingWindow(new int[]{1, 2}, 1);
        //medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 5);
        //slidingWindowMedium.medianSlidingWindow(new int[]{2147483647, -14756, 21474, -2147483646, -2147483647, -5555, 9999}, 2);
        //slidingWindowMedium.medianSlidingWindow(new int[]{7,9,3,8,0,2,4,8,3,9}, 1);
        slidingWindowMedium.medianSlidingWindow(new int[]{7, 0, 3, 9, 9, 9, 1, 7, 2, 3}, 6);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        double[] result = new double[nums.length - k + 1];

        int startIndex = 0;

        for (int end = 0; end < nums.length; end++) {
            addNumber(minHeap, maxHeap, nums[end]);
            if (end - startIndex + 1 == k) {
                result[startIndex] = getMedian(minHeap, maxHeap);
                remove(minHeap, maxHeap, nums[startIndex++]);
            }
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    private void remove(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int number) {

        if (number <= maxHeap.peek()) {
            maxHeap.remove(number);
        } else {
            minHeap.remove(number);
        }

        balance(minHeap, maxHeap);
    }

    private void addNumber(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int number) {

        if (maxHeap.isEmpty() || maxHeap.peek() > number) {
            maxHeap.add(number);
        } else {
            minHeap.add(number);
        }
        balance(minHeap, maxHeap);
    }

    private void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

        if (minHeap.size() > maxHeap.size()) return minHeap.peek();
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();

        long minHeapPeek = minHeap.peek();
        long maxHeapPeek = maxHeap.peek();

        return (minHeapPeek + maxHeapPeek) * 1.0 / 2;
    }

}
