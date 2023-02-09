package com.datastucture.dynamicprogramming;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        minCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    }

    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int firstStairCost = cost[0];
        int secondStairCost = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int tempCost = cost[i] + Math.min(firstStairCost, secondStairCost);
            firstStairCost = secondStairCost;
            secondStairCost = tempCost;
        }

        return Math.min(firstStairCost, secondStairCost);
    }
}
