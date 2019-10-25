package com.leetcode;

//e_897_IncreasingOrderSearchTree 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.LinkedList;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
//
//Example 1:
//Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//       5
//      / \
//    3    6
//   / \    \
//  2   4    8
// /        / \
//1        7   9
//
//Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6
//            \
//             7
//              \
//               8
//                \
//                 9
//Note:
//
//The number of nodes in the given tree will be between 1 and 100.
//Each node will have a unique integer value from 0 to 1000.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/increasing-order-search-tree/
//******************************************************************************************************************

public class e_897_IncreasingOrderSearchTree {


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
    //Inorder traversal using stack
    //15% Faster than other solutions
    public TreeNode increasingBST(TreeNode root) {

        if (root == null)
            return null;

        //Inorder traversal using stack
        TreeNode result = new TreeNode(0);
        TreeNode current = result;
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            //check if root is not null, means we can push to stack until we exhaust left subtree
            if (root != null) {
                stack.push(root);
                //move forward root [current cursor or pointer] to left subtree
                root = root.left;
            } else {
                //in case stack gets empty, break our infinite loop
                if (stack.empty()) break;

                //finished left branch, visit node itself
                TreeNode node = stack.pop();
                //add it to the result path
                current.right = new TreeNode(node.val);
                current = current.right;
                //update root to right tree node
                root = node.right;
            }

        }

        return result.right;

    }


    //Second solution [Beats other java solutions 100% faster]
    //better performance [No extra space for Stack]
    TreeNode result = new TreeNode(0);
    TreeNode current = result;


    void dfs(TreeNode node) {
        //if current node's null, stop recursion
        if (node == null)
            return;

        //pass thru left subtree
        dfs(node.left);

        //visiting the node and pushing it to the result
        current.right = new TreeNode(node.val);
        current = current.right;

        //continue traversing to right subtree
        dfs(node.right);
    }

    public TreeNode increasingBST2(TreeNode root) {
        if(root == null)
            return null;

        dfs(root);
        return result.right;
    }

    @Test
    public void TestIncreasingBST() {
        //overriden toString was added to make it easy for unit testing
        Assert.assertEquals("123456789", increasingBST(new BSTree(new int[]{5, 3, 6, 2, 4, 8, 1, 7, 9}).root).toString());
        Assert.assertEquals("123456789", increasingBST2(new BSTree(new int[]{5, 3, 6, 2, 4, 8, 1, 7, 9}).root).toString());
    }
}
