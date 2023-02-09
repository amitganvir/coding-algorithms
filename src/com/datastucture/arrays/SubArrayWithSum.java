package com.datastucture.arrays;

import java.util.ArrayList;

public class SubArrayWithSum {

    public static void main(String[] args) {
        int[] inputArray = new int[]{142,112,54,69,148,45,63,158,38,60,124,142,130,179,117,36,191,43,89,107,41,143,65,49,47,6,91,130,171,151,7,102,194,149,30,24,85,155,157,41,167,177,132,109,145,40,27,124,138,139,119,83,130,142,34,116,40,59,105,131,178,107,74,187,22,146,125,73,71,30,178,174,98,113};

        //subarraySum(new int[]{1,2,3,7,5}, 42, 12);
        subarraySum(inputArray, 42, 665);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        int leftIndex = 0;
        int rightIndex = 1;

        ArrayList<Integer> resultList = new ArrayList<>();

        if (s <= 0) {
            resultList.add(-1);
            return resultList;
        }
        int currentSum = arr[leftIndex];

        if (currentSum == s) {
            resultList.add(leftIndex + 1);
            resultList.add(leftIndex + 1);
            return resultList;
        }
        while (leftIndex < arr.length) {

            if (currentSum == s) {
                leftIndex++;
                break;
            }

            if (currentSum < s){
                if (rightIndex >= arr.length) {
                    break;
                }
                currentSum += arr[rightIndex++];
                continue;
            }

            currentSum -= arr[leftIndex++];
        }

        if (currentSum != s) {
            resultList.add(-1);
            return resultList;
        }

        rightIndex = Math.min(rightIndex, arr.length);

        resultList.add(leftIndex);
        resultList.add(rightIndex);
        return resultList;
    }
}
