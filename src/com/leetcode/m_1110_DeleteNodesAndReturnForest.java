package com.leetcode;

//m_1110_DeleteNodesAndReturnForest 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given the root of a binary tree, each node in the tree has a distinct value.
//
//After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
//
//Return the roots of the trees in the remaining forest.  You may return the result in any order.
//
//
//
//Example 1:
//
//
//
//Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
//Output: [[1,2,null,4],[6],[7]]
//
//
//Constraints:
//
//The number of nodes in the given tree is at most 1000.
//Each node has a distinct value between 1 and 1000.
//to_delete.length <= 1000
//to_delete contains distinct values between 1 and 1000.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/delete-nodes-and-return-forest/
//******************************************************************************************************************

public class m_1110_DeleteNodesAndReturnForest {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);


        System.out.println(Arrays.toString(new m_1110_DeleteNodesAndReturnForest().delNodes(root, new int[]{3, 5}).toArray()));
    }

    List<TreeNode> result = new ArrayList<>();
    Set<Integer> ito_delete = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        for (int i : to_delete)
            ito_delete.add(i);

        if (root != null && !ito_delete.contains(root.val))
            result.add(root);

        delNodes(root);
        return result;
    }


    public void delNodes(TreeNode root) {
        if (root == null)
            return;
        //botton up approach
        //post order traversal
        delNodes(root.left);
        delNodes(root.right);

        //if root's left isn't null and left's val is in the index make it null
        //will handle such case
        //     1
        //    /
        //   2
        //  / \
        // 4   3
        //to_delete [2,3]
        if (root.left != null && ito_delete.contains(root.left.val))
            root.left = null;

        //if root's right isn't null and right's val is in the index make it null
        if (root.right != null && ito_delete.contains(root.right.val))
            root.right = null;

        //now visiting the node from bottom, we've already visited all of its children before
        if (ito_delete.contains(root.val)) {
            //if left isn't null, add it [we cleaned it above in case it was in to_deleted]
            if (root.left != null)
                result.add(root.left);

            //if right isn't null, add it [we cleaned it above in case it was in to_deleted]
            if (root.right != null)
                result.add(root.right);

        }


    }


    @Test
    public void TestDelNodes() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<TreeNode> exp = new ArrayList<>();
        exp.add(root);
        exp.add(root.right.left);
        exp.add(root.right.right);

        Assert.assertArrayEquals(exp.toArray(), new m_1110_DeleteNodesAndReturnForest().delNodes(root, new int[]{3, 5}).toArray());


        //////


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(3);


        List<TreeNode> exp2 = new ArrayList<>();
        exp2.add(root2);
        exp2.add(root2.left.left);


        Assert.assertArrayEquals(exp2.toArray(), new m_1110_DeleteNodesAndReturnForest().delNodes(root2, new int[]{2, 3}).toArray());


    }

}
