package com.leetcode;

//e_112_PathSum 
//Show Topic Tags

import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Given the below binary tree and sum = 22,
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/path-sum/
//******************************************************************************************************************

public class e_112_PathSum {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(new e_112_PathSum().hasPathSum(root, 1));

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return pathSum(root, root.val, sum);
    }

    boolean pathSum(TreeNode root, int sum, int target) {
        //check if we are a leaf node, if so check whether sum equals target
        if (root.left == null && root.right == null) {
            return sum == target;
        }
        boolean left = false, right = false;

        //make sure you have left subtree not being null before validating it
        if (root.left != null)
            //do we have a path that's equal to target in left subtree
            left = pathSum(root.left, sum + root.left.val, target);
        if (root.right != null)
            //do we have a path that's equal to target in right subtree
            right = pathSum(root.right, sum + root.right.val, target);

        //result should be left or right
        return left || right;
    }

    @Test
    public void TestHasPathSum() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        Assert.assertTrue(hasPathSum(root, 22));
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        Assert.assertFalse(hasPathSum(root, 1));
    }


}
