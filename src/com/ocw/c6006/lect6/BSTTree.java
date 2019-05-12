package com.ocw.c6006.lect6;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class BSTTree {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Introduction: BSTTree Operations
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //TreeNode represents the core strcuture of every binary tree
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        TreeNode(int value) {
            this.value = value;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Tree representation has only root node
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    TreeNode root;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //All methods or operations of the tree that were discussed in the lecture and more
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //Height of the tree (root of tree)
    int height() {
        return height(root);
    }

    //Height of a node is the max height of its children + 1
    int height(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    //find element/node in the tree
    TreeNode find(int value) {
        return find(root, value);
    }

    //find element/node under a specific node in the tree
    TreeNode find(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (value == node.value)
            return node;
        else if (value < node.value)
            return find(node.left, value);
        else
            return find(node.right, value);
    }

    //get the min value in the tree, all the way down to the left of the tree
    TreeNode min() {
        if (root == null) {
            return null;
        }
        TreeNode result = root;
        while (result.left != null) {
            result = result.left;
        }
        return result;
    }

    //get the max value in the tree, all the way down to the right side of the tree
    TreeNode max() {
        if (root == null) {
            return null;
        }
        TreeNode result = root;
        while (result.right != null) {
            result = result.right;
        }
        return result;
    }

    //insert value in the tree
    void insert(int value) throws Exception {
        if (root == null) {
            root = new TreeNode(value);
           return;
        }


        insert(root, value);
    }

    //insert value under a specific node in the tree
    void insert(TreeNode node, int value) throws Exception {
        if (node == null)
            throw new Exception("Node is empty");

        if (value <= node.value) {
            if (node.left == null)
                node.left = new TreeNode(value);
            else
                insert(node.left, value);
        } else {
            if (node.right == null)
                node.right = new TreeNode(value);
            else
                insert(node.right, value);
        }
    }

    //inorder traversal, used to print the tree in a sorted way
    String inorder() {
        return inorder(root);
    }

    //print binary tree in order (sorted)
    String inorder(TreeNode node) {

        String result = "";
        //visit left
        if (node.left != null)
           result =  inorder(node.left);
        //node
        System.out.println(node.value);
        result += node.value;

        //visit right
        if (node.right != null)
            result += inorder(node.right);

        return result;
    }


    //topics coming in future depth first search
    void dfs() {
        //stack
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {


            TreeNode node = stack.pop();

            System.out.println(node.value);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
    }

    //topics coming in future breadth first search
    void bfs() {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //visit node
            TreeNode node = queue.pollFirst();
            System.out.println(node.value);

            if (node.left != null)
                queue.addLast(node.left);
            if (node.right != null)
                queue.addLast(node.right);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Unit Test Cases
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void TestHeight() {
        BSTTree tree = new BSTTree();
        Assert.assertEquals(0, tree.height());

        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(20);
        tree.root.left.left = new TreeNode(50);
        tree.root.left.right = new TreeNode(9);
        tree.root.right = new TreeNode(23);
        tree.root.right.right = new TreeNode(99);

        Assert.assertEquals(2, tree.height());
        Assert.assertEquals(1, tree.height(tree.root.left));
        Assert.assertEquals(0, tree.height(tree.root.left.left));
        Assert.assertEquals(0, tree.height(tree.root.right.right));

    }

    @Test
    public void TestFind() {
        BSTTree tree = new BSTTree();
        Assert.assertNull(tree.find(10));
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(7);
        Assert.assertNotNull(tree.find(7));

    }


    @Test
    public void TestMin() {
        BSTTree tree = new BSTTree();
        Assert.assertNull(tree.min());
        tree.root = new TreeNode(10);
        Assert.assertNotNull(tree.min());
        Assert.assertEquals(10, tree.min().value);
        tree.root.left = new TreeNode(5);
        Assert.assertEquals(5, tree.min().value);


    }

    @Test
    public void TestMax() {
        BSTTree tree = new BSTTree();
        Assert.assertNull(tree.max());
        tree.root = new TreeNode(10);
        Assert.assertNotNull(tree.max());
        Assert.assertEquals(10, tree.max().value);
        tree.root.right = new TreeNode(20);
        tree.root.left = new TreeNode(15);

        Assert.assertEquals(20, tree.max().value);

    }

    @Test
    public void TestInsert() throws Exception{
        BSTTree tree = new BSTTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        Assert.assertEquals(5, tree.min().value);
        Assert.assertEquals(15, tree.max().value);
        Assert.assertEquals("51015",tree.inorder());
    }

    @Test
    public void TestInOrder() throws Exception{
        BSTTree tree = new BSTTree();
        tree.insert(19);
        tree.insert(10);
        tree.insert(15);

        Assert.assertEquals("101519",tree.inorder());
    }

}
