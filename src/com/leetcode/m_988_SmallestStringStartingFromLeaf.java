package com.leetcode;

//m_988_SmallestStringStartingFromLeaf 
//Show Topic Tags


import com.leetcode.shared.TreeNode;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
//
//Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
//
//(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
//
//
//
//Example 1:
//      a
//    /   \
//  b       c
// /  \    /  \
//d    e  d    d

//Input: [0,1,2,3,4,3,4]
//Output: "dba"
//Example 2:
//      z
//    /   \
//   b      d
// /  \    /  \
//b    d  a    c
//Input: [25,1,3,1,3,0,2]
//Output: "adz"
//Example 3:
//      c
//    /   \
//  c       b
//   \     /
//    b   a
//   /
//  a
//Input: [2,2,1,null,1,0,null,0]
//Output: "abc"
//
//
//Note:
//
//The number of nodes in the given tree will be between 1 and 8500.
//Each node in the tree will have a value between 0 and 25.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/smallest-string-starting-from-leaf/
//******************************************************************************************************************

public class m_988_SmallestStringStartingFromLeaf {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);


        System.out.println(new m_988_SmallestStringStartingFromLeaf().smallestFromLeaf(root));


    }

    //inorder traversal and update the smallest
    public String smallestFromLeaf(TreeNode root) {

        if (root == null) {
            return "";
        }

        String min = "~";
        Queue<Pair<TreeNode, String>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, Character.toString((char) ('a' + root.val))));

        while (!queue.isEmpty()) {
            Pair<TreeNode, String> p = queue.poll();
            if (p.getKey().left != null)
                queue.add(new Pair<>(p.getKey().left, (char) ('a' + p.getKey().left.val) + p.getValue()));

            if (p.getKey().right != null)
                queue.add(new Pair<>(p.getKey().right, (char) ('a' + p.getKey().right.val) + p.getValue()));

            if (p.getKey().left == null && p.getKey().right == null) {
                if (p.getValue().compareTo(min) < 0)
                    min = p.getValue();
            }

        }

        return min;


    }


    //recursive way
    public String smallestFromLeaf1(TreeNode root) {

        return smallestFromLeaf1(root, "");
    }

    String min = "~";

    //recursive way
    public String smallestFromLeaf1(TreeNode root, String prev) {

        //smallestFromLeaf1(root.left);
        return "";
    }

    @Test
    public void TestsmallestFromLeaf() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        Assert.assertEquals("dba", smallestFromLeaf(root));


        root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);

        Assert.assertEquals("adz", smallestFromLeaf(root));

        root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);

        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.left.right.left = new TreeNode(0);

        Assert.assertEquals("abc", smallestFromLeaf(root));

        root = new TreeNode(0);
        Assert.assertEquals("a", smallestFromLeaf(root));

        root = null;
        Assert.assertEquals("", smallestFromLeaf(root));
    }

}
