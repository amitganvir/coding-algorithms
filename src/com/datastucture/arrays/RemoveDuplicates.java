package com.datastucture.arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates(new int[]{1, 1, 2});
    }

    public int removeDuplicates(int[] nums) {

        if (nums.length == 1) return 1;
        if (nums.length == 2) return nums[0] != nums[1] ? 2 : 1;

        int result = 1;

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex <= rightIndex && rightIndex < nums.length) {

            int currentElement = nums[rightIndex];
            int previousElement = nums[leftIndex];

            if (currentElement != previousElement) {
                leftIndex++;
                nums[leftIndex] = currentElement;
                result++;
            }
            rightIndex++;
        }

        return result;
    }
}
