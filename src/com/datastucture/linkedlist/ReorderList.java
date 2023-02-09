package com.datastucture.linkedlist;

public class ReorderList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        new ReorderList().reorderList(head);
    }

    public void reorderList(ListNode head) {

        ListNode midPointNode = getMidpoint(head);
        ListNode lastNode = reverseList(midPointNode);

        ListNode startNode = head;
        ListNode endNode = lastNode;

        while (startNode.next != null && endNode.next != null) {
            ListNode currentNextNode = startNode.next;
            ListNode currentEndNodeNext = endNode.next;

            startNode.next = endNode;
            endNode.next = currentNextNode;
            startNode = currentNextNode;
            endNode = currentEndNodeNext;
        }
    }

    private ListNode reverseList(final ListNode node) {

        ListNode currentNode = node;
        ListNode previousNode = null;

        while (currentNode != null) {
            if (previousNode == null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                previousNode.next = null;
                continue;
            }

            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

    private ListNode getMidpoint(final ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
