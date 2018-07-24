package com.leetcode.test;

import com.leetcode.m_515_FindLargestValueInEachTreeRow;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by msoliman on 1/19/18.
 */
public class m_515_FindLargestValueInEachTreeRowTest {

    @Test
    public void largestValues(){
        m_515_FindLargestValueInEachTreeRow solution = new m_515_FindLargestValueInEachTreeRow();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        Assert.assertArrayEquals(new Object[]{1,3,9}, solution.largestValues(root).toArray());

        //add more test cases here
    }
}
