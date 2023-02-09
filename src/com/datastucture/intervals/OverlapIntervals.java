package com.datastucture.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OverlapIntervals {

    public static void main(String[] args) {
        OverlapIntervals overlapIntervals = new OverlapIntervals();
//        overlapIntervals.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
//        overlapIntervals.eraseOverlapIntervals(new int[][]{{1,2},{1, 2},{1,2}});
//        overlapIntervals.eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}});
        overlapIntervals.eraseOverlapIntervals(new int[][] {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}});
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        int countOfIntervalsToErase = 0;
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));;

        int[] previousElement = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (previousElement[1] > intervals[i][0]) {
                countOfIntervalsToErase++;

                if (previousElement[1] > intervals[i][1]) {
                    previousElement = intervals[i];
                }
            } else {
                previousElement = intervals[i];
            }
        }

        return countOfIntervalsToErase;
    }
}
