package com.leetcode;

//e_111_MinimumDepthofBinaryTree 
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
//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its minimum depth = 2.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
//******************************************************************************************************************

public class e_111_MinimumDepthofBinaryTree {


    public static void main(String[] args) {
        System.out.println(new e_111_MinimumDepthofBinaryTree().minDepth(new BSTree(new int[]{3, 2, 20, 15, 7}).root));

    }

    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        //calc left subtree
        int left = 1 + minDepth(root.left);
        //calc right subtree
        int right = 1 + minDepth(root.right);

        //to handle cases like [1,2]
        //  1
        //   \
        // .  2
        if (left == 1 && right > 1)
            return right;

        //to handle cases like
        //    1
        //   /
        //  2
        if (right == 1 && left > 1)
            return left;

        //return min of left and right
        return Math.min(left, right);
    }


    @Test
    public void TestMinDepth() {
        Assert.assertEquals(2, minDepth(new BSTree(new int[]{3, 2, 20, 15, 7}).root));
        Assert.assertEquals(2, minDepth(new BSTree(new int[]{1, 2}).root));
        Assert.assertEquals(0, minDepth(null));
    }
}
