package com.leetcode;

//e_993_CousinsinBinaryTree 
//Show Topic Tags

import com.leetcode.shared.*;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 */

/*Description*/
//******************************************************************************************************************
//In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//
//Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//
//We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
//Return true if and only if the nodes corresponding to the values x and y are cousins.
//
//
//
//Example 1:
//
//
//Input: root = [1,2,3,4], x = 4, y = 3
//Output: false
//Example 2:
//
//
//Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//Output: true
//Example 3:
//
//
//
//Input: root = [1,2,3,null,4], x = 2, y = 3
//Output: false
//
//
//Note:
//
//The number of nodes in the tree will be between 2 and 100.
//Each node has a unique integer value from 1 to 100.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/cousins-in-binary-tree/
//******************************************************************************************************************

public class e_993_CousinsinBinaryTree {


    public static void main(String[] args) throws Exception {

        System.out.println(new e_993_CousinsinBinaryTree().isCousins(new BSTree(new int[]{5, 3, 2, 4, 7, 6, 8}).root, 2, 6));

    }

    //vars to store depth and parent of x and y
    private int xdepth;
    private int xparent;
    private int ydepth;
    private int yparent;

    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(null, root, 0, x, y);

        return xdepth != 0 && ydepth != 0 && xdepth == ydepth && xparent != yparent;
    }

    //normal traversal, visit the node and then visit its left and right children, every time we pass parent and increase depth level
    public void traverse(TreeNode parent, TreeNode node, int depth, int x, int y) {
        if (node == null)
            return;

        //we can store only x and y instead of storing all elems but in the question it was 100 nodes
        //we store here node's val n hashmap with its depth and parent's val
        if (node.val == x) {
            xdepth = depth;
            xparent = parent == null? 0: parent.val;
        }
        if (node.val == y) {
            ydepth = depth;
            yparent = parent == null? 0: parent.val;
        }

        traverse(node, node.left, depth + 1, x, y);
        traverse(node, node.right, depth + 1, x, y);
    }
    @Test
    public void TestIsCousins() {
        Assert.assertEquals(true, isCousins(new BSTree(new int[]{5, 3, 2, 4, 7, 6, 8}).root, 2, 6));
        Assert.assertEquals(false, isCousins(new BSTree(new int[]{5, 3, 2, 4, 7, 6, 8}).root, 2, 4));
    }


//    void bfs(Queue<TreeNode> queue) throws Exception {
//        if (queue.empty())
//            return;
//
//        TreeNode node = queue.dequeue();
//        System.out.println(node.val);
//        if (node.left != null)
//            queue.enqueue(node.left);
//
//        if (node.right != null)
//            queue.enqueue(node.right);
//
//        bfs(queue);
//    }


}
