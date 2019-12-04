package com.leetcode;

//e_235_LowestCommonAncestorofaBinarySearchTree 
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

//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
//Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
//
//Example 1:
//
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
//Example 2:
//
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
//
//
//Note:
//
//All of the nodes' values will be unique.
//p and q are different and both values will exist in the BST.
//******************************************************************************************************************
//Companies: LinkedIn | 11  Amazon | 3  Facebook | 2  Microsoft | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//******************************************************************************************************************

public class e_235_LowestCommonAncestorofaBinarySearchTree {


    public static void main(String[] args) {


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        TreeNode current = root;
        while (current != null) {
            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else {
                //one is left and the other one is right, return this node
                return current;
            }
        }


        return null;

    }

    /////////
    //bottom up
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        if (left == null)
            return right;
        else
            return left;
    }

    @Test
    public void TestLowestCommonAncestor() {
        BSTree t = new BSTree(new int[]{8, 4, 2, 19, 5, 15, 20});
        Assert.assertEquals(t.root.right, lowestCommonAncestor(t.root, t.root.right.right, t.root.right.left));
        Assert.assertEquals(t.root.right, lowestCommonAncestor(t.root, t.root.right, t.root.right.left));
        Assert.assertEquals(t.root, lowestCommonAncestor(t.root, t.root.right, t.root.left.left));
        Assert.assertEquals(t.root, lowestCommonAncestor(t.root, t.root, t.root.left));
        Assert.assertEquals(t.root.left, lowestCommonAncestor(t.root, t.root.left.right, t.root.left));


        Assert.assertEquals(t.root.right, lowestCommonAncestor2(t.root, t.root.right.right, t.root.right.left));
        Assert.assertEquals(t.root.right, lowestCommonAncestor2(t.root, t.root.right, t.root.right.left));
        Assert.assertEquals(t.root, lowestCommonAncestor2(t.root, t.root.right, t.root.left.left));
        Assert.assertEquals(t.root, lowestCommonAncestor2(t.root, t.root, t.root.left));
        Assert.assertEquals(t.root.left, lowestCommonAncestor2(t.root, t.root.left.right, t.root.left));
    }


}
