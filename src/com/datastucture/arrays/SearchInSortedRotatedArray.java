package com.datastucture.arrays;

public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        //new SearchInSortedRotatedArray().search(new int[] {4,5,6,7, 8, 9, 10, 11, 12, 13, 14, 0,1,2}, 0);
        new SearchInSortedRotatedArray().search(new int[] {1, 3, 5}, 0);
    }

    public int search(int[] nums, int target) {

        if (nums.length == 2) {
            if (nums[0] == target) return 0;
            else if (nums[1] == target) return 1;
            else return -1;
        }

        int midPointIndex = findRotationIndex(nums);
        int startIndex = 0;
        int endIndex = nums.length - 1;

        if (midPointIndex >=0 ) {
            if (isWithinRange(nums[0], nums[midPointIndex - 1], target)) {
                endIndex = midPointIndex - 1;
            } else {
                startIndex = midPointIndex;
            }
        }

        while (startIndex <= endIndex) {

            int midpoint = (endIndex + startIndex) / 2;

            if (nums[midpoint] == target) {
                return midpoint;
            } else if (nums[midpoint] <= target) {
                startIndex = midpoint + 1;
            } else {
                endIndex = midpoint - 1;
            }
        }



        return -1;
    }

    private boolean isWithinRange(int lowerNum, int higherNum, int target) {

        if (lowerNum <= target && target <= higherNum) {
            return true;
        }

        return false;
    }

    private int findRotationIndex(int[] nums) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {

            int midPoint = (endIndex + startIndex) / 2;

            if (midPoint + 1 < nums.length && nums[midPoint] > nums[midPoint + 1]) {
                return midPoint + 1;
            } else if (nums[startIndex] > nums[midPoint]) {
                endIndex = midPoint - 1;
            } else {
                startIndex = midPoint + 1;
            }
        }

        return -1;
    }
}
