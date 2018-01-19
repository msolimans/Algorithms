package com.leetcode.test;

//e_669_TrimBinarySearchTreeTest

import com.leetcode.e_669_TrimABinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

public class e_669_TrimBinarySearchTreeTest {


    @Test
    public void trimTree(){
        e_669_TrimABinarySearchTree solution = new e_669_TrimABinarySearchTree();

        solution.addToRoot(1);
        solution.addToRoot(0);
        solution.addToRoot(2);


        solution.trimBST(solution.root, 1,2);

        e_669_TrimABinarySearchTree.TreeNode expected = new e_669_TrimABinarySearchTree.TreeNode(1);
        expected.right = new e_669_TrimABinarySearchTree.TreeNode(2);

        Assert.assertEquals("Not the same, result should be [1 2]", "1 2", solution.printResult());


        solution = new e_669_TrimABinarySearchTree();

        solution.addToRoot(3);
        solution.addToRoot(0);
        solution.addToRoot(4);
        solution.addToRoot(2);
        solution.addToRoot(1);
        solution.trimBST(solution.root, 1,3);
        Assert.assertEquals("Not the same", "3 2 1", solution.printResult());



    }

}
