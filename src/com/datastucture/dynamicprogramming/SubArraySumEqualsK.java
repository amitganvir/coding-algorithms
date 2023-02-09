package com.datastucture.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static void main(String[] args) {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        subArraySumEqualsK.subarraySum(new int[]{1, 1, 1}, 2);

        subArraySumEqualsK.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7);
    }

    public int subarraySum(int[] arr, int k) {
        Arrays.sort(arr);
        int currentSum = 0;
        int result = 0;
        Map<Integer, Integer> sumToOccurrenceMap = new HashMap<>();
        sumToOccurrenceMap.put(currentSum, 1);

        for (int num : arr) {
            currentSum += num;
            sumToOccurrenceMap.put(currentSum, sumToOccurrenceMap.getOrDefault(currentSum, 0) + 1);
            result += sumToOccurrenceMap.getOrDefault((currentSum - k), 0);
        }

        System.out.println(Arrays.toString(arr) + " => " + k + " => " + result );
        return result;
    }

}
