package com.datastucture.lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int size;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;

    public static void main(String[] args) {

    }

    public static class Node {
        Node prev;
        Node next;
        int value;
    }
}
