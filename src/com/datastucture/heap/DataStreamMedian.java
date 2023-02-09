package com.datastucture.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DataStreamMedian {

    private PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        DataStreamMedian dataStreamMedian = new DataStreamMedian();
        dataStreamMedian.addNum(1);
        dataStreamMedian.addNum(2);
        System.out.println(dataStreamMedian.findMedian());
        dataStreamMedian.addNum(3);
        System.out.println(dataStreamMedian.findMedian());
        dataStreamMedian.addNum(4);
        System.out.println(dataStreamMedian.findMedian());
    }

    public void addNum(int num) {

        if (minPriorityQueue.size() == 0) {
            minPriorityQueue.add(num);
        } else {
            if (maxPriorityQueue.size() > 0 && num > maxPriorityQueue.peek()) {
                maxPriorityQueue.add(num);
            } else {
                minPriorityQueue.add(num);
            }
        }

        if (minPriorityQueue.size() - maxPriorityQueue.size() > 1) {
            maxPriorityQueue.add(minPriorityQueue.poll());
        }  else if (maxPriorityQueue.size() - minPriorityQueue.size() > 1) {
            minPriorityQueue.add(maxPriorityQueue.poll());
        }
    }

    public double findMedian() {
        int numOfElements = minPriorityQueue.size() + maxPriorityQueue.size();
        if (numOfElements > 0) {
            if (numOfElements % 2 != 0) {
                return minPriorityQueue.size() > maxPriorityQueue.size() ? minPriorityQueue.peek() : maxPriorityQueue.peek();
            } else {

                return ((minPriorityQueue.peek() + maxPriorityQueue.peek()) * 1.0) / 2;
            }
        } else {
            return 0;
        }

    }
}
