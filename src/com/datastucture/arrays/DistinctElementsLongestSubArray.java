package com.datastucture.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of elements, return the length of the longest subarray where all its elements are distinct.
 *
 * For example:
 * given the array [5, 1, 3, 5, 2, 3, 4, 1]
 * return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].
 */
public class DistinctElementsLongestSubArray {

    public static void main(String[] args) {
        assert distinctElementsLongestSubArray(new int[]{1, 2, 3, 4, 5}) == 5;
        assert distinctElementsLongestSubArray(new int[]{5, 1, 3, 5, 2, 3, 4, 1}) == 5;
        assert distinctElementsLongestSubArray(new int[]{1, 3, 5, 2, 3, 5, 4, 1}) == 5;
        assert distinctElementsLongestSubArray(new int[]{1,1}) == 1;
        assert distinctElementsLongestSubArray(new int[]{1}) == 1;

    }

    private static int distinctElementsLongestSubArray(int[] elements) {

        if (elements == null || elements.length == 0) {
            return 0;
        }

        int leftPointer = 0;
        int rightPointer = 0;
        int maxLength = 0;

        Set<Integer> uniqueElements = new HashSet<>();

        while (leftPointer <= rightPointer && rightPointer < elements.length) {
            if (!uniqueElements.contains(elements[rightPointer])) {
                uniqueElements.add(elements[rightPointer]);
                rightPointer++;
            } else {
                maxLength = Math.max(rightPointer - leftPointer, maxLength);
                uniqueElements.remove(elements[leftPointer++]);
            }
        }
        return Math.max(rightPointer - leftPointer, maxLength);
    }
}
