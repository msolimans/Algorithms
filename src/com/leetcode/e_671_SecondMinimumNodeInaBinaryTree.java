package com.leetcode;

//e_671_SecondMinimumNodeInaBinaryTree 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
//
//Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
//
//If no such second minimum value exists, output -1 instead.
//
//Example 1:
//
//Input:
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//Output: 5
//Explanation: The smallest value is 2, the second smallest value is 5.
//
//
//Example 2:
//
//Input:
//    2
//   / \
//  2   2
//
//Output: -1
//Explanation: The smallest value is 2, but there isn't any second smallest value.
//

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
//******************************************************************************************************************

public class e_671_SecondMinimumNodeInaBinaryTree {


    public static void main(String[] args) {


    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int findSecondMinimumValue(TreeNode root) {

        //based on the input root.val = min(root.left.val, root.right.val)
        //we need to make BFS, we can achieve that by using queues

        if (root == null)
            return -1;

        int count = 0;
        //it might have duplicates
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        boolean bfirst = true;
        boolean bsecond = true;


        while (!queue.isEmpty()) {

            TreeNode current = queue.pollFirst();

            //in every level, check the first elem
            if (bfirst || current.val < first) {
                second = first;
                first = current.val;
                bfirst = false;
                count++;//count how many did we find
            } else if ((bsecond || current.val < second) && current.val != first) { //now check the second min
                second = current.val;
                bsecond = false;
                count++;//count how many did we find
            }

            //visit left and right
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }

        return count>=2 ? second : -1;//if we found 2 elems, we return second min otherwise return -1
    }

    @Test
    public void TestfindSecondMinimumValue() {

        Assert.assertEquals(5, findSecondMinimumValue(new BSTree(new int[]{2, 2, 5, 5, 7}).root));
        Assert.assertEquals(7, findSecondMinimumValue(new BSTree(new int[]{6,6,6,6,6,6,7}).root));

        Assert.assertEquals(-1, findSecondMinimumValue(new BSTree(new int[]{2, 2, 2}).root));
        Assert.assertEquals(-1, findSecondMinimumValue(new BSTree(new int[]{}).root));

        Assert.assertEquals(-1, findSecondMinimumValue(new BSTree(new int[]{-2147483648, -2147483648}).root));
        Assert.assertEquals(-1, findSecondMinimumValue(new BSTree(new int[]{2147483647, 2147483647}).root));

        Assert.assertEquals(2147483647, findSecondMinimumValue(new BSTree(new int[]{-2147483648, 2147483647}).root));
        Assert.assertEquals(2147483647, findSecondMinimumValue(new BSTree(new int[]{ 2147483647, -2147483648}).root));

        Assert.assertEquals(8, findSecondMinimumValue(new BSTree(new int[]{5, 8, 5}).root));
        Assert.assertEquals(8, findSecondMinimumValue(new BSTree(new int[]{5, 8, 5}).root));
        Assert.assertEquals(2, findSecondMinimumValue(new BSTree(new int[]{8, 2, 31, 3, 2, 42, 1}).root));
        Assert.assertEquals(3, findSecondMinimumValue(new BSTree(new int[]{2, 2, 2, 4, 2, 3, 2}).root));
    }

}
