package com.leetcode;

//m_102_BinaryTreeLevelOrderTraversal 
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
//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link:
//******************************************************************************************************************

public class m_102_BinaryTreeLevelOrderTraversal {


    public static void main(String[] args) {
        List<List<Integer>> res = new m_102_BinaryTreeLevelOrderTraversal().levelOrder(new BSTree(new int[]{2, 2, 5, 1, 3, 7, 9}).root);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        //queue to make them in order
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        level(queue, res);
        return res;

    }

    void level(Queue<TreeNode> queue, List<List<Integer>> result) {

        //if queue is empty return
        if (queue.isEmpty())
            return;

        //stores children of current list
        Queue<TreeNode> childs = new LinkedList<>();
        //adds up to level results list
        List<Integer> lresult = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null)
                continue;

            if (node.left != null)
                childs.add(node.left);
            if (node.right != null)
                childs.add(node.right);

            //add current node's val to level result
            lresult.add(node.val);
        }

        //add level result to result
        result.add(lresult);
        level(childs, result);

    }


    @Test
    public void TestLevelOrder() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Collections.singletonList(2)));
        list.add(new ArrayList<>(Arrays.asList(1, 2)));
        list.add(new ArrayList<>(Arrays.asList(5)));
        list.add(new ArrayList<>(Arrays.asList(3, 7)));
        list.add(new ArrayList<>(Collections.singletonList(9)));

        List<List<Integer>> res = levelOrder(new BSTree(new int[]{2, 2, 5, 1, 3, 7, 9}).root);

        Assert.assertArrayEquals(list.toArray(), res.toArray());
    }

}
