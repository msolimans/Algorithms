package com.leetcode;

//m_113_PathSumII 
//Show Topic Tags

import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Given the below binary tree and sum = 22,
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
//Return:
//
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/path-sum-ii/
//******************************************************************************************************************

public class m_113_PathSumII {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(Arrays.toString(new m_113_PathSumII().pathSum(root, 22).toArray()));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //if root's null, return empty result
        if(root == null)
            return result;

        //traverse, pre-order traversal
        pathSum(root, new ArrayList<>(), 0, sum);
        return result;
    }


    public void pathSum(TreeNode root, List<Integer> path, int prev, int sum) {

        //add current node's value to path
        path.add(root.val);
        //accumulative sum into prev [all elems including current node's value]
        prev += root.val;

        //if left and right is null, its leaf .. check if prev == sum, if so add path to result array
        if (root.left == null && root.right == null) {
            if (prev == sum)
                result.add(path);
        }

        //if current node has left branch, visit it [note: create a new array for path]
        if (root.left != null) {
            List<Integer> lpath = new ArrayList<>(path);
            pathSum(root.left, lpath, prev, sum);
        }

        //same for right subtree
        if (root.right != null) {
            List<Integer> rpath = new ArrayList<>(path);
            pathSum(root.right, rpath, prev, sum);
        }

    }

    @Test
    public void TestPathSum() {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<Integer> r1 = Arrays.asList(5, 4, 11, 2);
        List<Integer> r2 = Arrays.asList(5, 8, 4, 5);
        List<List<Integer>> result = new ArrayList<>();
        result.add(r1);
        result.add(r2);

        Assert.assertArrayEquals(result.toArray(), pathSum(root, 22).toArray());

    }
}
