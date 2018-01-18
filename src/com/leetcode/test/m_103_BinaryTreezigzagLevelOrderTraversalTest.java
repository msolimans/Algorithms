package com.leetcode.test;

import com.leetcode.m_103_BinaryTreezigzagLevelOrderTraversal;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by msoliman on 1/17/18.
 */
public class m_103_BinaryTreezigzagLevelOrderTraversalTest {

    @Test
    public void zigzagLevelOrder(){

        //test case 1
        m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode root = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(10);
        root.left = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(20);
        root.right = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(22);
        root.right.left  = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(34);
        root.right.right  = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(35);
        root.left.right  = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(31);

        int[][] exp = new int[][]{{10},{22,20}, {31,34,35}};

        Assert.assertEquals(Arrays.deepToString(exp),
         Arrays.deepToString(new m_103_BinaryTreezigzagLevelOrderTraversal().zigzagLevelOrder(root).toArray())
        );



        //test case 2


        root = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(3);
        root.left = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(9);
        root.right = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(20);
        root.right.left  = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(15);
        root.right.right  = new m_103_BinaryTreezigzagLevelOrderTraversal.TreeNode(7);




        Assert.assertEquals(Arrays.deepToString(new int[][]{{3},{20,9}, {15,7}}),
                Arrays.deepToString(new m_103_BinaryTreezigzagLevelOrderTraversal().zigzagLevelOrder(root).toArray())
        );

        //add your test cases here


    }
}
