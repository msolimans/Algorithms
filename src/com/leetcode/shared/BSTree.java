package com.leetcode.shared;


import java.util.LinkedList;

public class BSTree {
    //Implementation of BST [Not part of solution, used for simplifying and writing test cases only]
    public TreeNode root = null;

    public BSTree(int i) {
        root = new TreeNode(i);
    }

    public BSTree(int[] is) {
        if (is.length == 0)
            root = null;
        else {
            root = new TreeNode(is[0]);
            for (int i = 1; i < is.length; i++) {
                insert(is[i]);
            }
        }
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

    @Override
    public String toString() {
        java.util.Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            builder.append(t.val);

            if (t.left != null)
                queue.add(t.left);
            if (t.right != null)
                queue.add(t.right);
        }

        return builder.toString();
    }
}
