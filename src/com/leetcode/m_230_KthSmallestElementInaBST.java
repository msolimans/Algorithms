package com.leetcode;

//m_230_KthSmallestElementInaBST
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//Note:
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
//Example 1:
//
//Input: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//Output: 1
//Example 2:
//
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//Output: 3
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//******************************************************************************************************************

public class m_230_KthSmallestElementInaBST {


    public static void main(String[] args) {

        System.out.println(new m_230_KthSmallestElementInaBST().kthSmallest(new BSTree(new int[]{3, 1, 4, 2}).root, 1));

    }


    //inorder traversal to retrieve kth elem in the tree
    //inorder traversal will visit nodes in order [sorted] so we will loop from the min to max until and keep counting until we reach k
    public int kthSmallest(TreeNode root, int k) {
        //inorder traversal and count k
        int count = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode next = root;
        while (next != null || !stack.empty()) {
            if (next != null) {
                stack.push(next);
                next = next.left;
            } else {
                TreeNode node = stack.pop();
                if (++count == k)
                    return node.val;
                next = node.right;
            }

        }


        return -1;
    }

    //for the followup, we can use priority queues to retrieve the kth elem quicker, check this ../probs/p_29_FindKSmallestNumberInBST.java

    @Test
    public void TestKthSmallest() {
        Assert.assertEquals(1, kthSmallest(new BSTree(new int[]{3, 1, 4, 2}).root, 1));
        Assert.assertEquals(3, kthSmallest(new BSTree(new int[]{5, 3, 6, 2, 4, 1}).root, 3));

    }

}
