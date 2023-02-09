package com.datastucture.backtracking;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        solveNQueens(6);
    }

    public static int solveNQueens(int n) {

        List<List<Integer>> results = new ArrayList<>();
        Map<String, Set<String>> prohibitedIndexes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(i);
            updateProhibitedIndex(prohibitedIndexes, 0, i, n, true);
            nextLevelQueenCount(n, 1, currentList, results, prohibitedIndexes);
            updateProhibitedIndex(prohibitedIndexes, 0, i, n, false);
        }

        return results.size();
    }

    private static void nextLevelQueenCount(int n, int row,
                                            List<Integer> currentPlacement,
                                            List<List<Integer>> results,
                                            Map<String, Set<String>> prohibitedIndexes) {

        if (currentPlacement.size() == n) {
            results.add(new ArrayList<>(currentPlacement));
            return;
        }

        for (int i = 0; i < n; i++) {

            String value = row + "-" + i;
            if (okToAdd(value, prohibitedIndexes)) {
                currentPlacement.add(i);

                int currentPlacementSize = currentPlacement.size();
                updateProhibitedIndex(prohibitedIndexes, row, i, n, true);
                nextLevelQueenCount(n, row + 1, currentPlacement, results, prohibitedIndexes);

                if (currentPlacementSize == currentPlacement.size() || currentPlacement.size() == n) {
                    currentPlacement.remove(currentPlacementSize - 1);
                    updateProhibitedIndex(prohibitedIndexes, row, i, n, false);
                }
            }
        }

    }

    private static boolean okToAdd(String value, Map<String, Set<String>> prohibitedIndexesMap) {

        for (Set<String> set : prohibitedIndexesMap.values()) {
            if (set.contains(value)) {
                return false;
            }
        }

        return true;
    }

    private static void updateProhibitedIndex(Map<String, Set<String>> prohibitedIndexesMap, int row, int col, int n, boolean addIndex) {

        if (!addIndex) {
            prohibitedIndexesMap.remove(row + "-" + col);
            return;
        }

        Set<String> prohibitedIndexes = new HashSet<>();
        //update columns
        int tempCol = col;
        while (tempCol < n) {
            String value = row + "-" + tempCol++;
            prohibitedIndexes.add(value);
        }

        //update rows
        int tempRow = row;
        while (tempRow < n) {
            String value = tempRow++ + "-" + col;
            prohibitedIndexes.add(value);
        }

        //update diagonal right
        int tempDiaCol = col;
        int tempDiaRow = row;
        while (tempDiaRow < n && tempDiaCol < n) {
            String value = tempDiaRow++ + "-" + tempDiaCol++;
            prohibitedIndexes.add(value);
        }

        //update diagonal left
        int tempDiaLeftCol = col;
        int tempDiaLeftRow = row;
        while (tempDiaLeftRow < n && tempDiaLeftCol >= 0) {
            String value = tempDiaLeftRow++ + "-" + tempDiaLeftCol--;
            prohibitedIndexes.add(value);
        }
        prohibitedIndexesMap.put(row + "-" + col, prohibitedIndexes);
    }


}
