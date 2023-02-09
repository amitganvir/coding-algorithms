package com.datastucture.closest;

import java.util.ArrayList;
import java.util.List;

public class ClosestElements {

    public static void main(String[] args) {
        ClosestElements closestElements = new ClosestElements();
        closestElements.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        if (x < arr[0]) {
            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                resultList.add(arr[i]);
            }
            return resultList;
        }

        List<Integer> resultList = new ArrayList<>();


        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (rightIndex - leftIndex >= k) {

            Integer leftNumber = leftIndex >= 0 ? arr[leftIndex] : null;
            Integer rightNumber = rightIndex < arr.length ? arr[rightIndex] : null;

            if (leftNumber == null || rightNumber == null) break;

            if (Math.abs(leftNumber - x) < Math.abs(rightNumber - x) || (Math.abs(leftNumber - x) == Math.abs(rightNumber - x) && leftNumber < rightNumber)) {
                //resultList.add(leftNumber);
                rightIndex--;
            } else {
                //resultList.add(rightNumber);
                leftIndex++;
            }
        }

        for (int i = leftIndex; i <= rightIndex; i++) {
            resultList.add(arr[i]);
        }

        System.out.println(resultList);
        return resultList;
    }

    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target)
                return mid;
            if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}
