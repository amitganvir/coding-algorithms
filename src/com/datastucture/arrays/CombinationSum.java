package com.datastucture.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[] {2, 3, 6, 7}, 7);
        //new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combinationSumList = new ArrayList<>();
        dfs(0, 0, target, combinationSumList, new ArrayList<>(), candidates);
        return combinationSumList;
    }

    private void dfs(int currentIndex, int currentSum, int target,
                     List<List<Integer>> combinationSum, List<Integer> currentList, int[] candidates) {

        if (currentSum == target) {
            combinationSum.add(new ArrayList<>(currentList));
            return;
        } else if (currentSum > target || currentIndex >= candidates.length) {
            return;
        }

        currentList.add(candidates[currentIndex]);
        dfs(currentIndex, currentSum + candidates[currentIndex], target, combinationSum, currentList, candidates);

        currentList.remove(currentList.size() - 1);
        dfs(currentIndex + 1, currentSum, target, combinationSum, currentList, candidates);
    }
}
