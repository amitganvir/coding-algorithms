package com.datastucture.greedy;

import java.util.Arrays;

public class BoatsToSave {

    public static void main(String[] args) {
        BoatsToSave boatsToSave = new BoatsToSave();
        boatsToSave.numRescueBoats(new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50);
    }


    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int leftIndex = 0;
        int rightIndex = people.length - 1;

        int currentLimit = limit;
        int numberOfBoats = 0;
        while (leftIndex <= rightIndex) {

            int tempLimit = currentLimit;
            if (people[leftIndex] + people[rightIndex] <= currentLimit) {
                currentLimit -= people[leftIndex++] + people[rightIndex--];
            } else if (people[rightIndex] <= currentLimit) {
                currentLimit -= people[rightIndex--];
            } else if (people[leftIndex] <= currentLimit) {
                currentLimit -= people[leftIndex++];
            }

            if (currentLimit == 0 || tempLimit == currentLimit || people[leftIndex] > currentLimit) {
                numberOfBoats++;
                currentLimit = limit;
            } else if (leftIndex > rightIndex) {
                numberOfBoats++;
            }
        }

        return numberOfBoats;

    }
}
