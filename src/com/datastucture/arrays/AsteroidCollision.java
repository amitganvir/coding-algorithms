package com.datastucture.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsteroidCollision {

    public static void main(String[] args) {
        asteroidCollision(6, new int[]{-5, 5, 2, 1, 1, -2});
    }

    public static int[] asteroidCollision(int N, int[] asteroids) {
        if (asteroids.length == 1) return asteroids;

        List<Integer> resultList = new ArrayList<>();
        resultList.add(asteroids[0]);

        int index = 1;

        while (index < asteroids.length) {
            int currentAsteroid = asteroids[index];
            if (currentAsteroid < 0) {

                if (resultList.isEmpty()) {
                    resultList.add(currentAsteroid);
                    index++;
                    continue;
                }

                int lastIndex = resultList.size() - 1;
                int elementInList = resultList.get(lastIndex);
                if (elementInList < 0) {
                    resultList.add(currentAsteroid);
                    index++;
                    continue;
                } else {

                    if (elementInList < Math.abs(currentAsteroid)) {
                        resultList.remove(lastIndex);
                    } else if (elementInList == Math.abs(currentAsteroid)) {
                        resultList.remove(lastIndex);
                        index++;
                    }
                    else {
                        index++;
                    }
                }
            } else {
                resultList.add(currentAsteroid);
                index++;
            }
        }


        int[] resultArray = new int[resultList.size()];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = resultList.get(i);
        }

        //System.out.println(Arrays.toString(asteroids) + " --> " + Arrays.toString(resultArray));

        return resultArray;
    }
}
