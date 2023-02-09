package com.datastucture.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        coinChange(Stream.of(1, 2, 5).collect(Collectors.toList()), 11);
        //coinChange.coinChange(new int[]{2}, 3);
        //coinChange.coinChange(new int[]{186, 419, 83, 408}, 6249);
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = 0; i < dp.length; i++) {

                if (i < coin) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        System.out.println(Arrays.toString(coins) + " --> " + dp[amount]);
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    public static int coinChange(List<Integer> coins, int total) {

        int[] result = new int[total + 1];
        Arrays.fill(result, total + 1);
        result[0] = 0;
        coins.sort(Comparator.naturalOrder());

        for (int coin : coins) {
            for (int i = 0; i <= total; i++) {
                if (i >= coin) {
                    result[i] = Math.min(result[i], result[i - coin] + 1);
                }
            }
        }
        return result[total];
    }
}
