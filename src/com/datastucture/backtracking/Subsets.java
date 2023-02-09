package com.datastucture.backtracking;

import java.util.*;

public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[]{4,4,4,1,4}, new HashSet<>());
        System.out.println("**************************************");
        subsets.subsetsWithDup(new int[]{4,4,4,1,4}, new HashSet<>());
    }

    public List<List<Integer>> subsets(int[] nums, Set<String> uniqueSubsets) {

        Arrays.sort(nums);
        List<List<Integer>> resultSubset = new ArrayList<>();
        resultSubset.add(List.of());

        for (int num: nums) {

            List<List<Integer>> tempList = new ArrayList<>();
            for (List<Integer> currentEntry: resultSubset) {

                tempList.add(currentEntry);
                List<Integer> currTempList = new ArrayList<>(currentEntry);
                currTempList.add(num);

                if (uniqueSubsets.contains(currTempList.toString())) continue;
                uniqueSubsets.add(currTempList.toString());

                System.out.println(currTempList.toString());

                tempList.add(currTempList);
            }
            resultSubset = tempList;

        }

        return resultSubset;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums, Set<String> uniqueSubsets) {

        List<List<Integer>> resultSubset = new ArrayList<>();
        resultSubset.add(List.of());

        for (int num: nums) {

            List<List<Integer>> tempList = new ArrayList<>();
            for (List<Integer> currentEntry: resultSubset) {

                tempList.add(currentEntry);
                List<Integer> currTempList = new ArrayList<>(currentEntry);
                currTempList.add(num);

                if (uniqueSubsets.contains(currTempList.toString())) continue;
                uniqueSubsets.add(currTempList.toString());

                System.out.println(currTempList.toString());

                tempList.add(currTempList);
            }
            resultSubset = tempList;

        }

        return resultSubset;
    }
}
