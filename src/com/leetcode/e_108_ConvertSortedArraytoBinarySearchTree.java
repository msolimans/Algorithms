package com.leetcode;

//e_108_ConvertSortedArraytoBinarySearchTree 
//Show Topic Tags

import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Divide and Conquer, Binary Trees
 */

/*Description*/
//******************************************************************************************************************
//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
// of every node never differ by more than 1.
//
//Example:
//
//Given the sorted array: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//******************************************************************************************************************
//Companies: Amazon | 3
//******************************************************************************************************************
//Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//******************************************************************************************************************

public class e_108_ConvertSortedArraytoBinarySearchTree {


    public static void main(String[] args) {


    }

    //used for 1st solution where we save root node to be returned as result
    TreeNode root;

    //used to insert elems in the binary seach tree
    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        //find where to insert node
        TreeNode current = root;
        while (true) {
            //if it is less than current node, go left
            if (val < current.val) {
                //if left is null add it under this current node and break
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {//otherwise continue traversing in the left subtree
                    current = current.left;
                }
            } else {
                //if it is greater than current node's val, check if right is null add it as a right subtree under current node and break
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {//otherwise continue traversing the right subtree
                    current = current.right;
                }

            }
        }
    }


    //O(nlogn) solution
    //every time we add elem, it tries to find its proper location in O(logn)
    //we have n elems so overall time complexity is O(nlogn)
    public TreeNode sortedArrayToBST(int[] nums) {//
        sortedArrayToBST(nums, 0, nums.length - 1);
        return root;
    }


    void sortedArrayToBST(int[] nums, int start, int end) {
        //if start is greater than end or we are out of the boundary of the array, we terminate recursion
        if (start > end || start < 0 || end > nums.length - 1)
            return;

        //if we have start equals end, means we have only one elm in sub array, just add it and terminate recursion
        if (start == end) {
            insert(nums[start]);
            return;
        }

        //find the mid elem, insert it and recursively continue visiting left and right subarrays
        int mid = (start + end) / 2;
        insert(nums[mid]);

        sortedArrayToBST(nums, start, mid - 1);
        sortedArrayToBST(nums, mid + 1, end);
    }


    @Test
    public void TestInsert() {
        e_108_ConvertSortedArraytoBinarySearchTree soln1 = new e_108_ConvertSortedArraytoBinarySearchTree();
        soln1.insert(20);
        soln1.insert(10);
        soln1.insert(30);
        Assert.assertEquals(20, soln1.root.val);
        Assert.assertEquals(10, soln1.root.left.val);
        Assert.assertEquals(30, soln1.root.right.val);
    }

    @Test
    public void TestSortedArrayToBST() {
        e_108_ConvertSortedArraytoBinarySearchTree soln1 = new e_108_ConvertSortedArraytoBinarySearchTree();
        int[] arr1 = new int[]{-10, -3, 0, 5, 9};
        TreeNode r1 = soln1.sortedArrayToBST(arr1);
        Assert.assertEquals(Arrays.toString(arr1).replaceAll("[\\,\\s\\[\\]]", ""), r1.toString());
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Better Solution, tweaked to be O(n)
    //No need for insert() functions which means it is O(n)
    public TreeNode sortedArrayToBST2(int[] nums) {
        return sortedArrayToBST2(nums, 0, nums.length - 1);
    }


    TreeNode sortedArrayToBST2(int[] nums, int start, int end) {
        //if we're out of boundary of array, terminate recursion
        if (start > end || start < 0 || end > nums.length - 1)
            return null;

        //if we have one elem in subarray just return it
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        //calc the mid of array
        int mid = (start + end) / 2;
        //create a node for it
        TreeNode node = new TreeNode(nums[mid]);

        //recursively, divide and conquer left and right subarrays and link the result to the above created node.
        node.left = sortedArrayToBST2(nums, start, mid - 1);
        node.right = sortedArrayToBST2(nums, mid + 1, end);

        //this should bubble up, return the root node
        return node;
    }


    @Test
    public void TestSortedArrayToBST2() {
        e_108_ConvertSortedArraytoBinarySearchTree soln1 = new e_108_ConvertSortedArraytoBinarySearchTree();
        int[] arr1 = new int[]{-10, -3, 0, 5, 9};
        TreeNode r1 = soln1.sortedArrayToBST2(arr1);
        Assert.assertEquals(Arrays.toString(arr1).replaceAll("[\\,\\s\\[\\]]", ""), r1.toString());
    }
}
