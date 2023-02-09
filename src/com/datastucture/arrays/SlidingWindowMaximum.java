package com.datastucture.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        System.out.println("**************** I LOVE ");
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        //slidingWindowMaximum.maxSlidingWindow(new int[]{-4, 2, -5, 3, 6}, 3);
//        slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//        slidingWindowMaximum.maxSlidingWindow(new int[]{1, -1}, 1);
//        slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (k >= nums.length) {
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        }

        Deque<Integer> deque = new ArrayDeque<>(k);
        int[] result = new int[nums.length - k + 1];

        int resultIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) result[resultIndex++] = nums[deque.peekFirst()];
        }
        return result;
    }
}
