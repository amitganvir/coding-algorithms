package com.datastucture.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{3, 6, 9});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(Collections.emptyList());

        for (int num : nums) {
            List<List<Integer>> tempList = new ArrayList<>();
            for (List<Integer> list : resultList) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(num);
                tempList.add(newList);
            }
            resultList.addAll(tempList);
        }

        return resultList;
    }
}
