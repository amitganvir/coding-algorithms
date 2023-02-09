package com.datastucture.fastslowpointer;

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        happyNumber.happyNumber(2);
        happyNumber.happyNumber(28);
        happyNumber.happyNumber(1);
    }

    public boolean happyNumber(int number) {
        boolean result = false;

        if (number == 1) {
            result = true;
        }

        int slow = number;
        int fast = getSquaredSum(number);

        while (fast != slow) {
            slow = getSquaredSum(slow);
            fast = getSquaredSum(getSquaredSum(fast));

            if (slow == 1 || fast == 1) {
                result = true;
                break;
            }
        }
        System.out.println(result);
        return result;
    }

    private int getSquaredSum(int number) {

        int squaredSum = 0;

        while (number > 0) {
            int remainder = number % 10;
            int quotient = number / 10;

            if (remainder == 0) {
                if (quotient == 0) break;
                number = quotient;
                continue;
            }
            squaredSum += (remainder * remainder);
            number = quotient;
        }

        return squaredSum;
    }
}
