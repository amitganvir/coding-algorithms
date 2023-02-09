package com.datastucture.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeTwo {

    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        CoinChangeTwo coinChangeTwo = new CoinChangeTwo();
        coinChangeTwo.change(5, new int[]{1, 2, 5});
    }

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for( int coin: coins) {
            for (int i = 1; i < dp.length; i++) {
                if (coin <= i) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

    private int combinations(int amount, int[] coins, int coinIndex, int currentAmount, List<Integer> combinations) {

        if (currentAmount >= amount) {

            if (currentAmount == amount) {
                resultList.add(new ArrayList<>(combinations));
                return 1;
            }
            return 0;
        }

        combinations.add(coins[coinIndex]);
        int numberOfWaysWithCurrent = combinations(amount, coins, coinIndex, currentAmount + coins[coinIndex], combinations);

        combinations.remove(combinations.size() - 1);
        int numberOfWaysWithNext = 0;
        if (coinIndex + 1 < coins.length) {
            combinations.add(coins[coinIndex + 1]);
            numberOfWaysWithNext = combinations(amount, coins, coinIndex + 1, currentAmount + coins[coinIndex + 1], combinations);
            combinations.remove(combinations.size() - 1);
        }


        return numberOfWaysWithCurrent + numberOfWaysWithNext;
    }
}
