package com.leetcode;

//m_98_ValidateBinarySearchTree 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//
//
//Example 1:
//
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
//Example 2:
//
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/validate-binary-search-tree/
//******************************************************************************************************************

public class m_98_ValidateBinarySearchTree {


    public static void main(String[] args) {
        System.out.println(new m_98_ValidateBinarySearchTree().isValidBST(new BSTree(new int[]{4, 2, 1, 3, 7, 5, 6}).root));
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

    int prev = Integer.MIN_VALUE;
    boolean first = true;


    //Auxiliary space O(1)
    //O(n)
    //we need to do inorder traversal to traverse the tree bottom-up, inorder traversal is to visit left children before the node itself and then the right children.
    //hence, inorder traversal should result in elems ordered for example a tree like the following
    //         6
    // .   4      7
    //  1    5       8
    //should result in => 1 4 5 6 7 8  [ordered]
    //so we can save everytime the current element/node's value in "prev" variable and compare it with the next one
    public boolean isValidBST(TreeNode node) {
        if (node == null)
            return true;

        //if left branch is okay, check if current node's value is greater than prev then assign prev to current value and validate right branch
        if (isValidBST(node.left)) {
            if ((prev == Integer.MIN_VALUE && first) || node.val > prev) {
                prev = node.val;
                first = false;
                return isValidBST(node.right);
            }
        }

        //if left branch was not okay, no need to check anything else, return false
        return false;
    }

    public boolean isValidBST2(TreeNode root) {
        Stack<Integer> stk = new Stack<>();
        validBST(root, stk);
        int i = Integer.MAX_VALUE;
        int temp;
        while (!stk.isEmpty()) {
            temp = stk.pop();
            if (temp >= i)
                return false;
            i = temp;
        }
        return true;
    }

    public void validBST(TreeNode node, Stack<Integer> stk) {
        if (node == null)
            return;

        validBST(node.left, stk);
        stk.push(node.val);
        validBST(node.right, stk);
    }


    @Test
    public void TestIsValidBST() {

        Assert.assertEquals(true, isValidBST(new BSTree(new int[]{2, 1, 3}).root));
        BSTree invalid = new BSTree(new int[]{5, 1});
        invalid.root.right = new TreeNode(4);
        invalid.root.right.left = new TreeNode(3);
        invalid.root.right.right = new TreeNode(6);

        Assert.assertEquals(false, isValidBST(invalid.root));

        Assert.assertEquals(false, isValidBST(new BSTree(new int[]{1, 1}).root));
        Assert.assertEquals(false, isValidBST(new BSTree(new int[]{-2147483648, -2147483648}).root));

    }
}
