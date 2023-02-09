package com.datastucture.tree;

import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.*;

public class LowestCommandAncestor {

    /**
     *  Do Eulerian Tour
     *  Create Depth Array for the pass
     *  Create a node array for the pass
     *
     *  Find last occurring for node A and node B in nodes array
     *  Find the index of min depth between index of Node A and Node B in the depth array
     *  The lowest common ancestor is the element at minDepthIndex of nodes array
     *
     */

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(5);
        rootNode.left.left = new TreeNode(6);
        rootNode.left.right = new TreeNode(2);
        rootNode.left.right.left = new TreeNode(7);
        rootNode.left.right.right = new TreeNode(4);
        rootNode.right = new TreeNode(1);
        rootNode.right.left = new TreeNode(0);
        rootNode.right.right = new TreeNode(8);

        LowestCommandAncestor lowestCommandAncestor = new LowestCommandAncestor();
        TreeNode treeNode = lowestCommandAncestor.lowestCommandAncestor(rootNode, new TreeNode(0), new TreeNode(8));

        System.out.println(treeNode);
    }

    private TreeNode lowestCommandAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<TreeNode> nodesList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        Map<Integer, Integer> nodeToIndexMap = new HashMap<>();
        int currentIndex = 0;
        int currentLevel = 0;
        while (!stack.isEmpty()) {
            TreeNode peekNode = stack.peek();
            nodesList.add(peekNode);
            nodeToIndexMap.put(peekNode.val, currentIndex++);
            levelList.add(currentLevel);

            if (peekNode.left != null) {

                if (!visited.contains(peekNode.left.val)){
                    currentLevel++;
                    stack.push(peekNode.left);
                    continue;
                }
            }

            if (peekNode.right != null) {
                if (!visited.contains(peekNode.right.val)) {
                    currentLevel++;
                    stack.push(peekNode.right);
                    continue;
                }
            }

            visited.add(peekNode.val);
            stack.pop();
            currentLevel--;
        }

        int minIndex = Math.min(nodeToIndexMap.get(p.val), nodeToIndexMap.get(q.val));
        int maxIndex = Math.max(nodeToIndexMap.get(p.val), nodeToIndexMap.get(q.val));

        int smallestVal = levelList.get(minIndex);
        int resultIndex = minIndex;
        for (int i = minIndex; i <= maxIndex; i++) {
            if (levelList.get(i) < smallestVal) {
                smallestVal = levelList.get(i);
                resultIndex = i;
            }
        }

        return nodesList.get(resultIndex);
    }


}
