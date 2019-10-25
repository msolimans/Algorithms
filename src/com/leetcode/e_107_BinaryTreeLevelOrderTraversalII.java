package com.leetcode;

//e_107_BinaryTreeLevelOrderTraversalII 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
//******************************************************************************************************************

public class e_107_BinaryTreeLevelOrderTraversalII {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new e_107_BinaryTreeLevelOrderTraversalII().levelOrderBottom(new BSTree(new int[]{5, 2, 3, 9, 7, 6}).root).toArray()));
    }


    //get all nodes in each level and pass it recursively
    //in each level, get all left/right children and add them to inner result
    //before we end level processing, check if we have any item in this level [level array list] add it to the global/final result array list
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //result array list
        List<List<Integer>> result = new ArrayList<>();
        //pass it thru inner func call
        levelOrderBottom(Collections.singletonList(root), result);
        //reverse the result
        Collections.reverse(result);
        return result;
    }

    //call this recursively for each level
    public void levelOrderBottom(List<TreeNode> level, List<List<Integer>> result) {

        //if passed level is null or size of lelve is zero, no need for any further processing
        if (level == null || level.size() == 0) {
            return;
        }

        //children is a list for all children
        List<TreeNode> children = new ArrayList<>();
        //ires is the list for current level's result [array list]
        List<Integer> ires = new ArrayList<>();

        //loop through current level
        for (TreeNode node : level) {
            //in case node is null, skip it
            if (node == null)
                continue;

            //add its value to current level result array list
            ires.add(node.val);

            //check its left and right branches
            if (node.left != null)
                children.add(node.left);
            if (node.right != null)
                children.add(node.right);
        }

        //if we recorded anything in this level, add it to final result
        if (ires.size() > 0)
            result.add(ires);

        //in case we have children, recursively loop again
        if (children.size() > 0)
            levelOrderBottom(children, result);


    }

    @Test
    public void TestLevelOrderBottom() {

        Assert.assertArrayEquals(new Object[]{Arrays.asList(6), Arrays.asList(3, 7), Arrays.asList(2, 9), Arrays.asList(5)},
                levelOrderBottom(new BSTree(new int[]{5, 2, 3, 9, 7, 6}).root).toArray());

        Assert.assertEquals("", Arrays.toString(levelOrderBottom(null).toArray()));

        Assert.assertArrayEquals(new Object[]{Arrays.asList(6), Arrays.asList(3, 7), Arrays.asList(2, 9), Arrays.asList(5)},
                levelOrderBottom(new BSTree(new int[]{5, 2, 3, 9, 7, 6}).root).toArray());

    }

}
