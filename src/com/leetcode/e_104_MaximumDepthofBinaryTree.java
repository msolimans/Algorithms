package com.leetcode;

//e_104_MaximumDepthofBinaryTree 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its depth = 3.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
//******************************************************************************************************************

public class e_104_MaximumDepthofBinaryTree {


    public static void main(String[] args) {
        System.out.println(new e_104_MaximumDepthofBinaryTree().maxDepth(new BSTree(new int[]{1, 2, 3}).root));
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public int maxDepth(TreeNode root) {
        //if root is null, return 0
        if (root == null) {
            return 0;
        }

        //if left exists, go through and calc left side
        int left = 1 + maxDepth(root.left);
        //if right exists, go through and calc right side
        int right = 1 + maxDepth(root.right);

        //return the max of left and right branches
        return Math.max(left, right);
    }

    @Test
    public void TestMaxDepth() {

        Assert.assertEquals(3, maxDepth(new BSTree(new int[]{1, 2, 3}).root));
        Assert.assertEquals(2, maxDepth(new BSTree(new int[]{3, 1, 4}).root));
        Assert.assertEquals(3, maxDepth(new BSTree(new int[]{3, 1, 5, 4, 6}).root));
        Assert.assertEquals(1, maxDepth(new BSTree(new int[]{1}).root));
        Assert.assertEquals(0, maxDepth(new BSTree(new int[]{}).root));
        Assert.assertEquals(0, maxDepth(new BSTree().root));

        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(22);
        node.left.left.right = new TreeNode(90);
        Assert.assertEquals(4, maxDepth(node));

    }

}
