package com.leetcode;

//e_110_BalancedBinaryTree 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as:
//
//a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//
//
//
//Example 1:
//
//Given the following tree [3,9,20,null,null,15,7]:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Return true.
//
//Example 2:
//
//Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//Return false.
//******************************************************************************************************************
//Companies: Microsoft, SquareSpace
//******************************************************************************************************************
//Link: https://leetcode.com/problems/balanced-binary-tree/
//******************************************************************************************************************

public class e_110_BalancedBinaryTree {


    public static void main(String[] args) {


    }

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;


        Pair<Integer, Boolean> res = balanced(root);
        return res.getValue();
    }


    public Pair<Integer, Boolean> balanced(TreeNode root) {

        //base case, stopping condition
        if (root == null)
            return new Pair<>(0, true);

        //go all the way to left, visit left
        Pair<Integer, Boolean> left = balanced(root.left);
        //if it is not okay, don't go further down
        if (!left.getValue())
            return new Pair<>(0, false);
        //check right leaves
        Pair<Integer, Boolean> right = balanced(root.right);

        if (!right.getValue())
            return new Pair<>(0, false);

        //here if there is a difference between left and right is greater than or equal to 2, return false
        if (Math.abs(left.getKey() - right.getKey()) >= 2)
            return new Pair<>(0, false);

        //otherwise return current height of node which is the => max height of [left or right] + 1
        return new Pair<>(Math.max(left.getKey(), right.getKey()) + 1, true);
    }


    @Test
    public void TestIsBalanced() {
        Assert.assertTrue(isBalanced(new BSTree(new int[]{5, 3, 6}).root));
        Assert.assertFalse(isBalanced(new BSTree(new int[]{5, 3, 2, 1}).root));
    }


    public boolean isBalanced2(TreeNode root) {

        if (root == null)
            return true;

        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                isBalanced2(root.left) && isBalanced2(root.right);

    }

    int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }


    @Test
    public void TestIsBalanced2() {
        Assert.assertTrue(isBalanced2(new BSTree(new int[]{5, 3, 6}).root));
        Assert.assertFalse(isBalanced2(new BSTree(new int[]{5, 3, 2, 1}).root));
    }


}
