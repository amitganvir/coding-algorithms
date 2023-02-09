package com.datastucture.arrays;

import java.util.Arrays;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] arr = new char[][]
                {

                        {'.','.','.'    ,'.','5','.'    ,'.','1','.'},
                        {'.','4','.'    ,'3','.','.'    ,'.','.','.'},
                        {'.','.','.'    ,'.','.','3'    ,'.','.','1'},

                        {'8','.','.'    ,'.','.','.'    ,'.','2','.'},
                        {'.','.','2',   '.','7','.',    '.','.','.'},
                        {'.','1','5',   '.','.','.',    '.','.','.'},

                        {'.','.','.',   '.','.','2',    '.','.','.'},
                        {'.','2','.',   '9','.','.',    '.','.','.'},
                        {'.','.','4',   '.','.','.',    '.','.','.'}

                };

        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(arr));
    }

    public boolean isValidSudoku(char[][] board) {

        int[] numArray = new int[10];
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int colIndex = 0; colIndex < board[rowIndex].length; colIndex++) {

                int currentCharacter = board[rowIndex][colIndex] - 48;

                if (currentCharacter < 0 || currentCharacter > 9) continue;
                if (numArray[currentCharacter] > 0) {
                    return false;
                }

                numArray[currentCharacter] += 1;
            }
            Arrays.fill(numArray, 0);
        }


        //validate by column
        for (int colIndex = 0; colIndex < board[0].length; colIndex++) {
            for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
                int currentCharacter = board[rowIndex][colIndex] - 48;

                if (currentCharacter < 0 || currentCharacter > 9) continue;
                if (numArray[currentCharacter] > 0) {
                    return false;
                }

                numArray[currentCharacter] += 1;
            }
            Arrays.fill(numArray, 0);
        }


        if (!validateMatrix(board, 0, 2, 0, 2, numArray)) return false;
        Arrays.fill(numArray, 0);

        if (!validateMatrix(board, 0, 2, 3, 5, numArray)) return false;
        Arrays.fill(numArray, 0);

        if (!validateMatrix(board, 0, 2, 6, 8, numArray)) return false;
        Arrays.fill(numArray, 0);

        if (!validateMatrix(board, 3, 5, 0, 2, numArray)) return false;
        Arrays.fill(numArray, 0);

        if (!validateMatrix(board, 3, 5, 3, 5, numArray)) return false;
        Arrays.fill(numArray, 0);

        if (!validateMatrix(board, 3, 5, 6, 8, numArray)) return false;
        Arrays.fill(numArray, 0);

        if (!validateMatrix(board, 6, 8, 0, 2, numArray)) return false;
        Arrays.fill(numArray, 0);

        if (!validateMatrix(board, 6, 8, 3, 5, numArray)) return false;
        Arrays.fill(numArray, 0);

        return validateMatrix(board, 6, 8, 6, 8, numArray);
    }

    private boolean validateMatrix(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd, int[] numArray) {
        for (int row = rowStart; row <= rowEnd; row++) {

            for (int col = colStart; col <= colEnd; col++) {
                int currentCharacter = board[row][col] - 48;

                if (currentCharacter < 0 || currentCharacter > 9) continue;
                if (numArray[currentCharacter] > 0) {
                    return false;
                }

                numArray[currentCharacter] += 1;
            }
        }

        return true;
    }
}
