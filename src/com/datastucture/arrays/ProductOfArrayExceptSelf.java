package com.datastucture.arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().productExceptSelf(new int[] {1, 2, 3, 4});
    }

    public int[] productExceptSelf(int[] nums) {
        int[] resultArray = new int[nums.length];

        resultArray[0] = 1;

        int productSoFar = 1;

        for (int i = 0; i < nums.length; i++) {
            resultArray[i] = productSoFar;
            productSoFar *= nums[i];
        }

        productSoFar = 1;
        for (int i = nums.length - 1; i >=0; i--) {
            resultArray[i] *= productSoFar;
            productSoFar *= nums[i];
        }


        return resultArray;
    }
}
