package com.datastucture.slidingwindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSubSequenceWithLengthK {

    public static void main(String[] args) {
        MaxSubSequenceWithLengthK maxSubSequenceWithLengthK = new MaxSubSequenceWithLengthK();
        maxSubSequenceWithLengthK.maxSubsequence(new int[]{63, -74, 61, -17, -55, -59, -10, 2, -60, -65}, 9);
    }

    public int[] maxSubsequence(int[] nums, int k) {

        if (nums.length == k) {
            return nums;
        }

        Comparator<NumWithIndex> comparator = Comparator.comparing(NumWithIndex::getValue).reversed();
        PriorityQueue<NumWithIndex> priorityQueue = new PriorityQueue<>(k, comparator);

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(new NumWithIndex(nums[i], i));
        }

        int[] result = new int[k];
        List<NumWithIndex> list = new ArrayList<>();
        for (int i = k - 1; i >= 0; i--) {
            list.add(priorityQueue.poll());
        }

        list.sort(Comparator.comparing(NumWithIndex::getIndex));

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getValue();
        }

        return result;
    }

    public static class NumWithIndex {
        int value;
        int index;

        NumWithIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }
}
