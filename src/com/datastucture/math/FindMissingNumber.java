package com.datastucture.math;

public class FindMissingNumber {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,6,5};

        int max = 0;
        int sum = 0;
        int actualSum = 0;
        for (int num: nums) {
            max = Math.max(max, num);
            sum += num;
        }

        for (int i = 1; i <= max; i++) actualSum += i;

        System.out.println(actualSum - sum);

    }
}
