package com.leetcode;

//m_199_BinaryTreeRightSideView 
//Show Topic Tags

import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//Example:
//
//Input: [1,2,3,null,5,null,4]
//Output: [1, 3, 4]
//Explanation:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---

//******************************************************************************************************************
//Companies: Facebook | 25  Amazon | 6  Bloomberg | 4  ByteDance | 3
//******************************************************************************************************************
//Link: https://leetcode.com/problems/binary-tree-right-side-view/
//******************************************************************************************************************

public class m_199_BinaryTreeRightSideView {


    public static void main(String[] args) {

        m_199_BinaryTreeRightSideView sol = new m_199_BinaryTreeRightSideView();

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(20);
        root2.right = new TreeNode(30);
        root2.left.right = new TreeNode(40);

        System.out.println(Arrays.toString(sol.rightSideView(root2).toArray(new Integer[0])));
        System.out.println(Arrays.toString(sol.rightSideView(root2.left).toArray(new Integer[0])));
        System.out.println(Arrays.toString(sol.rightSideView(root2.right).toArray(new Integer[0])));
        System.out.println(Arrays.toString(sol.rightSideView(new TreeNode(30)).toArray(new Integer[0])));


        System.out.println("----------------------------------------------------------------");
        System.out.println(Arrays.toString(sol.rightSideView2(root2).toArray(new Integer[0])));
        System.out.println(Arrays.toString(sol.rightSideView2(root2.left).toArray(new Integer[0])));
        System.out.println(Arrays.toString(sol.rightSideView2(root2.right).toArray(new Integer[0])));
        System.out.println(Arrays.toString(sol.rightSideView2(new TreeNode(30)).toArray(new Integer[0])));


    }


    //level order traversal, BFS from right to left
    //every time we record or store the first node in the queue and drop off all others [we care about recording all children of other nodes though]
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        return rightSideView(q);

    }


    List<Integer> rightSideView(Queue<TreeNode> queue) {
        //if we have empty queue, stop traversal
        if (queue == null || queue.isEmpty())
            return null;

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> nextToVisit = new LinkedList<>();

        //first one, add it to result
        res.add(queue.peek().val);

        //extract all children and save into nextToVisit
        getLevelNodes(queue, nextToVisit);

        //continue traversal, pass all children of current level
        List<Integer> ires = rightSideView(nextToVisit);
        //if inner result is null, don't add it. this handles the leaves with no children
        if (ires != null)
            res.addAll(ires);

        //return final res
        return res;
    }

    //get children of current level, store them into queue [from right to left]
    void getLevelNodes(Queue<TreeNode> nodes, Queue<TreeNode> nextToVisit) {

        if (nodes == null)
            return;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();

            if (node == null)
                continue;

            if (node.right != null)
                nextToVisit.add(node.right);
            if (node.left != null)
                nextToVisit.add(node.left);
        }


    }


    @Test
    public void TestRightSideView() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        Assert.assertArrayEquals(new Integer[]{1, 3, 4}, rightSideView(root).toArray(new Integer[0]));


        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(20);
        root2.right = new TreeNode(30);
        root2.left.right = new TreeNode(40);
        Assert.assertArrayEquals(new Integer[]{2, 30, 40}, rightSideView(root2).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{20, 40}, rightSideView(root2.left).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{30}, rightSideView(root2.right).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{30}, rightSideView(new TreeNode(30)).toArray(new Integer[0]));

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //2nd Solution, using DFS with level monitoring
    //if current level is greater than result size, that means we started to visited a new level.
    //remember, the first time we visit a new level we have the right most node
    public List<Integer> rightSideView2(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        //pass current level [first level]
        rightSideView2(root, res, 1);
        return res;
    }


    void rightSideView2(TreeNode node, List<Integer> res, int level) {
        if (node == null)
            return;
        //if current level is greater than res size, we started a new level now
        if (level > res.size())
            res.add(node.val);

        //we visit right side first [to make sure we visit the right view first. In case it's null, continue to visit left side
        rightSideView2(node.right, res, level + 1);
        //then we visit left subtree
        rightSideView2(node.left, res, level + 1);
    }

    @Test
    public void TestRightSideView2() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        Assert.assertArrayEquals(new Integer[]{1, 3, 4}, rightSideView2(root).toArray(new Integer[0]));


        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(20);
        root2.right = new TreeNode(30);
        root2.left.right = new TreeNode(40);
        Assert.assertArrayEquals(new Integer[]{2, 30, 40}, rightSideView2(root2).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{20, 40}, rightSideView2(root2.left).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{30}, rightSideView2(root2.right).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{30}, rightSideView2(new TreeNode(30)).toArray(new Integer[0]));

    }


}
