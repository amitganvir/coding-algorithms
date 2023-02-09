package com.datastucture.arrays;

import javax.swing.*;
import java.util.*;

public class KthLargestElement {

    public static void main(String[] args) {
        new KthLargestElement().findKthLargest(new int[]{3, 2,3,1,2,4,5,5,6}, 4);
    }

    public int findKthLargestV1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        PriorityQueue<Count> queue1 = new PriorityQueue<>(k, Comparator.comparing(Count::getCount).reversed());

        for (int num: nums) {
            queue.add(num);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = queue.poll();
        }

        return result;
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static class Count {

        int num;
        int count;

        public int getCount() {
            return this.getCount();
        }

        public  Count(int num) {
            this.num = num;
        }
    }
}
