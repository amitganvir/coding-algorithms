package com.datastucture.arrays;

public class MaxProduct {

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[] {2, -5, -2, -4, 3}));
        System.out.println(new MaxProduct().maxProduct(new int[] {-3, 0, 1, -2}));
        System.out.println(new MaxProduct().maxProduct(new int[] {-1, -2, -3, 0}));
        System.out.println(new MaxProduct().maxProduct(new int[] {6, 3, -10, 0, 2}));
        System.out.println(new MaxProduct().maxProduct(new int[] {0, -2, 0}));

        //System.out.println(new MaxProduct().maxProduct(new int[] {-1, -2, -3, 0}));
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(Math.max(nums[0], nums[0]*nums[1]), Math.max(nums[1], nums[0]*nums[1]));
        }

        int currentProduct = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (currentProduct <= 0) {
                    currentProduct *= nums[i];
                    maxProduct = Math.max(maxProduct, Math.max(currentProduct, nums[i]));
                } else {
                    maxProduct = Math.max(maxProduct, currentProduct);
                    currentProduct = 1;
                }
            } else {
                currentProduct *= nums[i];
                maxProduct = Math.max(maxProduct, Math.max(currentProduct, nums[i]));
                if (currentProduct == 0) {
                    currentProduct = nums[i];
                }
            }
        }

        currentProduct = nums[nums.length -1];
        for (int i = nums.length - 2; i >=0 ; i--) {
            if (nums[i] == 0) {
                if (currentProduct <= 0) {
                    currentProduct *= nums[i];
                    maxProduct = Math.max(maxProduct, Math.max(currentProduct, nums[i]));
                } else {
                    maxProduct = Math.max(maxProduct, currentProduct);
                    currentProduct = 1;
                }
            } else {
                currentProduct *= nums[i];
                maxProduct = Math.max(maxProduct, Math.max(currentProduct, nums[i]));
                if (currentProduct == 0) {
                    currentProduct = nums[i];
                }
            }
        }
        return maxProduct;
    }
}
