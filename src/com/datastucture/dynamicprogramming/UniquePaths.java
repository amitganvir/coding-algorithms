package com.datastucture.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.uniquePaths(23, 12);
    }

    public int uniquePaths(int m, int n) {

        if (m == 1 && n ==1 ) return 1;

        int [][] pathMatrix = new int[m][n];

        traversePaths(pathMatrix, 0, 0);
        return pathMatrix[0][0];
    }

    public int traversePaths(int[][] pathMatrix, int row, int col) {

        if (row == pathMatrix.length - 1 && col == pathMatrix[row].length - 1) return 1;

        if (row >= pathMatrix.length || col >= pathMatrix[row].length) {
            return 0;
        }

        if (pathMatrix[row][col] > 0) return pathMatrix[row][col];

        int rightPaths = traversePaths(pathMatrix, row, col+1);
        int downPaths = traversePaths(pathMatrix, row + 1, col);

        int numberOfPathsFromPosition = rightPaths + downPaths;
        pathMatrix[row][col] = numberOfPathsFromPosition;

        return numberOfPathsFromPosition;
    }
}
