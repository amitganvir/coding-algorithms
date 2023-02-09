package com.datastucture.arrays;

public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        missingNumber.MissingNumber(new int[]{6,1,2,8,3,4,7,10,5}, 10);
    }


    int MissingNumber(int array[], int n) {

        int minNumber = 0;
        int maxNumber = 0;
        int sum = 0;
        for (int num: array) {

            minNumber = Math.min(minNumber, num);
            maxNumber = Math.max(maxNumber, num);
            sum += num;
        }

        int totalSum =  0;
        for (int i = minNumber; i <= maxNumber; i++) {
            totalSum += i;
        }

        return totalSum - sum;
    }
}
