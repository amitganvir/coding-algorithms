package com.datastucture.graph;

import java.util.ArrayList;
import java.util.List;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland numberOfIslands = new MaxAreaOfIsland();
        List<Integer> list = new ArrayList<>();
        numberOfIslands.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        });
    }

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int rowIndex, int colIndex) {

        if (rowIndex < grid.length && rowIndex >= 0 && colIndex >= 0 && colIndex < grid[rowIndex].length && grid[rowIndex][colIndex] == 1) {

            grid[rowIndex][colIndex] = 0;

            int firstCount = dfs(grid, rowIndex - 1, colIndex);
            int secondCount = dfs(grid, rowIndex + 1, colIndex);
            int thirdCount = dfs(grid, rowIndex, colIndex - 1);
            int fourthCount = dfs(grid, rowIndex, colIndex + 1);

            return 1 + firstCount + secondCount + thirdCount + fourthCount;
        }
        return 0;
    }
}
