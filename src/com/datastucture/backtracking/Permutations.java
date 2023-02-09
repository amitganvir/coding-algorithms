package com.datastucture.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int num : nums) {
            resultList = getPermutations(num, resultList);
        }
        return resultList;
    }

    private List<List<Integer>> getPermutations(int val, List<List<Integer>> currentList) {

        if (currentList.isEmpty()) {
            currentList.add(List.of(val));
            return currentList;
        }

        List<List<Integer>> newList = new ArrayList<>();
        for (List<Integer> tempList: currentList) {

            int index = 0;

            while (index <= tempList.size()) {
                List<Integer> clonedList = new ArrayList<>(tempList);
                clonedList.add(index, val);;
                newList.add(clonedList);
                index++;
            }
        }
        return newList;
    }
}
