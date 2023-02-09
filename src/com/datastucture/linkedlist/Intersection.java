package com.datastucture.linkedlist;

import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Intersection {

    public static void main(String[] args) {
        Collector<Integer, ?, LinkedList<Integer>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Integer> firstLinkedList = Stream.of(109, 99, 1, 8, 10).collect(toLinkedList);
        LinkedList<Integer> secondLinkedList = Stream.of(3, 7, 6, 4, 33, 55, 8, 10).collect(toLinkedList);

        System.out.println(findIntersectionPoint(firstLinkedList, secondLinkedList));
    }

    private static Integer findIntersectionPoint(LinkedList<Integer> firstList, LinkedList<Integer> secondList) {

        LinkedList<Integer> longerList = firstList.size() > secondList.size() ? firstList : secondList;
        LinkedList<Integer> shorterList = firstList.size() < secondList.size() ? firstList : secondList;

        int difference = longerList.size() - shorterList.size();

        for (int i = 0; i < shorterList.size(); i++) {

            if (longerList.get(i+difference).equals(shorterList.get(i))) {
                return shorterList.get(i);
            }
        }

        return null;
    }
}
