package com.datastucture.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        longestIncreasingSubsequence.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        longestIncreasingSubsequence.lengthOfLISDfs(new int[]{0, 1, 0, 3, 2, 3});
//        longestIncreasingSubsequence.lengthOfLISDfs(new int[]{0, 1, 0, 3, 2, 3});
//        longestIncreasingSubsequence.lengthOfLISDfs(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
//        longestIncreasingSubsequence.lengthOfLISDfs(new int[]{7, 7, 7, 7, 7, 7, 7});
    }

    public int lengthOfLISDfs(int[] nums) {

        Map<Integer, Integer> cache = new HashMap<>();
        int maxList = 1;
        for (int i = 0; i < nums.length; i++) {
            int dfsLength = dfs(nums, i, cache);
            maxList = Math.max(dfsLength, maxList);
        }

        System.out.format("Input=%s output=%d", Arrays.toString(nums), maxList);
        System.out.println();
        return maxList;
    }

    private int dfs(int[] nums, int index, Map<Integer, Integer> countMap) {

        if (countMap.containsKey(index)) {
            return countMap.get(index);
        }

        int localCount = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] < nums[i]) {
                int tempCount = 1 + dfs(nums, i, countMap);
                localCount = Math.max(localCount, tempCount);
            }
        }

        countMap.put(index, localCount);

        return localCount;
    }

    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        int max = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
            max = Math.max(max, lis[i]);
        }
        System.out.println("Result with iterative approach " + max);
        return max;
    }
}
