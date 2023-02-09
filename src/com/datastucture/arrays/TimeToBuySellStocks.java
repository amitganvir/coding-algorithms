package com.datastucture.arrays;

public class TimeToBuySellStocks {

    public static void main(String[] args) {
        //System.out.println(new TimeToBuySellStocks().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        findBuySellStockPrices(new int[]{8, 6, 5, 4, 3, 2, 1});
    }

    public int maxProfit(int[] prices) {

        if (prices.length == 1) {
            return 0;
        } else if (prices.length == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }

        int buyPrice = prices[0];
        int buyPriceIndex = 0;
        int tradeBuyPrice = Integer.MIN_VALUE;
        int tradeSellPrice = Integer.MIN_VALUE;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
                buyPriceIndex = i;
            } else {
                int currentTradePrice = prices[i] - prices[buyPriceIndex];

                if (currentTradePrice > profit) {
                    profit = currentTradePrice;
                    tradeBuyPrice = prices[buyPriceIndex];
                    tradeSellPrice = prices[i];
                }
                buyPrice = Math.min(buyPrice, prices[i]);
            }
        }

        System.out.println("TradeBuyPrice=" + tradeBuyPrice + " " + "TradeSellPrice=" + tradeSellPrice);
        return profit;
    }

    public static void findBuySellStockPrices(int[] array) {

        int buyPrice = array[0];
        int buyPriceIndex = 0;
        int tradeBuyPrice = buyPrice;
        int tradeSellPrice = buyPrice;
        int profit = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {

            if (buyPrice > array[i]) {
                int currentProfit = array[i] - buyPrice;

                if (currentProfit > profit) {
                    tradeSellPrice = array[i];
                    tradeBuyPrice = buyPrice;
                    profit = currentProfit;
                }

                buyPrice = array[i];
                buyPriceIndex = i;

            } else {
                int currentTradePrice = array[i] - array[buyPriceIndex];

                if (currentTradePrice > profit) {
                    profit = currentTradePrice;
                    tradeBuyPrice = array[buyPriceIndex];
                    tradeSellPrice = array[i];
                }
                buyPrice = Math.min(buyPrice, array[i]);
            }

        }
        System.out.println("Buy Price" + tradeBuyPrice + " Sell Price " + tradeSellPrice);
    }
}
