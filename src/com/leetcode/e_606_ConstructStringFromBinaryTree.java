package com.leetcode;


//606. Construct String from Binary Tree
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//    You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
//
//            The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
//
//            Example 1:
//            Input: Binary tree: [1,2,3,4]
//            1
//            /   \
//            2     3
//            /
//            4
//
//            Output: "1(2(4))(3)"
//
//            Explanation: Originallay it needs to be "1(2(4)())(3()())",
//            but you need to omit all the unnecessary empty parenthesis pairs.
//            And it will be "1(2(4))(3)".
//            Example 2:
//            Input: Binary tree: [1,2,3,null,4]
//            1
//            /   \
//            2     3
//            \
//            4
//
//            Output: "1(2()(4))(3)"
//
//            Explanation: Almost the same as the first example,
//            except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/construct-string-from-binary-tree/
//******************************************************************************************************************


public class e_606_ConstructStringFromBinaryTree {


    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        e_606_ConstructStringFromBinaryTree soln = new e_606_ConstructStringFromBinaryTree();

        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);

        System.out.println(soln.tree2str(node));


    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String left = t.left != null ? "(" + tree2str(t.left) + ")" : t.right != null ? "()" : "";
        String right = t.right != null ? "(" + tree2str(t.right) + ")" : "";
        return t.val + left + right;
    }


    @Test
    public void Testtree2str() {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);

        Assert.assertEquals("1(2(4))(3)", tree2str(node));

        //1,2,3,null,4
        node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(3);

        Assert.assertEquals("1(2()(4))(3)", tree2str(node));

    }

}
