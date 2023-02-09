package com.datastucture.tree;

public class SortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        new SortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5});
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        int midpoint = (nums.length - 1) / 2 + 1;

        TreeNode head = new TreeNode(nums[midpoint]);

        TreeNode currentLeftNode = null;

        for (int i = midpoint - 1; i >= 0; i--) {

            if (currentLeftNode == null) {
                head.left = new TreeNode(nums[i]);
                currentLeftNode = head.left;
            } else {
                currentLeftNode.left = new TreeNode(nums[i]);
            }
        }

        TreeNode currentRightNode = null;
        for (int i = midpoint + 1; i < nums.length; i++) {

            if (currentRightNode == null) {
                head.right = new TreeNode(nums[i]);
                currentRightNode = head.right;
            } else {
                currentRightNode.right = new TreeNode(nums[i]);
            }
        }

        return head;
    }
}
