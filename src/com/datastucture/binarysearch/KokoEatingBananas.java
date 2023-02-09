package com.datastucture.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        kokoEatingBananas.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);

//        kokoEatingBananas.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);
//        kokoEatingBananas.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6);
//        kokoEatingBananas.minEatingSpeed(new int[]{1, 1, 1, 999999999}, 10);
    }

    public int minEatingSpeed(int[] piles, int h) {

        int maxPileCount = Arrays.stream(piles).max().getAsInt();
        int minPileCount = 1;
        int result = maxPileCount;

        while (minPileCount < maxPileCount) {
            int currentPile = (maxPileCount + minPileCount) / 2;

            int timeTakenAtCurrentPile = 0;
            for (int pile : piles) {
                timeTakenAtCurrentPile +=  Math.ceil((double) pile / currentPile);
            }
            if (timeTakenAtCurrentPile > h) {
                minPileCount = currentPile + 1;
            } else {
                result = Math.min(result, currentPile);
                maxPileCount = currentPile;
            }
        }

        return result;
    }

}
