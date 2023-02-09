package com.datastucture.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionSubsetSumEqually {

    public static void main(String[] args) {
        PartitionSubsetSumEqually partitionSubsetSumEqually = new PartitionSubsetSumEqually();
        //partitionSubsetSumEqually.canPartition(new int[]{2,2,1,1});
        partitionSubsetSumEqually.canPartition(new int[]{1,5,11,5});
    }

     private boolean dfs(int[] nums, int index, int targetSum) {

        if (targetSum < 0 || index >= nums.length) {
            return false;
        }

        if (targetSum ==  0) {
            return true;
        }

        boolean consideringCurrentNumber = dfs(nums, index + 1, targetSum - nums[index]);
        boolean ignoringCurrentNumber = dfs(nums, index + 1, targetSum);

        return consideringCurrentNumber || ignoringCurrentNumber;
    }

    public boolean canPartitionDfs(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 > 0) return false;
        return dfs(nums, 0, sum / 2);
    }

    public boolean canPartition(int[] nums) {

        if (nums.length == 1) return false;
        if (nums.length == 2 && nums[0] == nums[1]) return true;

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 > 0) return false;

        int target = sum / 2;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = nums.length - 1; i >= 0; i--) {

            Set<Integer> nextDp = new HashSet<>();

            for (int dpInt : dp) {
                if (dpInt + nums[i] == target) return true;

                nextDp.add(dpInt + nums[i]);
                nextDp.add(nums[i]);
            }
            nextDp.addAll(dp);
            dp = nextDp;
        }

        return dp.contains(target);
    }

}
