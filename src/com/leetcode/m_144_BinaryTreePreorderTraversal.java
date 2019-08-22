package com.leetcode;

//m_144_BinaryTreePreorderTraversal 
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
//Given a binary tree, return the preorder traversal of its nodes' values.
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
//Output: [1,2,3]
//Follow up: Recursive solution is trivial, could you do it iteratively?

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
//******************************************************************************************************************

public class m_144_BinaryTreePreorderTraversal {


    public static void main(String[] args) {


    }

    //iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        //we use stack in preorder traversal
        //1) we push the root, then push the right node and the left node of the current node.
        //2) stack is last in - first out, so we grab the right node first then the left node to make sure we pop first the left node
        //we continue by repeating step 1 and 2 in the while loop until stack gets empty
        while (!stack.empty()) {
            //visit the current node
            TreeNode current = stack.pop();
            //add it to the result
            result.add(current.val);

            //push the right node
            if (current.right != null) {
                stack.push(current.right);
            }

            //push the left node
            if (current.left != null) {
                stack.push(current.left);
            }

        }


        //return the result
        return result;

    }

    @Test
    public void TestPreorderTraversal() {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.right = new TreeNode(20);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(7);
        Assert.assertArrayEquals(new Integer[]{10, 5, 6, 7, 15, 20}, preorderTraversal(node).toArray());

        /////

        node = new TreeNode(20);
        node.left = new TreeNode(5);
        Assert.assertArrayEquals(new Integer[]{20, 5}, preorderTraversal(node).toArray());

        /////

        Assert.assertArrayEquals(new Integer[]{20}, preorderTraversal(new TreeNode(20)).toArray());

        /////


        Assert.assertArrayEquals(new Integer[]{1,2,3,4,5}, preorderTraversal(new BSTree(new int[]{1, 2, 3, 4, 5}).root).toArray());
        Assert.assertArrayEquals(new Integer[]{5,2,0,3,10,7,11}, preorderTraversal(new BSTree(new int[]{5,2,3,0,10,7,11}).root).toArray());

        Assert.assertArrayEquals(new Integer[]{}, preorderTraversal(new BSTree().root).toArray());


    }


}
