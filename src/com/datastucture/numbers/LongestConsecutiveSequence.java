package com.datastucture.numbers;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int consecutiveSequence = longestConsecutiveSequence(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        System.out.println(consecutiveSequence);
    }

    private static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        int result = 0;
        int tempResult = 0;
        for (int i = 0; i < nums.length; i++) {

            if (!hashSet.contains(nums[i] - 1)) {
                int currentNum = nums[i] + 1;
                tempResult++;

                if (hashSet.contains(currentNum)) {

                    while (hashSet.contains(currentNum)) {
                        tempResult++;
                        hashSet.remove(currentNum);
                        currentNum++;
                    }
                }
                result = Math.max(result, tempResult);
                tempResult = 0;
            }
        }

        return result;
    }
}
