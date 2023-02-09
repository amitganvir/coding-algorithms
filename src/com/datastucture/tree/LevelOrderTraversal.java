package com.datastucture.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(5);
        rootNode.right = new TreeNode(3);
        rootNode.right.left = new TreeNode(6);
        rootNode.right.right = new TreeNode(7);
        rootNode.left.left.left = new TreeNode(8);
        rootNode.left.left.right = new TreeNode(9);
        rootNode.left.right.left = new TreeNode(10);
        rootNode.left.right.right = new TreeNode(11);
        rootNode.right.left.left = new TreeNode(12);
        rootNode.right.left.right = new TreeNode(13);
        rootNode.right.right.left = new TreeNode(14);
        rootNode.right.right.right = new TreeNode(15);

        levelOrderTraversal.levelOrder(rootNode);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        } else if (root.left == null && root.right == null) {
            return List.of(List.of(root.val));
        }

        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        resultList.add(List.of(root.val));

        int numberOfItemsToPoll = 1;
        while (!queue.isEmpty()) {

            int itemsAddedToQueueAtLevel = 0;
            List<Integer> listAtLevel = new ArrayList<>();
            while (numberOfItemsToPoll > 0) {
                TreeNode node = queue.poll();
                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;
                if (leftNode != null) {
                    queue.add(leftNode);
                    listAtLevel.add(leftNode.val);
                    itemsAddedToQueueAtLevel++;
                }
                if (rightNode != null) {
                    queue.add(rightNode);
                    listAtLevel.add(rightNode.val);
                    itemsAddedToQueueAtLevel++;
                }
                numberOfItemsToPoll--;
            }
            numberOfItemsToPoll = itemsAddedToQueueAtLevel;

            if (!listAtLevel.isEmpty())
                resultList.add(listAtLevel);
        }

        return resultList;
    }
}
