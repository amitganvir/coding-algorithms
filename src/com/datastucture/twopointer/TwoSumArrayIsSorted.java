package com.datastucture.twopointer;

public class TwoSumArrayIsSorted {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {

        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {

            int sum = numbers[leftIndex] + numbers[rightIndex];
            if (sum == target) {
                break;
            }

            if (sum < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return new int[]{leftIndex + 1, rightIndex + 1};
    }
}
