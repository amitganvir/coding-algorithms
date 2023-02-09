package com.datastucture.heap;

import java.util.*;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        kClosestPointsToOrigin.kClosest(new int[][]{{3,3}, {5, -1}, {-2, 4}}, 2);
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Distance> queue = new PriorityQueue<>(Comparator.comparing(Distance::getDistance));


        List<Integer> list = new ArrayList<>();
        list.sort(Comparator.comparing(Integer::intValue));
        return result;
    }

    public static class Distance {
        int x;
        int y;
        double distance;

        public Distance(int x, int y) {
            this.x = x;
            this.y = y;
            distance = Math.sqrt((x*x) + (y*y));
        }

        public double getDistance() {
            return this.distance;
        }
    }
}
