package com.datastucture.linkedlist;

public class SumLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(-1);
        ListNode resultNode = listNode;
        ListNode l1Node = l1;
        ListNode l2Node = l2;

        int carryOverNumber = 0;
        while (true) {

            int l1NodeCount = 0;
            int l2NodeCount = 0;

            if (l1Node == null && l2Node == null) {
                break;
            }

            if (l1Node != null) {
                l1NodeCount = l1Node.val;
                l1Node = l1Node.next;
            }

            if (l2Node != null) {
                l2NodeCount = l2Node.val;
                l2Node = l2Node.next;
            }

            int sum = l1NodeCount + l2NodeCount;

            if (carryOverNumber > 0) {
                sum = sum + carryOverNumber;
            }

            if (sum < 10) {
                listNode.next = new ListNode(sum);
                listNode = listNode.next;
                carryOverNumber = 0;
            } else {

                int keepVal = sum % 10;
                carryOverNumber = sum / 10;
                listNode.next = new ListNode(keepVal);
            }
        }

        return resultNode.next;
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
