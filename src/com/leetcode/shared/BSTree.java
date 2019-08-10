package com.leetcode.shared;

public class BSTree {
    //Implementation of BST [Not part of solution, used for simplifying and writing test cases only]
    public TreeNode root = null;

    public BSTree(int i) {
        root = new TreeNode(i);
    }

    public BSTree() {
        root = null;
    }

    public void insert(int[] elems) {
        for (int i : elems) {
            insert(i);
        }
    }

    public void insert(int i) {
        if (root == null) {
            root = new TreeNode(i);
            return;
        }

        insert(root, i);
    }

    public void insert(TreeNode node, int i) {
        if (i < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(i);
            } else {
                insert(node.left, i);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(i);
            } else {
                insert(node.right, i);

            }
        }
    }

}
