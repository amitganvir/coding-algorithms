package com.datastucture.tree;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    @Setter
    TreeNode left;
    @Setter
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
