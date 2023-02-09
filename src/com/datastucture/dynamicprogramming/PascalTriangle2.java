package com.datastucture.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {

    public static void main(String[] args) {
        PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
        System.out.println(pascalTriangle2.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        Integer[] backupArray = new Integer[rowIndex + 1];
        Integer[] resultArray = new Integer[rowIndex + 1];
        Arrays.fill(resultArray, 1);
        Arrays.fill(backupArray, 1);

        for (int i = 2; i <= rowIndex; i++) {

            int indexesToUpdate = i - 1;
            int j = 1;
            for (; j <= indexesToUpdate; j++) {
                resultArray[j] = backupArray[j] + backupArray[j-1];
                backupArray[j-1] = resultArray[j-1];
            }
            backupArray[j - 1] = resultArray[j-1];
        }

        return Arrays.asList(resultArray);
    }
}
