package com.datastucture.dynamicprogramming;

import java.util.List;

public class KnapSack {

    public static void main(String[] args) {
        findMaxKnapsackProfit(10, List.of(3, 6, 7, 2), List.of(13, 15, 17, 13));
    }

    public static int findMaxKnapsackProfit(int capacity, List<Integer> weights, List<Integer> values) {

        int[] profit = new int[capacity + 1];

        for (int i = 0; i < values.size(); i++) {
            for (int cap = capacity; cap >= 0; cap--) {
                if (weights.get(i) <= cap) {
                    int newProfit = profit[cap - weights.get(i)] + values.get(i);
                    profit[cap] = Math.max(profit[cap], newProfit);
                }
            }
        }
        return profit[capacity];
    }
}
