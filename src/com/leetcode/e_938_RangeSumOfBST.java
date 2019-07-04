package com.leetcode;

//Range Sum of BST
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************

//Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
//
//        The binary search tree is guaranteed to have unique values.
//
//
//
//        Example 1:
//
//        Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
//        Output: 32
//        Example 2:
//
//        Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//        Output: 23
//
//
//        Note:
//
//        The number of nodes in the tree is at most 10000.
//        The final answer is guaranteed to be less than 2^31.
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/range-sum-of-bst/
//******************************************************************************************************************


public class e_938_RangeSumOfBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    TreeNode root;

    void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        insert(val, root);
    }

    void insert(int val, TreeNode node) {

        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insert(val, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insert(val, node.right);
            }
        }
    }


    public static void main(String[] args) {

        e_938_RangeSumOfBST rangeSumOfBST = new e_938_RangeSumOfBST();

        rangeSumOfBST.insert(10);
        rangeSumOfBST.insert(5);
        rangeSumOfBST.insert(15);
        rangeSumOfBST.insert(3);
        rangeSumOfBST.insert(7);
        rangeSumOfBST.insert(18);

        System.out.println(rangeSumOfBST.rangeSumBST(rangeSumOfBST.root, 7, 15));

    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;

        for (int i = L; i <= R; i++) {
            if (exists(root, i)) {
                sum += i;
            }
        }

        return sum;
    }


    //1st soln
    boolean exists(TreeNode node, int i) {

        if (node == null) {
            return false;
        }

        if (i == node.val) {
            return true;
        }

        if (i < node.val) {
            return exists(node.left, i);
        } else {
            return exists(node.right, i);
        }
    }


    @Test
    public void TestrangeSumBST() {
        insert(10);
        insert(5);
        insert(15);
        insert(3);
        insert(7);
        insert(18);

        Assert.assertEquals(32, rangeSumBST(root, 7, 15));
        root = null;

        insert(10);
        insert(5);
        insert(15);
        insert(3);
        insert(7);
        insert(13);
        insert(18);
        insert(1);
        insert(6);


        Assert.assertEquals(23, rangeSumBST(root, 6, 10));


    }

    @Test
    public void Testinsert() {
        insert(10);
        insert(15);
        insert(1);
        Assert.assertEquals(10, root.val);
        Assert.assertEquals(1, root.left.val);
        Assert.assertEquals(15, root.right.val);
    }


    //todo: another soln might be doable and better in performance
    // Find the least element within the range then get the higher grandparent (as root for this range) then traverse the whole subtree
//    public int rangeSumBST2(TreeNode root, int L, int R) {
//
//        for (int i=L;i<=R;i++){
//            TreeNode node = find(root, i);
//
//            if (node != null) {
//                //found, traverse now
//                //todo: go to parent till the biggest parent that's still in between the range only for
//                //then traverse until
//                return  traverse(node, i, R);
//            }
//        }
//
//        return 0;
//    }
//
//    //find the lowest element first
//    //then traverse from that element all the way until you reach the R
//    int traverse(TreeNode node, int s, int e) {
//        //return s + traverse()
//
//
//        return 0;
//    }

//    TreeNode find(TreeNode node, int i) {
//
//        if (node == null) {
//            return null;
//        }
//
//        if (i == node.val) {
//            return node;
//        }
//
//        if (i < node.val) {
//            return find(node.left, i);
//        } else {
//            return find(node.right, i);
//        }
//    }
}
