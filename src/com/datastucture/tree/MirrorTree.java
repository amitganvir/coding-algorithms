package com.datastucture.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    public static void main(String[] args) {


        MirrorTree mirrorTree = new MirrorTree();



        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        StringBuilder leftBuffer = new StringBuilder();
        StringBuilder rightBuffer = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        leftBuffer.append(root.val);
        queue.add(root.left);
        mirrorTree.traverseLeftTree(leftBuffer, queue);

        rightBuffer.append(root.val);
        queue.add(root.right);
        mirrorTree.traverseRightTree(rightBuffer, queue);

        System.out.println(leftBuffer);
        System.out.println(rightBuffer);

        System.out.println(leftBuffer.equals(rightBuffer));
    }

    private void traverseLeftTree(StringBuilder stringBuffer, Queue<TreeNode> queue) {

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode leftNode = node != null ? node.left : null;
            TreeNode rightNode = node != null ? node.right : null;

            stringBuffer.append(node == null ? "null" : node.val);

            if (node != null) {
                queue.add(leftNode);
                queue.add(rightNode);
            }

        }
    }

    private void traverseRightTree(StringBuilder stringBuffer, Queue<TreeNode> queue) {

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode leftNode = node != null ? node.left : null;
            TreeNode rightNode = node != null ? node.right : null;

            stringBuffer.append(node == null ? "null" : node.val);
            if (node != null) {
                queue.add(rightNode);
                queue.add(leftNode);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
