package com.datastucture.tree;

public class SumOfRootToLeafBinaryNumbers {
    int answer = 0;
    int currentSum = 0;
    int val = 0;

    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(0);
        rootNode.left.left = new TreeNode(0);
        rootNode.left.right = new TreeNode(1);
        rootNode.right = new TreeNode(1);
        rootNode.right.left = new TreeNode(0);
        rootNode.right.right = new TreeNode(1);

        SumOfRootToLeafBinaryNumbers sumOfRootToLeafBinaryNumbers = new SumOfRootToLeafBinaryNumbers();
        sumOfRootToLeafBinaryNumbers.sumRootToLeaf(rootNode);
    }

    public int sumRootToLeaf(TreeNode root) {
        currentSum = 0 << 1 | root.val;
        visitNode(root);
        return answer;
    }

    private void visitNode(TreeNode node) {

        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;

        if (leftNode == null && rightNode == null) {
            answer += currentSum;
            return;
        }

        if (leftNode != null) {
            currentSum = currentSum << 1 | leftNode.val;
            visitNode(leftNode);
            currentSum = currentSum >> 1;
        }

        if (rightNode != null) {
            currentSum = currentSum << 1 | rightNode.val;
            visitNode(rightNode);
            currentSum = currentSum >> 1;
        }
    }
}
