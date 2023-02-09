package com.datastucture.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellWithCoolDown {

    public static void main(String[] args) {
        BestTimeToBuyAndSellWithCoolDown bestTimeToBuyAndSellWithCoolDown = new BestTimeToBuyAndSellWithCoolDown();
        //bestTimeToBuyAndSellWithCoolDown.maxProfit(new int[]{1,2,3,0,2});
        bestTimeToBuyAndSellWithCoolDown.maxProfit(new int[]{6, 1, 3, 2, 4, 7});
    }

    public int maxProfit(int[] prices) {
        Map<String, Integer> cache = new HashMap<>();
        int profit = dfs(prices, 0, null, cache, false);
        return profit;
    }

    public int dfs(int[] prices, int indexToStartBuySell, Integer buyPrice, Map<String, Integer> cache, boolean buying) {

        if (indexToStartBuySell >= prices.length) return 0;

        String key = indexToStartBuySell + "-" + buyPrice + "-" + buying;

        if (cache.containsKey(key)) return cache.get(key);

        int sellerProfit = 0;
        buyPrice = buyPrice == null ? prices[indexToStartBuySell] : Math.min(prices[indexToStartBuySell], buyPrice);
        int profit = prices[indexToStartBuySell] - buyPrice;
        int anotherProfit = dfs(prices, indexToStartBuySell + 2, null, cache, true);
        sellerProfit = profit + anotherProfit;

        int notSellingAtIndexProfit = dfs(prices, indexToStartBuySell + 1, buyPrice, cache, false);
        int result = Math.max(notSellingAtIndexProfit, sellerProfit);
        cache.put(key, result);

        return result;
    }
}
