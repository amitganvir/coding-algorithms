package com.datastucture.dynamicprogramming;

public class JumpGame {

    public static void main(String[] args) {

        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new JumpGame().canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
    }


    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        int lastIndex = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (lastIndex - i <= nums[i]) {
                dp[i] = true;
                lastIndex = i;
            }
        }

        return dp[0];
    }
}
