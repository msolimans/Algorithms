package com.leetcode;

//m_94_BinaryTreeInorderTraversal 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree, return the inorder traversal of its nodes' values.
//
//Example:
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2]
//Follow up: Recursive solution is trivial, could you do it iteratively?

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
//******************************************************************************************************************

public class m_94_BinaryTreeInorderTraversal {


    public static void main(String[] args) {


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

    //lets recall the meaning of inorder traversal, it means you visit left subtree, the node itself, then the right subtree
    public List<Integer> inorderTraversal(TreeNode root) {
        //left
        //node
        //right

        List<Integer> res = new ArrayList<>();
        //in case root's null, return empty array
        if(root == null )
            return res;

        TreeNode next = root; //root => root => left side
        Stack<TreeNode> stack = new Stack<>();//used for organizing the push/pop and do inorder traversal
        while (next != null || !stack.isEmpty()) {
            if (next != null) {//loop until we exhaust left branch, push them all
                stack.push(next);
                next = next.left;//everytime update next with next.left until we finish all of them
            } else {
                TreeNode n = stack.pop();//we finished pushing all left into the stack, now visit the node, then check right side
                res.add(n.val);//visit node
                next = n.right;//iterate again for this next's right to get left nodes out of it
            }

        }

        return res;

    }


    //using recursion
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root != null)
            return result;

        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        //left
        //node
        //right

        if (root.left != null)
            inorderTraversal(root.left, result);


        result.add(root.val);

        if (root.right != null)
            inorderTraversal(root.right, result);

    }

    @Test
    public void TestInorderTraversal() {
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, inorderTraversal(new BSTree(new int[]{1, 2, 3}).root).toArray());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, inorderTraversal(new BSTree(new int[]{2, 1, 3}).root).toArray());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, inorderTraversal(new BSTree(new int[]{2, 1, 4, 3, 5}).root).toArray());
    }


    @Test
    public void TestInorderTraversal2() {
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, inorderTraversal2(new BSTree(new int[]{1, 2, 3}).root).toArray());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, inorderTraversal2(new BSTree(new int[]{2, 1, 3}).root).toArray());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, inorderTraversal2(new BSTree(new int[]{2, 1, 4, 3, 5}).root).toArray());
    }


}
