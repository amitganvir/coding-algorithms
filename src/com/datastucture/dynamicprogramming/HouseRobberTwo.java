package com.datastucture.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberTwo {

    public static void main(String[] args) {
        HouseRobberTwo houseRobberTwo = new HouseRobberTwo();
        houseRobberTwo.robTwo(new int[]{1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3});
    }

    public int robTwo(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int result = Math.max(robOne(nums, 0, nums.length - 2), robOne(nums, 1, nums.length - 1));
        System.out.printf("Input=%s Result=%d", Arrays.toString(nums), result);
        return result;
    }

    public int robOne(int[] nums, int startIndex, int endIndex) {
        int firstRob = 0;
        int secondRob = 0;

        for (int i = startIndex; i <= endIndex; i++) {

            int tempRob = Math.max(nums[i] + firstRob, secondRob);
            firstRob = secondRob;
            secondRob = tempRob;
        }

        return secondRob;
    }

    public int robHelper(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
