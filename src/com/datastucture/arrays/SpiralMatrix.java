package com.datastucture.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        //System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        //System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1},{2}}));
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        List<Integer> resultList = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        boolean listUpdated = false;
        do {
            listUpdated = false;
            //process row right
            int tempColStart = colStart;
            int tempColEnd = colEnd;
            while (tempColStart <= tempColEnd) {
                resultList.add(matrix[rowStart][tempColStart++]);
                listUpdated = true;
            }
            rowStart++;

            //process col down
            int tempRowStart = rowStart;
            int tempRowEnd = rowEnd;
            while (tempRowStart <= tempRowEnd) {
                resultList.add(matrix[tempRowStart++][colEnd]);
                listUpdated = true;
            }
            colEnd--;

            //process row left
            tempColStart = colStart;
            tempColEnd = colEnd;
            while (tempColEnd >= tempColStart) {
                resultList.add(matrix[rowEnd][tempColEnd--]);
                listUpdated = true;
            }
            rowEnd--;

            //process row up
            tempRowStart = rowStart;
            tempRowEnd = rowEnd;
            while (tempRowEnd >= tempRowStart) {
                resultList.add(matrix[tempRowEnd--][colStart]);
                listUpdated = true;
            }
            colStart++;

        } while (listUpdated);

        return resultList;

    }
}
