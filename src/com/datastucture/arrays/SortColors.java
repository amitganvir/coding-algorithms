package com.datastucture.arrays;

public class SortColors {

    public static void main(String[] args) {
        //new SortColors().sortColors(new int[]{2, 0, 2, 1, 1, 0});
        new SortColors().sortColors(new int[]{2, 0, 1});
    }

    public void sortColors(int[] nums) {

        int leftZeroTrackingIndex = 0;
        int rightSecondTrackingIndex = nums.length - 1;
        int currentIndex = 0;

        while (currentIndex < nums.length) {

           int currentIndexNum = nums[currentIndex];

           if (currentIndexNum == 0) {
               if (nums[leftZeroTrackingIndex] == 0) {
                   leftZeroTrackingIndex++;
                   currentIndex++;
                   continue;
               }
               int currentLeftIndexNum = nums[leftZeroTrackingIndex];
               nums[leftZeroTrackingIndex++] = 0;
               nums[currentIndex] = currentLeftIndexNum;
           } else if (currentIndexNum == 2 && currentIndex < rightSecondTrackingIndex) {
               int rightIndexNum = nums[rightSecondTrackingIndex];

               if (rightIndexNum == 2) {
                   rightSecondTrackingIndex--;
                   continue;
               }

               nums[rightSecondTrackingIndex--] = 2;
               nums[currentIndex] = rightIndexNum;
           } else {
               currentIndex++;
           }
        }

    }
}
