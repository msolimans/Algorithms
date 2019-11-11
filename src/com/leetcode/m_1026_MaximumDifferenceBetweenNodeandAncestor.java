package com.leetcode;

//m_1026_MaximumDifferenceBetweenNodeandAncestor 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * DFS
 */

/*Description*/
//******************************************************************************************************************
//Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
//
//(A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)
//
//
//
//Example 1:
//
//
//
//Input: [8,3,10,1,6,null,14,null,null,4,7,13]
//Output: 7
//Explanation:
//We have various ancestor-node differences, some of which are given below :
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
//
//
//Note:
//
//The number of nodes in the tree is between 2 and 5000.
//Each node will have value between 0 and 100000.
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
//******************************************************************************************************************

public class m_1026_MaximumDifferenceBetweenNodeandAncestor {


    public static void main(String[] args) {


    }

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }



    public int maxAncestorDiff(TreeNode node, int min, int max) {

        //every time we record the min and max value at each node then we subtract min/max from current node's val to see which makes bigger diff
        //current max is either [absolute diff between current node's value and min] or [absolute diff between current node's val and max]
        int cmax = Math.max(Math.abs(node.val - (min == Integer.MAX_VALUE ? node.val : min)), Math.abs(node.val - (max == Integer.MIN_VALUE ? node.val : max)));

        //update min if we have current node's val less than current min
        if (node.val < min)
            min = node.val;
        //update max if we have current node's val grater than current max
        if (node.val > max)
            max = node.val;

        //check max of left subtree and compare it with current node's max
        if (node.left != null)
            cmax = Math.max(cmax, maxAncestorDiff(node.left, min, max));
        //check max of right subtree and compare it with current node's max
        if (node.right != null)
            cmax = Math.max(cmax, maxAncestorDiff(node.right, min, max));

        //return the max
        return cmax;
    }

    @Test
    public void TestMaxAncestorDiff() {
        BSTree tree = new BSTree(new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13});
        Assert.assertEquals(7, new m_1026_MaximumDifferenceBetweenNodeandAncestor().maxAncestorDiff(tree.root));


        BSTree tree1 = new BSTree(new int[]{8, 3});
        Assert.assertEquals(5, new m_1026_MaximumDifferenceBetweenNodeandAncestor().maxAncestorDiff(tree1.root));


        TreeNode root2 = new TreeNode(8);
        root2.right = new TreeNode(1);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(6);
        root2.right.right.left = new TreeNode(0);
        root2.right.left.left = new TreeNode(2);
        root2.right.left.right = new TreeNode(4);
        root2.right.left.left.left = new TreeNode(7);
        root2.right.left.left.right = new TreeNode(3);

        Assert.assertEquals(8, new m_1026_MaximumDifferenceBetweenNodeandAncestor().maxAncestorDiff(root2));

    }


}
