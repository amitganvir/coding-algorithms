package com.datastucture.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int numberOfWays = dfs(nums, target, 0, 0, new HashMap<>());
        return numberOfWays;
    }

    public int dfs(int[] nums, int target, int currentSum, int index, Map<String, Integer> cache) {

        if (index >= nums.length) {
            return currentSum == target ? 1: 0;
        }

        String key = index + "-" + currentSum;

        if (cache.containsKey(key)) return cache.get(key);

        int waysUsingAdding = dfs(nums, target, currentSum + nums[index], index + 1, cache);
        int waysUsingSubtraction = dfs(nums, target, currentSum - nums[index], index + 1, cache);

        int totalWays = waysUsingAdding + waysUsingSubtraction;

        cache.put(key, totalWays);

        return totalWays;
    }


}
