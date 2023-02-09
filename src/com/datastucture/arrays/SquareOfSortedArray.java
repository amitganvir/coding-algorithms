package com.datastucture.arrays;

public class SquareOfSortedArray {

    public static void main(String[] args) {
        //new SquareOfSortedArray().sortedSquares(new int[]{-15, -10, -8, -4, -1, 0, 3, 10});
        //new SquareOfSortedArray().sortedSquares(new int[]{-7,-3,2,3,11});
        new SquareOfSortedArray().sortedSquares(new int[]{-5, -3, -2, -1});
    }

    public int[] sortedSquares(int[] nums) {

        int[] resultNums = new int[nums.length];

        int firstPositiveNumberIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                firstPositiveNumberIndex = i;
                break;
            }
        }

        if (firstPositiveNumberIndex == 0) {

            if (nums[0] >= 0) {
                return nums;
            } else {

                int leftIndex = 0;
                int rightIndex = nums.length - 1;

                while (leftIndex <= rightIndex) {
                    int swapNum = nums[leftIndex];
                    nums[leftIndex] = (int) Math.pow(nums[rightIndex], 2);
                    nums[rightIndex] = (int) Math.pow(swapNum, 2);
                    leftIndex++;
                    rightIndex--;
                }
            }
            return nums;
        }

        int leftIndex = firstPositiveNumberIndex - 1;
        int rightIndex = firstPositiveNumberIndex;
        int resultArrayIndex = 0;

        while (leftIndex >= 0 && rightIndex < nums.length) {

            if (Math.abs(nums[leftIndex]) > nums[rightIndex]) {
                resultNums[resultArrayIndex++] = (int) Math.pow(nums[rightIndex++], 2);
            } else {
                resultNums[resultArrayIndex++] = (int) Math.pow(nums[leftIndex--], 2);
            }
        }

        if (leftIndex >= 0) {
            while (leftIndex >= 0) {
                resultNums[resultArrayIndex++] = (int) Math.pow(nums[leftIndex--], 2);
            }
        }

        if (rightIndex < nums.length) {
            while (rightIndex < nums.length) {
                resultNums[resultArrayIndex++] = (int) Math.pow(nums[rightIndex++], 2);
            }
        }

        return resultNums;
    }
}
