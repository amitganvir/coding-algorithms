package com.datastucture.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary search tree and a range [a, b] (inclusive), return the sum of the elements of the binary search tree within the range.
 *
 *      5
 *    / \
 *   3   8
 *  / \ / \
 * 2  4 6  10
 *
 * and the range [4, 9], return 23 (5 + 4 + 6 + 8).
 */
public class InRangeSum {

    public static void main(String args[]) {
        InRangeSum inRangeSum = new InRangeSum();

    }

    public int rangeSumBST(TreeNode  root, int low, int high) {
        int result = 0;

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        if (root.left != null) stack.add(root.left);
        if (root.right != null) stack.add(root.right);

        while (!stack.isEmpty()) {

            TreeNode currentNode = stack.pop();

            if (currentNode.val >= low && currentNode.val <= high) {
                result += currentNode.val;
            }

            if (currentNode.left != null) stack.push(currentNode.left);
            if (currentNode.right != null) stack.push(currentNode.right);

        }


        return result;
    }

    public int rangeSumBSTV2(TreeNode  root, int low, int high) {
        if (root == null) return 0;
        return sum(root, low, high, 0);
    }

    private int sum(TreeNode node, int low, int high, int currentSum) {

        int result = currentSum;
        if (node.left != null) {
            result += sum(node.left, low, high, 0);
        }

        if (node.right != null) {
            result += sum(node.right, low, high, 0);
        }

        if (node.val <= high && node.val >= low) {
            result += node.val;
        }

        return result;
    }

}
