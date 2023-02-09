package com.datastucture.arrays;

public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,6,6,5};
        int largestNum = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i=0; i < arr.length; i++) {

            if (arr[i] > largestNum) {
                secondLargest = largestNum;
                largestNum = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largestNum) {
                secondLargest = arr[i];
            }
        }
        System.out.println(secondLargest);
    }
}
