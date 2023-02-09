package com.datastucture.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        IncreasingOrderSearchTree increasingOrderSearchTree = new IncreasingOrderSearchTree();
        TreeNode rootNode = new TreeNode(5);
        rootNode.left = new TreeNode(3);
        rootNode.right = new TreeNode(6);
        rootNode.left.left = new TreeNode(2);
        rootNode.left.left.left = new TreeNode(1);
        rootNode.left.right = new TreeNode(4);
        rootNode.right.right = new TreeNode(8);
        rootNode.right.right.left = new TreeNode(7);
        rootNode.right.right.right = new TreeNode(9);

        increasingOrderSearchTree.increasingBST(rootNode);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode resultNode = null;
        TreeNode currentNode = resultNode;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.peek();

            if (node.left == null && node.right == null) {
                if (resultNode == null) {
                    resultNode = stack.pop();
                    currentNode = resultNode;
                } else {
                    TreeNode queueNode = stack.pop();
                    currentNode.right = queueNode;
                    currentNode = currentNode.right;
                }
                continue;
            }

            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            } else if (node.right != null) {
                TreeNode executingNode = stack.pop();
                stack.push(node.right);
                node.right = null;
                stack.push(executingNode);
            }
        }

        return resultNode;
    }
}
