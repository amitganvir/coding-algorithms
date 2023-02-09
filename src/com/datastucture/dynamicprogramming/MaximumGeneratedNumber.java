package com.datastucture.dynamicprogramming;

public class MaximumGeneratedNumber {

    public static void main(String[] args) {
        MaximumGeneratedNumber maximumGeneratedNumber = new MaximumGeneratedNumber();
        int result = maximumGeneratedNumber.getMaximumGenerated(3);


        System.out.println("Result: " + result);
    }

    public int getMaximumGenerated(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        int index = 1;
        int runningIndex = 2;
        int maxNum = 0;
        while (index <= n && runningIndex <= n) {

            int firstVal = index * 2;
            int secondVal = index * 2 + 1;

            if (firstVal <= n) {
                int tempIndex = runningIndex++;
                dp[tempIndex] = dp[index];
                maxNum = Math.max(maxNum, dp[tempIndex]);
            }

            if (secondVal <= n) {
                int tempIndex = runningIndex++;
                dp[tempIndex] = dp[index] + dp[index+1];
                maxNum = Math.max(maxNum, dp[tempIndex]);
            }
            index++;
        }
        return maxNum;
    }
}
