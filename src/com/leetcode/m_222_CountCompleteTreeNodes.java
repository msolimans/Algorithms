package com.leetcode;


//222. Count Complete Tree Nodes
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a complete binary tree, count the number of nodes.
//
//Note:
//
//Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//
//Example:
//
//Input:
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//Output: 6
//******************************************************************************************************************
//Companies: VMWare, Oracle
//******************************************************************************************************************
//Link: https://leetcode.com/problems/count-complete-tree-nodes/
//******************************************************************************************************************


public class m_222_CountCompleteTreeNodes {


    //very similar to heap impl
    class Tree {
        private TreeNode[] arr;
        TreeNode root;
        int index = 1;

        Tree(int size) {
            arr = new TreeNode[size + 1]; //+1 bcs we skip 0 for simplicity
        }

        void insert(int val) throws Exception {
            if (index > arr.length - 1) {
                throw new Exception("Exceeded initial size of tree");
            }

            if (root == null) {
                root = new TreeNode(val);
                arr[index++] = root;
                return;
            }

            TreeNode node = new TreeNode(val);

            if (index % 2 == 0) {//even
                //left side of parent
                arr[index / 2].left = node;
            } else {
                arr[index / 2].right = node;
            }

            arr[index++] = node;

        }
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {

    }

    //O(n) using traversal
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //BFS
        int count = 0;

        while (queue.size() > 0) {
            TreeNode node = queue.pollFirst();
            //visit
            count++;
            //traverse
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add((node.right));
            }
        }

        return count;

    }


    @Test
    public void countNodes() throws Exception {

        Tree tree = new Tree(6);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);


        //Also we can make it like this
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);

        Assert.assertEquals(6, countNodes(tree.root));

    }

}
