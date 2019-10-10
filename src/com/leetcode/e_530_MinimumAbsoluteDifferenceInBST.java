package com.leetcode;

//e_530_MinimumAbsoluteDifferenceInBST 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************


//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_530_MinimumAbsoluteDifferenceInBST {


    public static void main(String[] args) {
        System.out.println(new e_530_MinimumAbsoluteDifferenceInBST().getMinimumDifference(new BSTree(new int[]{4, 5, 7}).root));
    }


    //keep the minimal value in the result
    int result = Integer.MAX_VALUE;
    //prev is the previous node to the current one in the recursion
    int prev = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        //visit left subtree
        if (root.left != null)
            getMinimumDifference(root.left);


        //assign result to min of (result or current's val - prev)
        result = Math.min(result, Math.abs(root.val - prev));

        //assign prev to current
        prev = root.val;

        //visit right subtree
        if (root.right != null)
            getMinimumDifference(root.right);

        return result;
    }

    @Test
    public void TestgetMinimumDifference() {

        Assert.assertEquals(1, getMinimumDifference(new BSTree(new int[]{1, 3, 2}).root));
        Assert.assertEquals(1, getMinimumDifference(new BSTree(new int[]{5, 4, 7}).root));
    }
}
