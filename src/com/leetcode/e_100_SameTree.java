package com.leetcode;

//e_100_SameTree 
//Show Topic Tags

import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given two binary trees, write a function to check if they are the same or not.
//
//Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
//
//Example 1:
//
//Input:     1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//Output: true
//Example 2:
//
//Input:     1         1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//Output: false
//Example 3:
//
//Input:     1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//Output: false
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/same-tree/
//******************************************************************************************************************

public class e_100_SameTree {


    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(new e_100_SameTree().isSameTree(p, q));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //if both p and q are null, return true [they're equal]
        if (p == null && q == null)
            return true;

        if (p == null || q == null)//one of them is null => p != null && q == null || p == null && q != null
            return false;

        //both of them should've the same val and left subtree = left subtree and right subtree = right subtree
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void TestIsSameTree() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        Assert.assertTrue(isSameTree(p, p));
        p.right = null;
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
        Assert.assertFalse(isSameTree(p, q));
        p.right = new TreeNode(1);
        q.left = new TreeNode(1);
        Assert.assertFalse(isSameTree(p, q));
    }

}
