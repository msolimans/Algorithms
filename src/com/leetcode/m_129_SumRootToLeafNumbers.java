package com.leetcode;

//m_129_SumRootToLeafNumbers
//Show Topic Tags

import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//Find the total sum of all root-to-leaf numbers.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Input: [1,2,3]
//    1
//   / \
//  2   3
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25.
//Example 2:
//
//Input: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//Output: 1026
//Explanation:
//The root-to-leaf path 4->9->5 represents the number 495.
//The root-to-leaf path 4->9->1 represents the number 491.
//The root-to-leaf path 4->0 represents the number 40.
//Therefore, sum = 495 + 491 + 40 = 1026.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/
//******************************************************************************************************************

public class m_129_SumRootToLeafNumbers {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new m_129_SumRootToLeafNumbers().sumNumbers(root));

    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        return sumNumbers(root, Integer.toString(root.val));
    }

    //like dfs
    public int sumNumbers(TreeNode root, String sum) {


        int left = 0, right = 0;
        //if left and right is empty, return current sum
        if (root.left == null && root.right == null)
            return Integer.parseInt(sum);
        //if there's left subnode, add it to string [should be stringbuilder for better performance]
        if (root.left != null)
            left = sumNumbers(root.left, sum + root.left.val);
        //same for right subtree
        if (root.right != null)
            right = sumNumbers(root.right, sum + root.right.val);

        //sum both left and right
        return left + right;
    }

    @Test
    public void TestsumNumbers() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Assert.assertEquals(25, sumNumbers(root));

        root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        Assert.assertEquals(1026, sumNumbers(root));


        root = new TreeNode(4);
        Assert.assertEquals(4, sumNumbers(root));


        root = null;
        Assert.assertEquals(0, sumNumbers(root));
    }

}
