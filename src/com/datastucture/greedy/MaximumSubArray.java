package com.datastucture.greedy;

import java.util.Arrays;

public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        maximumSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        maximumSubArray.maxSubArray(new int[]{5, 4, -1, 7, 8});
    }

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];



        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSum);

        }

        System.out.format("Input=%s maxSubArraySum=%d", Arrays.toString(nums), maxSum);
        System.out.println();

        return maxSum;
    }
}
