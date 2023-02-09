package com.datastucture.arrays;

import java.util.Arrays;

public class SingleNumber {

    public static void main(String[] args) {

        new SingleNumber().singleNumber(new int[]{30000,500,100,30000,100,30000,100});
    }

    public int singleNumber(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int previousNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            previousNum = ~nums[i];
        }

        return previousNum;
    }
}
