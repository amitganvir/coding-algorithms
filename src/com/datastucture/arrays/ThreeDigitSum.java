package com.datastucture.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeDigitSum {

    public static void main(String[] args) {
        System.out.println(hasThreeNumbersMatchingK(new int[]{20, 303, 3, 4, 25}, 32));
        System.out.println(hasThreeNumbersMatchingK(new int[]{20, 303, 3, 4, 25}, 49));
        System.out.println(hasThreeNumbersMatchingK(new int[]{20, 303, 3, 4, 25}, 22));

        System.out.println("_____________________________________________________________");

        System.out.println(hasThreeNumbersMatchingKWithHashSet(new int[]{20, 303, 3, 4, 25}, 32));
        System.out.println(hasThreeNumbersMatchingKWithHashSet(new int[]{20, 303, 3, 4, 25}, 49));
        System.out.println(hasThreeNumbersMatchingKWithHashSet(new int[]{20, 303, 3, 4, 25}, 22));

        System.out.println("_____________________________________________________________");

        System.out.println(withoutSpaceComplexityON2(new int[]{20, 303, 3, 4, 25}, 32));
        System.out.println(withoutSpaceComplexityON2(new int[]{20, 303, 3, 4, 25}, 49));
        System.out.println(withoutSpaceComplexityON2(new int[]{20, 303, 3, 4, 25}, 22));
    }

    /*
    Time complexity O(N3)
     */
    private static boolean hasThreeNumbersMatchingK(int[] arr, int k) {

        for (int firstNumIndex = 0; firstNumIndex < arr.length; firstNumIndex++) {

            for (int secondNumIndex = firstNumIndex + 1; secondNumIndex < arr.length; secondNumIndex++) {

                if (arr[firstNumIndex] + arr[secondNumIndex] > k) {
                    continue;
                }

                for (int thirdNumIndex = secondNumIndex + 1; thirdNumIndex < arr.length; thirdNumIndex++) {

                    if (arr[firstNumIndex] + arr[secondNumIndex] + arr[thirdNumIndex] == k) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    /*
    Time complexity O(N2)
     */
    private static boolean hasThreeNumbersMatchingKWithHashSet(int[] arr, int k) {

        for (int firstNumIndex = 0; firstNumIndex < arr.length; firstNumIndex++) {

            int targetSum = k - arr[firstNumIndex];
            Set<Integer> hashSet = new HashSet<>();

            for (int secondNumIndex = firstNumIndex + 1; secondNumIndex < arr.length; secondNumIndex++) {

                if (hashSet.contains(targetSum - arr[secondNumIndex])) {
                    return true;
                } else {
                    hashSet.add(arr[secondNumIndex]);
                }
            }
        }

        return false;

    }

    private static boolean withoutSpaceComplexityON2(int[] arr, int k) {

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            int leftIndex = i+1;
            int rightIndex = arr.length - 1;

            while (leftIndex < rightIndex) {

                if (arr[i] + arr[leftIndex] + arr[rightIndex] == k) {
                    return true;
                } else if (arr[i] + arr[leftIndex] + arr[rightIndex] < k) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }

        }

        return false;
    }
}
