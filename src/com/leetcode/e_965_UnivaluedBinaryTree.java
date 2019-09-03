package com.leetcode;

//e_965_UnivaluedBinaryTree 
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
//A binary tree is univalued if every node in the tree has the same value.
//
//Return true if and only if the given tree is univalued.

//Example 1:
//   1
//  / \
// 1   1
//    / \
//   1   1
//Input: [1,1,1,1,1,null,1]
//Output: true
//Example 2:
//      2
//     / \
//    2   2
//   / \
//  5   2
//Input: [2,2,2,5,2]
//Output: false
//
//
//Note:
//
//The number of nodes in the given tree will be in the range [1, 100].
//Each node's value will be an integer in the range [0, 99].

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/univalued-binary-tree/
//******************************************************************************************************************

public class e_965_UnivaluedBinaryTree {


    public static void main(String[] args) {

        System.out.println(new e_965_UnivaluedBinaryTree().isUnivalTree(new BSTree(new int[]{1, 1}).root));
        System.out.println(new e_965_UnivaluedBinaryTree().isUnivalTree(new BSTree(new int[]{1, 2}).root));
    }

    public boolean isUnivalTree(TreeNode root) {
        //if root's null, return true
        if (root == null)
            return true;

        //pass root's val to subsequent calls
        return isUnivalTree(root, root.val);
    }

    public boolean isUnivalTree(TreeNode node, int val) {
        //if node's null, return true
        if (node == null)
            return true;

        //if any of the node's val is not equal to root's val, return false
        if (node.val != val)
            return false;

        //check left and right children
        return isUnivalTree(node.left, val) && isUnivalTree(node.right, val);
    }

    @Test
    public void TestisUnivalTree() {
        Assert.assertTrue(isUnivalTree(new BSTree(new int[]{1, 1, 1, 1, 1}).root));
        Assert.assertFalse(isUnivalTree(new BSTree(new int[]{1, 1, 1, 5, 1}).root));
    }

}
