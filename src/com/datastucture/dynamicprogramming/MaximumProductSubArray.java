package com.datastucture.dynamicprogramming;

import java.util.Arrays;

public class MaximumProductSubArray {

    public static void main(String[] args) {
        MaximumProductSubArray maximumProductSubArray = new MaximumProductSubArray();
        maximumProductSubArray.maxProduct(new int[]{-2, 3, -2, 0, -8, 4});
        maximumProductSubArray.maxProduct(new int[]{2, 3, -2, 4});
        maximumProductSubArray.maxProduct(new int[]{-2, 0, -1});
        maximumProductSubArray.maxProduct(new int[]{-1, -2, -3, 0});
        maximumProductSubArray.maxProduct(new int[]{0, 2, 3, -2});
    }

    public int maxProduct(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2)
            return Math.max(Math.max(nums[0] * nums[1], nums[0]), Math.max(nums[0] * nums[1], nums[1]));

        int currentProduct = 1;
        int maxProduct = nums[0];

        //Iterating left to right
        for (int i = 0; i < nums.length; i++) {
            currentProduct *= nums[i];
            maxProduct = Math.max(maxProduct, Math.max(currentProduct, nums[i]));

            if (nums[i] == 0) currentProduct = 1;
        }

        //Iterating from right to left
        currentProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentProduct = currentProduct * nums[i];
            maxProduct = Math.max(maxProduct, Math.max(currentProduct, nums[i]));

            if (nums[i] == 0) currentProduct = 1;
        }

        System.out.println(Arrays.toString(nums) + " --> " + maxProduct);

        return maxProduct;

    }
}
