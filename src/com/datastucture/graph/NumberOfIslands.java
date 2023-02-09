package com.datastucture.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        List<Integer> list = new ArrayList<>();
        numberOfIslands.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}});
    }

    public int numIslands(char[][] grid) {

        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands += dfs(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    private int dfs(char[][] grid, int rowIndex, int colIndex) {

        if (rowIndex < grid.length && rowIndex >= 0 && colIndex >= 0 && colIndex < grid[rowIndex].length && grid[rowIndex][colIndex] == '1') {

            grid[rowIndex][colIndex] = '0';

            dfs(grid, rowIndex - 1, colIndex);
            dfs(grid, rowIndex + 1, colIndex);
            dfs(grid, rowIndex, colIndex - 1);
            dfs(grid, rowIndex, colIndex + 1);

            Integer[] arr = new Integer[1];
            Set<Integer> hashSEt = new HashSet<>();
            hashSEt.toArray(arr);

            return 1;
        }
        return 0;
    }
}
