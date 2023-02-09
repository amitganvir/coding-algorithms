package com.datastucture.linkedlist;

import java.util.*;

public class SortedLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);

        SortedLinkedList sortedLinkedList = new SortedLinkedList();
        //ListNode listNode = sortedLinkedList.sortList(head);
        sortedLinkedList.sortWithHashMap(head);
        System.out.println();
    }

    public ListNode sortWithHashMap(ListNode head) {
        TreeMap<Integer, ListNode> treeMap = new TreeMap<>();
        Map<Integer, Integer> countMap = new TreeMap<>();

        ListNode traversingNode = head;

        while (traversingNode != null) {
            countMap.put(traversingNode.val, countMap.getOrDefault(traversingNode.val, 0) + 1);
            treeMap.put(traversingNode.val, traversingNode);
            traversingNode = traversingNode.next;
        }

        ListNode emptyNode = new ListNode();

        Set<Map.Entry<Integer, ListNode>> entries = treeMap.entrySet();

        ListNode node = emptyNode;
        for (Map.Entry<Integer, ListNode> entry: entries) {
            ListNode listNode = entry.getValue();
            listNode.next = null;
            node.next = listNode;
            node = listNode;
        }

        return emptyNode.next;

    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null ) {
            return head;
        }

        ListNode midPoint = midPoint(head);
        ListNode sortedLeftList = sortList(head);
        ListNode sortedRightList = sortList(midPoint);

        return mergeLists(sortedLeftList, sortedRightList);
    }

    private ListNode mergeLists(ListNode leftListNode, ListNode rightListNode) {

        if (leftListNode == null && rightListNode != null) {
            return rightListNode;
        } else if (leftListNode != null && rightListNode == null) {
            return leftListNode;
        }

        ListNode emptyNode = new ListNode(-1);

        ListNode previousNode = emptyNode;
        ListNode leftNode = leftListNode;
        ListNode rightNode = rightListNode;

        while (leftNode != null && rightNode != null) {

            if (leftNode.val < rightNode.val) {
                previousNode.next = leftNode;
                leftNode = leftNode.next;
            } else {
                previousNode.next = rightNode;
                rightNode = rightNode.next;
            }
            previousNode = previousNode.next;
        }

        if (leftNode != null) {
            previousNode.next = leftNode;
        }

        if (rightNode != null) {
            previousNode.next = rightNode;
        }

        return emptyNode.next;
    }

    private ListNode midPoint(ListNode node) {
        ListNode slowNode = node;
        ListNode slowPrevious = null;
        ListNode fastNode = node;

        while (slowNode != null && fastNode != null && fastNode.next != null) {
            slowPrevious = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }



        slowPrevious.next = null;
        return slowNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }
}
