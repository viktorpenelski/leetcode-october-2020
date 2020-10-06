package com.github.viktorpenelski.octoberchall;

public class _6 {


    public TreeNode insertIntoBST(TreeNode root, int val) {
        var nodeToInsert = new TreeNode(val);
        if (root == null) {
            return nodeToInsert;
        }

        insertIntoBST(root, nodeToInsert);

        return root;

    }

    private void insertIntoBST(TreeNode node, TreeNode toInsert) {
        if (node.val > toInsert.val && node.left == null) {
            node.left = toInsert;
            return;
        }
        if (node.val < toInsert.val && node.right == null) {
            node.right = toInsert;
            return;
        }

        if (node.val > toInsert.val) {
            insertIntoBST(node.left, toInsert);
        } else {
            insertIntoBST(node.right, toInsert);
        }


    }


    static class TreeNode {
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
