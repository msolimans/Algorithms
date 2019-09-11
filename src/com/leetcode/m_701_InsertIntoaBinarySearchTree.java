package com.leetcode;

//m_701_InsertIntoaBinarySearchTree 
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
//Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
//
//Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
//
//For example,
//
//Given the tree:
//        4
//       / \
//      2   7
//     / \
//    1   3
//And the value to insert: 5
//You can return this binary search tree:
//
//         4
//       /   \
//      2     7
//     / \   /
//    1   3 5
//This tree is also valid:
//
//         5
//       /   \
//      2     7
//     / \
//    1   3
//         \
//          4

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
//******************************************************************************************************************

public class m_701_InsertIntoaBinarySearchTree {


    public static void main(String[] args) {
        BSTree tree = new BSTree(new int[]{4, 5, 2, 1, 3});
        new m_701_InsertIntoaBinarySearchTree().insertIntoBST(tree.root, 7);
        System.out.println(tree);

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);


        if (val <= root.val) {
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                insertIntoBST(root.left, val);
        } else {
            if (root.right == null)
                root.right = new TreeNode(val);
            else
                insertIntoBST(root.right, val);
        }


        return root;
    }

    @Test
    public void TestInsertIntoBST() {

        BSTree tree = new BSTree(new int[]{4, 2, 7, 1, 3});
        TreeNode res = insertIntoBST(tree.root, 5);
        Assert.assertEquals(tree.root, res);
        Assert.assertEquals("427135", tree.toString());

    }

}
