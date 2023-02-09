package com.datastucture.stacks;

import java.util.Arrays;
import java.util.HashMap;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        dailyTemperatures.dailyTemperatures(new int[]{77, 41, 41, 41, 41, 77, 41, 77, 77, 77});
    }

    public int[] dailyTemperatures(int[] temperatures) {

        if (temperatures.length == 1) return new int[]{0};
        if (temperatures.length == 2) return new int[]{temperatures[1] > temperatures[0] ? 1 : 0, 0};
        HashMap<Integer, Integer> temperatureToIndexMap = new HashMap<>();

        int[] result = new int[temperatures.length];

        int leftIndex = 0;
        int rightIndex = 1;

        while (leftIndex < rightIndex && leftIndex < temperatures.length) {
            if (temperatureToIndexMap.containsKey(temperatures[leftIndex])) {
                Integer indexOfHigherTemperature = temperatureToIndexMap.get(temperatures[leftIndex]);
                if (indexOfHigherTemperature > leftIndex) {
                    result[leftIndex] = indexOfHigherTemperature - leftIndex;
                }

                if (indexOfHigherTemperature == 0) {
                    result[leftIndex] = indexOfHigherTemperature;
                }
                leftIndex++;
                rightIndex = leftIndex + 1;
                continue;
            }

            if (rightIndex >= temperatures.length) {
                result[leftIndex] = 0;
                temperatureToIndexMap.put(temperatures[leftIndex], 0);
                leftIndex++;
                rightIndex = leftIndex + 1;
            } else if (temperatures[leftIndex] < temperatures[rightIndex]) {
                result[leftIndex] = (rightIndex - leftIndex);
                temperatureToIndexMap.put(temperatures[leftIndex], rightIndex);
                leftIndex++;
                rightIndex = leftIndex + 1;
            } else {
                rightIndex++;
            }
        }

        System.out.println(Arrays.toString(result));
        return result;
    }
}
