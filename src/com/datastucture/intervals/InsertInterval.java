package com.datastucture.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        //insertInterval.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        //insertInterval.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        insertInterval.insert(new int[][]{{1, 5}, {6, 8}}, new int[]{3, 7});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        //Find first start interval
        Integer startIntervalIndex = null;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[0]) {
                startIntervalIndex = i;
                break;
            }
        }

        //Find second interval for overlap
        Integer endIntervalIndex = null;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= newInterval[1] || intervals[i][1] >= newInterval[1]) {
                endIntervalIndex = i;
                break;
            }
        }

        List<int[]> newIntervalWindows = new ArrayList<>();

        if (startIntervalIndex != null && endIntervalIndex != null) {
            if (newInterval[0] <= intervals[startIntervalIndex][1] && newInterval[1] >= intervals[endIntervalIndex][0]) {
                int[] tempInterval = {Math.min(newInterval[0], intervals[startIntervalIndex][0]), Math.max(newInterval[1], intervals[endIntervalIndex][1])};
                newIntervalWindows.add(tempInterval);
            } else if (newInterval[0] <= intervals[startIntervalIndex][1] && newInterval[1] < intervals[endIntervalIndex][0]) {
                int[] tempIntervalCombiningStartInterval = {Math.min(newInterval[0], intervals[startIntervalIndex][0]), newInterval[1]};
                newIntervalWindows.add(tempIntervalCombiningStartInterval);
                newIntervalWindows.add(new int[]{intervals[endIntervalIndex][0], intervals[endIntervalIndex][1]});
            } else if (newInterval[0] > intervals[startIntervalIndex][1] && newInterval[1] <= intervals[endIntervalIndex][1]) {
                int[] tempInterval = {newInterval[0], intervals[endIntervalIndex][1]};
                newIntervalWindows.add(tempInterval);
            }
        }
        else if (endIntervalIndex == null && startIntervalIndex != null) {

            if (!(newInterval[0] >= intervals[startIntervalIndex][0] && newInterval[1] <= intervals[startIntervalIndex][1])) {
                int[] tempInterval = {Math.min(newInterval[0], intervals[startIntervalIndex][0]), Math.max(newInterval[1], intervals[startIntervalIndex][1])};
                newIntervalWindows.add(tempInterval);
            }
        }
        else if (endIntervalIndex != null) {
            if (!(newInterval[0] >= intervals[endIntervalIndex][0] && newInterval[1] <= intervals[endIntervalIndex][1])) {
                int[] tempInterval = {Math.min(newInterval[0], intervals[endIntervalIndex][0]), Math.max(newInterval[1], intervals[endIntervalIndex][1])};
                newIntervalWindows.add(tempInterval);
            }
        } else {
            newIntervalWindows.add(newInterval);
        }

        if (newIntervalWindows.isEmpty()) {
            return intervals;
        }

        List<int[]> resultList = new ArrayList<>();

        if (startIntervalIndex == null && endIntervalIndex == null) {
            resultList.addAll(Arrays.asList(intervals));
            resultList.add(newInterval);
        } else {
            for (int i = 0; i < intervals.length; i++) {

                if (startIntervalIndex != null && i < startIntervalIndex) {
                    resultList.add(intervals[i]);
                }

                if (startIntervalIndex != null && i == startIntervalIndex) {

                    resultList.addAll(newIntervalWindows);
                }

                if (endIntervalIndex != null && i > endIntervalIndex) {
                    resultList.add(intervals[i]);
                }
            }
        }

        int[][] resultArray = new int[resultList.size()][2];
        return resultList.toArray(resultArray);
    }
}
