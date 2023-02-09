package com.datastucture.arrays;

public class RotateArray {

    public static void main(String[] args) {

        new RotateArray().rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 4);
    }

    public void rotate(int[] nums, int k) {

        int length = nums.length;
        if (k == 0 || length == 1) {
            return;
        }
        int numberOfActualSteps = k % length;

        flipArray(nums, 0, length - 1);
        flipArray(nums, 0, k - 1);
        flipArray(nums, k, length - 1);
    }

    private void flipArray(int[] nums, int startIndex, int endIndex) {

        int leftIndex = startIndex;
        int rightIndex = endIndex;

        while (leftIndex < rightIndex) {
            int swapNumber = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = swapNumber;
            leftIndex++;
            rightIndex--;
        }
    }
}
