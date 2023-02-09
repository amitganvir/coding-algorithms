package com.datastucture.arrays;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        System.out.println(new FindDuplicateNumber().findDuplicate(new int[] {1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {

        int fastPointer = 0;
        int slowPointer = 0;

        do {
            fastPointer = nums[nums[fastPointer]];
            slowPointer = nums[slowPointer];

            if (fastPointer == slowPointer) {
                break;
            }
        } while (true);

        int secondSlowPointer = 0;

        do {
            slowPointer = nums[slowPointer];
            secondSlowPointer = nums[secondSlowPointer];

            if (slowPointer == secondSlowPointer) {
                return slowPointer;
            }
        } while (true);

    }
}
