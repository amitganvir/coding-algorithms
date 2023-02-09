package com.datastucture.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resultList = new ArrayList<>();
        combinations(candidates, resultList, new ArrayList<>(), target, 0, 0);
        return resultList;
    }

    private void combinations(int[] candidates, List<List<Integer>> result, List<Integer> currentList, int target, int currentSum, int index) {

        if (currentSum == target) {
            result.add(new ArrayList<>(currentList));
        }

        if (currentSum > target) return;

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i - 1] == candidates[i]) continue;
            currentList.add(candidates[i]);
            combinations(candidates, result, currentList, target, currentSum + candidates[i], i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
