package com.datastucture.dynamicprogramming;

public class ClimbingStairs {

    public static void main(String args[]) {
        System.out.println(numWays(3, new int[]{1,2}));
    }

    private static int numWays(int n, int[] steps) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int step: steps) {
                if (i - step >= 0) {
                    total += dp[i - step];
                }
            }
            dp[i] = total;
        }

        return dp[n];
    }
}
