package com.datastucture.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EculideanAlgorithm {

    public static void main(String[] args) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        System.out.println(recursiveGcd(a, b));
        System.out.println(iterativeGcd(a, b));
        System.out.println(binaryGcd(a, b));
    }

    private static int recursiveGcd(int a, int b) {
        return b == 0 ? a : recursiveGcd(b, a % b);
    }

    private static int iterativeGcd(int a, int b) {
        while (b != 0) {
            final int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private static int binaryGcdV2(int a, int b) {
        if (a < b) {
            int tempSwap = a;
            a = b;
            b = tempSwap;
        }

        if (b == 0) {
            return a;
        }
        int commonMultipleOf2 = 1;
        while ((a & 1) == 0 && (b & 1) == 0) {
            commonMultipleOf2 = commonMultipleOf2 << 1;
            a = a >> 1;
            b = b >> 1;
        }
        while ((a & 1) == 0) {
            a = a >> 1;
        }
        while ((b & 1) == 0) {
            b = b >> 1;
        }
        while (b != 0) {
            int temp = a - b;
            a = b;
            b = temp;
            while ((b & 1) == 0 && b > 0) {
                b = b >> 1;
            }
            if (a < b) {
                int tempSwap = a;
                a = b;
                b = tempSwap;
            }
        }
        return a * commonMultipleOf2;
        //Knuth 20% saving in processing power
    }

    private static int binaryGcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (b == 0) {
            return a;
        }

        int commonMultipleOfTwo = 1;

        //while a and b are multiples of two

        while (((a & 1) == 0) && (b & 1) == 0) {
            commonMultipleOfTwo = commonMultipleOfTwo << 1; // Left shift multiples by 2

            //Right shift divides by 2
            a = a >> 1;
            b = b >> 1;
        }

        //Divide a by 2 till it becomes non-even
        while ((a & 1) == 0) {
            a = a >> 1;
        }

        //Divide b by 2 till it becomes non-even
        while ((b & 1) == 0) {
            b = b >> 1;
        }

        // till b becomes 0
        while (b != 0) {

            //switch variables if a < b (we want a to remain non-zero as its being returned at the end)
            if (a < b) {
                int tempS = b;
                b = a;
                a = tempS;
            }

            int temp = a - b;
            a = b;
            b = temp;

            while ((b & 1) == 0 && b > 0) {
                b = b >> 1;
            }
        }

        return a * commonMultipleOfTwo;
    }
}
