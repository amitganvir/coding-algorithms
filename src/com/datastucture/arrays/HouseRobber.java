package com.datastucture.arrays;

public class HouseRobber {

    public static void main(String[] args) {

        //System.out.println("{2, 1, 1, 2} -> " + new HouseRobber().rob(new int[]{2, 1, 1, 2}));
        System.out.println("[2,7,9,3,1] -> " + new HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));

    }

    public int rob(int[] nums) {

        int firstRob = 0;
        int secondRob = 0;

        for (int i = 0; i < nums.length; i++) {

            int temp = Math.max(nums[i] + firstRob, secondRob);
            firstRob = secondRob;
            secondRob = temp;
        }

        return secondRob;
    }
}
