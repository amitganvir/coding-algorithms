package com.datastucture.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyRandomList {

    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();


        Node headNode = new Node(1);
        Node twoNode = new Node(2);
        Node threeNode = new Node(3);
        headNode.next = twoNode;
        twoNode.next = threeNode;
        headNode.random = threeNode;
        twoNode.random = headNode;

        copyRandomList.copyRandomList(headNode);
    }

    public Node copyRandomList(Node head) {
        List<Node> copiedNodeList = new ArrayList<>();
        Node tempNode = new Node(Integer.MIN_VALUE);

        Node currentNode = head;

        Node previousCopiedNode = null;
        while (currentNode != null) {

            Node copiedCurrentNode = new Node(currentNode.val);
            copiedNodeList.add(copiedCurrentNode);

            if (previousCopiedNode == null) {
                previousCopiedNode = copiedCurrentNode;
            } else {
                previousCopiedNode.next = copiedCurrentNode;
            }
            currentNode = currentNode.next;
            previousCopiedNode = copiedCurrentNode;
        }

        currentNode = head;
        Node copiedCurrentNode = copiedNodeList.get(0);
        while (currentNode != null && copiedCurrentNode != null) {

            copiedCurrentNode.random = currentNode.random != null ? copiedNodeList.get(currentNode.random.val) : null;
            currentNode = currentNode.next;
            copiedCurrentNode = copiedCurrentNode.next;
        }

        return tempNode.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
