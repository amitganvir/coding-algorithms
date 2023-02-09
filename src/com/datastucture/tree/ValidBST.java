package com.datastucture.tree;

public class ValidBST {

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(5);
        rootNode.left = new TreeNode(4);
        rootNode.right = new TreeNode(6);
        rootNode.right.left = new TreeNode(3);
        rootNode.right.right = new TreeNode(7);

        ValidBST validBST = new ValidBST();

        System.out.println(validBST.isValidBST(rootNode));
    }

    public boolean isValidBST(TreeNode root) {

        if (root.left != null && root.left.val >= root.val) return false;
        if (root.right != null && root.right.val <= root.val) return false;

        return bstValidator(root.left, null, root.val) && bstValidator(root.right, root.val, null);
    }

    private boolean bstValidator(TreeNode root, Integer lowerLimit, Integer upperLimit) {
        if (root == null) {
            return true;
        }

        if (lowerLimit != null) {
            if (root.val <= lowerLimit) return false;
        }

        if (upperLimit != null) {
            if (root.val >= upperLimit) return false;
        }

        return bstValidator(root.left, lowerLimit, root.val) && bstValidator(root.right, root.val, upperLimit);
    }
}
