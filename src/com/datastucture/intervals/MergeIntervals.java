package com.datastucture.intervals;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

    public int[][] merge(int[][] intervals) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(ints -> ints[0]));

        priorityQueue.addAll(Arrays.asList(intervals));

        List<int[]> resultList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {

            int[] queueItem = priorityQueue.poll();

            if (resultList.isEmpty()) {
                resultList.add(queueItem);
                continue;
            }

            int[] previousItem = resultList.get(resultList.size() - 1);

            if (previousItem[1] >= queueItem[0]) {
                previousItem[1]  = Math.max(previousItem[1], queueItem[1]);
            } else {
                resultList.add(queueItem);
            }
        }

        int[][] resultArray = new int[resultList.size()][2];

        return resultList.toArray(resultArray);
    }
}
