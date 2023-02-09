package com.datastucture.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MoveZeros {

    public static void main(String[] args) {

        //int[] inputArray = new int[]{0, 1, 0, 3, 12};
        //new MoveZeros().moveZeroes(inputArray);

        int[] inputArray = new int[]{1, 3, 0, 12, 0, 0};
        new MoveZeros().moveZeroes(inputArray);

        System.out.println();
    }

    public void moveZeroes(int[] nums) {

        int zeroIndex = 0;
        int nonZeroIndex = 0;

        while (nonZeroIndex < nums.length) {

            if (nums[nonZeroIndex] != 0) {
                int nonZeroSwap = nums[nonZeroIndex];
                int zeroSwap = nums[zeroIndex];
                nums[zeroIndex++] = nonZeroSwap;
                nums[nonZeroIndex] = zeroSwap;
            } else {
                if (nums[zeroIndex] != 0) {
                    zeroIndex = nonZeroIndex;
                }
            }
            nonZeroIndex++;
        }

    }
}
