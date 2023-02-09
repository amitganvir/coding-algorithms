package com.datastucture.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KthLargestWithNComplexity {

    public static void main(String[] args) {
        KthLargestWithNComplexity kthLargestWithNComplexity = new KthLargestWithNComplexity();
        //kthLargestWithNComplexity.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        //kthLargestWithNComplexity.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        //kthLargestWithNComplexity.findKthLargest(new int[]{-1, 2, 0}, 2);
        kthLargestWithNComplexity.findKthLargest(new int[]{3, 3, 3, 3, 4, 3, 3, 3, 3}, 5);
    }

    public int findKthLargest(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
            max = Math.max(num, max);
        }

        int remainingK = k;

        int startNum = max;
        while (remainingK > 0) {

            if (numCountMap.containsKey(startNum)) {
                if (numCountMap.get(startNum) >= k) return startNum;

                remainingK -= numCountMap.get(startNum);

                if (remainingK <= 0) break;

                startNum = startNum - 1;
            } else {
                startNum--;
            }
        }

        System.out.println(Arrays.toString(nums) + " --> " + startNum);

        return startNum;
    }
}
