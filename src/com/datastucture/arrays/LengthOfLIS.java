package com.datastucture.arrays;

import java.util.Arrays;
import java.util.Stack;

public class LengthOfLIS {

    public static void main(String[] args) {
        //System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        //System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    public int lengthOfLIS(int[] nums) {

        int maxLength = 0;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    result[i] = Math.max(result[i], 1 + result[j]);
                    maxLength = Math.max(maxLength, result[i]);
                }
            }
        }

        return maxLength;
    }
}
