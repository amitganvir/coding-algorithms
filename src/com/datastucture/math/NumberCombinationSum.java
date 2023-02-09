package com.datastucture.math;

import java.util.ArrayList;
import java.util.List;

public class NumberCombinationSum {

    public static void main(String[] args) {
        combinationSum(5);
    }

    private static List<List<Integer>> combinationSum(int target) {

        List<List<Integer>> resultList = new ArrayList<>();
        dfs(target, 0, 1, new ArrayList<>(), resultList);

        return resultList;
    }

    private static void dfs(int target, int currentSum, int currentNumber, List<Integer> currentList, List<List<Integer>> resultList) {

        if (currentSum > target || currentNumber >= target) {
            return;
        }

        if (currentSum == target) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(currentNumber);
        dfs(target, currentSum + currentNumber, currentNumber, currentList, resultList);
        currentList.remove(currentList.size() - 1);

        dfs(target, currentSum, currentNumber + 1, currentList,  resultList);
    }
}
