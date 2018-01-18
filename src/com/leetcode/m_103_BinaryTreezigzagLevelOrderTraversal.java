package com.leetcode;

//m_103_BinaryTreezigzagLevelOrderTraversal
//Show Topic Tags

import com.alkhawarizms.DataStructure.Trees.Tree;

import java.util.*;

/**
 * Breadth First Search, Trees
 */

/*Description*/
//******************************************************************************************************************

//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its zigzag level order traversal as:
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
//******************************************************************************************************************

public class m_103_BinaryTreezigzagLevelOrderTraversal {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        //add root to current level
        LinkedList<TreeNode> level = new LinkedList<>();
        level.addFirst(root);

        //add root's val to result
        List<Integer> lResult = new ArrayList<>();
        lResult.add(root.val);
        result.add(lResult);

        //changeable left/right direction
        boolean left = false;
        while (level.size() > 0) {
            lResult = new ArrayList<>();

            //return linkedlist of current level (always from left to right) BFS
            level = zigzagLevelOrder(level);
            if (level.size() == 0)
                break;

            Iterator<TreeNode> iterator = null;

            //iterate either from left to right in case left == true or Right to left in case left == false s
            if (left) {
                iterator = level.iterator();
            } else
                iterator = level.descendingIterator();
            while (iterator.hasNext()) {
                lResult.add(iterator.next().val);
            }

            result.add(lResult);
            left = !left;
        }


        return result;
    }


    //move from left to right
    public LinkedList<TreeNode> zigzagLevelOrder(LinkedList<TreeNode> level) {
        LinkedList<TreeNode> result = new LinkedList<>();

        while (level.size() > 0) {

            TreeNode node = level.pollFirst();
            if (node.left != null)
                result.addLast(node.left);
            if (node.right != null)
                result.addLast(node.right);

        }

        return result;

    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(22);
        root.right.left = new TreeNode(34);
        root.right.right = new TreeNode(35);
        root.left.right = new TreeNode(31);

        System.out.println(
                Arrays.toString(new m_103_BinaryTreezigzagLevelOrderTraversal().zigzagLevelOrder(root).toArray())
        );


        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(
                Arrays.toString(new m_103_BinaryTreezigzagLevelOrderTraversal().zigzagLevelOrder(root).toArray())
        );


    }
}
