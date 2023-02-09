package com.datastucture.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {
    public static void main(String[] args) {
        //new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        new ThreeSum().threeSumLatest(new int[]{0, 0, 0, 0});
        //new ThreeSum().threeSum(new int[]{-2, 0, 0, 2, 2});
    }

    public List<List<Integer>> threeSumLatest(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int lowIndex = i + 1;
            int highIndex = nums.length - 1;

            if (i - 1 > 0 && nums[i - 1] == nums[i]) continue;

            while (lowIndex < highIndex) {
                int sum = nums[i] + nums[lowIndex] + nums[highIndex];

                if (sum == 0) {

                    resultList.add(List.of(nums[i], nums[lowIndex], nums[highIndex]));
                    while (lowIndex < highIndex && nums[lowIndex + 1] == nums[lowIndex]) {
                        lowIndex++;
                    }

                    while (lowIndex < highIndex && nums[highIndex - 1] == nums[highIndex]) {
                        highIndex--;
                    }

                    lowIndex++;
                    highIndex--;

                } else if (sum < 0) {
                    lowIndex++;
                } else {
                    highIndex--;
                }
            }
        }

        return resultList;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (i + 1 >= nums.length) {
                break;
            }
            computeThreeSum(i, i + 1, nums, resultList);
        }

        System.out.println(resultList);
        return resultList;
    }

    private void computeThreeSum(int firstNumIndex, int secondIndex, int[] nums, List<List<Integer>> resultList) {
        int thirdIndex = nums.length - 1;

        while (secondIndex < thirdIndex) {

            int currentSum = nums[firstNumIndex] + nums[secondIndex] + nums[thirdIndex];
            if (currentSum == 0) {

                if (secondIndex - 1 > firstNumIndex && nums[secondIndex] == nums[secondIndex - 1]) {
                    secondIndex++;
                    continue;
                } else if (thirdIndex + 1 < nums.length && nums[thirdIndex] == nums[thirdIndex + 1]) {
                    thirdIndex--;
                    continue;
                }

                resultList.add(Stream.of(nums[firstNumIndex], nums[secondIndex], nums[thirdIndex]).collect(Collectors.toList()));
                secondIndex++;
                thirdIndex--;
            } else if (currentSum < 0) {
                secondIndex++;
            } else {
                thirdIndex--;
            }
        }
    }
}
