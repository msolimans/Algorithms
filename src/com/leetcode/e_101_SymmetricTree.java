package com.leetcode;

//e_101_SymmetricTree 
//Show Topic Tags

import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//But the following [1,2,2,null,3,null,3] is not:
//
//    1
//   / \
//  2   2
//   \   \
//    3   3
//
//
//Note:
//Bonus points if you could solve it both recursively and iteratively.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/symmetric-tree/
//******************************************************************************************************************

public class e_101_SymmetricTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(new e_101_SymmetricTree().isSymmetric(root));
        root.left = new TreeNode(2);
        System.out.println(new e_101_SymmetricTree().isSymmetric(root));
        root.right = new TreeNode(2);
        System.out.println(new e_101_SymmetricTree().isSymmetric(root));
    }


    public boolean isSymmetric(TreeNode root) {


        if (root == null || (root.left == null && root.right == null))
            return true;

        Stack<TreeNode> lstack = new Stack<>();
        Stack<TreeNode> rstack = new Stack<>();

        if (root.left != null)
            lstack.push(root.left);
        if (root.right != null)
            rstack.push(root.right);

        while (!lstack.empty() && !rstack.empty()) {
            //node left
            TreeNode lnode = lstack.pop();
            TreeNode rnode = rstack.pop();

            if (lnode.val != rnode.val)
                return false;

            if ((lnode.left == null && rnode.right != null) || lnode.left != null && rnode.right == null)
                return false;

            if ((lnode.right == null && rnode.left != null) || lnode.right != null && rnode.left == null)
                return false;

            if (lnode.left != null)
                lstack.push(lnode.left);
            if (lnode.right != null)
                lstack.push(lnode.right);

            if (rnode.right != null)
                rstack.push(rnode.right);
            if (rnode.left != null)
                rstack.push(rnode.left);

        }


        return lstack.empty() && rstack.empty();
    }


    @Test
    public void TestIsSummetric() {


//            1
//           / \
//          2   2
//         / \ / \
//        3  4 4  3

        TreeNode root = new TreeNode(1);
        Assert.assertTrue(isSymmetric(root));
        root.left = new TreeNode(2);
        Assert.assertFalse(isSymmetric(root));
        root.right = new TreeNode(2);
        Assert.assertTrue(isSymmetric(root));
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        Assert.assertTrue(isSymmetric(root));
        root.left.left = null;
        root.left.right = new TreeNode(3);
        Assert.assertFalse(isSymmetric(root));
        root.left.left = new TreeNode(3);
        Assert.assertFalse(isSymmetric(root));
        root.left.right = new TreeNode(4);
        Assert.assertFalse(isSymmetric(root));
        root.right.left = new TreeNode(4);
        Assert.assertTrue(isSymmetric(root));

    }


}
