package com.datastucture.tree;

import com.sun.source.tree.Tree;

import java.util.Objects;
import java.util.Stack;

import static java.util.Objects.isNull;

public class MinPathSum {

    public static void main(String[] args) {

        TreeNode rootNode = TreeNode.builder().val(10).build();
        rootNode.setLeft(TreeNode.builder().val(5).right(TreeNode.builder().val(2).build()).build());
        rootNode.setRight(TreeNode.builder().val(5).right(TreeNode.builder().val(1).left(TreeNode.builder().val(-1).build()).build()).build());

        System.out.println("Minimum Sum Path " + minPathSum(rootNode, 0));

    }

    private static int minPathSum(TreeNode node, int currentSum) {

        if (isNull(node)) {
            return currentSum;
        }

        return Math.min(minPathSum(node.left, node.val + currentSum),
                minPathSum(node.right, node.val + currentSum));
    }
}
