package com.datastucture.arrays;

public class NumbersLessThanSelf {

    public static void main(String[] args) {
        new NumbersLessThanSelf().smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3});
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] numberCountArray = new int[100];
        int[] numberLessThanArray = new int[100];

        for (int i = 0; i < nums.length; i++) {
            numberCountArray[nums[i]] += 1;
        }

        int countTillNow = 0;

        for (int i = 0; i < numberCountArray.length; i++) {
            numberLessThanArray[i] = countTillNow;
            countTillNow += numberCountArray[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            nums[i] = numberLessThanArray[number];
        }

        return nums;
    }
}
