package com.datastucture;

public class CoinStack {

    public static void main(String[] args) {
        new CoinStack().solution(new int[]{2,0,0,0,10});
    }

    public int solution(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return A[0];
        }

        boolean swapped = false;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 2) {
                swapped = true;
                break;
            }
        }


        while (swapped) {
            swapped = false;
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= 2) {
                    if (i - 1 < 0 && i + 1 < A.length) {
                        A[i + 1] += 1;
                        swapped = true;

                    } else if (i - 1 >= 0 && i + 1 >= A.length) {
                        A[i - 1] += 1;
                        swapped = true;

                    } else {
                        if (A[i - 1] > A[i + 1]) {
                            if (A[i] < A[i-1]) {
                                A[i - 1] += 1;
                                swapped = true;

                            }
                        } else {
                            if (A[i] < A[i+1]){
                                A[i + 1] += 1;
                                swapped = true;

                            }
                        }
                    }

                    if (swapped) {
                        A[i] -= 2;
                        break;
                    }
                }
            }
        }
        swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = A.length - 1; i >= 0; i--) {
                if (A[i] >= 2) {
                    if (i - 1 < 0 && i + 1 < A.length) {
                        A[i + 1] += 1;
                        swapped = true;

                    } else if (i - 1 >= 0 && i + 1 >= A.length) {
                        A[i - 1] += 1;
                        swapped = true;

                    } else {
                        if (A[i - 1] > A[i + 1]) {
                            if (A[i] < A[i-1]) {
                                A[i - 1] += 1;
                                swapped = true;

                            }
                        } else {
                            if (A[i] < A[i+1]){
                                A[i + 1] += 1;
                                swapped = true;

                            }
                        }
                    }

                    if (swapped) {
                        A[i] -= 2;
                        break;
                    }
                }
            }
        }

        int result = A[0];
        for (int val : A) {
            result = Math.max(result, val);
        }

        System.out.println(result);
        return result;
    }
}
