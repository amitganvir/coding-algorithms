package com.datastucture.backtracking;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {{'a'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "a"));
    }

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (bfs(board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, String word, int currentIndex, int rowIndex, int colIndex) {
        if (currentIndex >= word.length()) {
            return true;
        }
        if (rowIndex >= board.length || rowIndex < 0 || colIndex >= board[rowIndex].length || colIndex < 0) {
            return false;
        }

        char charToFind = word.charAt(currentIndex);

        boolean result = false;
        if (charToFind == board[rowIndex][colIndex]) {
            currentIndex++;

            board[rowIndex][colIndex] += 100;

            result = bfs(board, word, currentIndex, rowIndex, colIndex + 1)
                    || bfs(board, word, currentIndex, rowIndex, colIndex - 1)
                    || bfs(board, word, currentIndex, rowIndex - 1, colIndex)
                    || bfs(board, word, currentIndex, rowIndex + 1, colIndex);

            board[rowIndex][colIndex] -= 100;

        }
        return result;
    }
}
