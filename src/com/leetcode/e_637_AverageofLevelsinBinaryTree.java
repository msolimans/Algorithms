package com.leetcode;

//e_637_AverageofLevelsinBinaryTree
//Show Topic Tags


import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//Example 1:
//Input:
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Output: [3, 14.5, 11]
//Explanation:
//The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
//Note:
//The range of node's value is in the range of 32-bit signed integer.
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/
//******************************************************************************************************************

public class e_637_AverageofLevelsinBinaryTree {

    static TreeNode root;

    static {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static void main(String[] args) {

        System.out.println(new e_637_AverageofLevelsinBinaryTree().averageOfLevels(root));
    }

    List<Double> result = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {

        if (root == null)
            return result;

        //call on root first
        averageOfLevel(Collections.singletonList(root));
        return result;
    }

    void averageOfLevel(List<TreeNode> nodes) {
        double sum = 0d;
        //store all children of current node(s) in list
        List<TreeNode> childs = new ArrayList<>();
        for (TreeNode n : nodes) {
            //sum all node(s) vals
            sum += n.val;
            if (n.left != null)
                childs.add(n.left);
            if (n.right != null)
                childs.add(n.right);
        }

        //add average to shared results
        result.add(sum / nodes.size());

        //if we had noticed any child from current node(s), recursively call the func again
        if (childs.size() > 0)
            averageOfLevel(childs);
    }

    @Test
    public void TestaverageOfLevels() {
        Assert.assertArrayEquals(new Object[]{3.0, 14.5, 11.0}, averageOfLevels(root).toArray());
    }
}
