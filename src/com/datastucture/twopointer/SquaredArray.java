package com.datastucture.twopointer;

import java.util.Arrays;

public class SquaredArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaredArray().sortedSquares(new int[]{-4, -1, 0,3,10})));
    }

    public int[] sortedSquares(int[] nums) {

        int leftIndex = 0;
        int rightIndex = nums.length - 1;


        while (leftIndex < rightIndex) {
            int leftNum = nums[leftIndex];
            int rightNum = nums[rightIndex];

            if (Math.abs(leftNum) > rightNum) {
                nums[leftIndex] = rightNum;
                nums[rightIndex] = leftNum * leftNum;
            } else {
                nums[rightIndex]  = rightNum * rightNum;
            }

            rightIndex--;



        }

        return nums;
    }
}
