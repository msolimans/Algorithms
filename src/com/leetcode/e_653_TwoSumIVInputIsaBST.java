package com.leetcode;

//e_653_TwoSumIVInputIsaBST 
//Show Topic Tags

import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************

//Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
//
//Example 1:
//
//Input:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//Output: True
//
//
//Example 2:
//
//Input:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//Output: False
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//******************************************************************************************************************

public class e_653_TwoSumIVInputIsaBST {


    /////////////////////////

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.insert(new int[]{5, 3, 6, 2, 4, 7});

        System.out.println(new e_653_TwoSumIVInputIsaBST().findTarget(tree.root, 9));

    }

    //make 2 pointers to traverse tree from both sides [bottom to top], everytime add 2 elems, we may have 3 cases:
    // if their sum equals target, return true
    // if their sum less than target, we need to increase so we try the next elem from the left side of the tree
    // if their sum greater than target, we need to decrease so we try the previous element to the current from the right side of tree
    public boolean findTarget(TreeNode root, int k) {
        //go all the way down to the left side of the tree to get the least/minium elem
        upperLimit(root);
        //go all the way down to the right side of the tree to get the max elem
        lowerLimit(root);

        //pop the minimum and the maximum elems from the tree
        TreeNode lower = lowerPop();
        TreeNode upper = upperPop();
        //As long as lower and upper doesn't equal each other, try to find 2 elems, whose their sum equal the target
        while (!lower.equals(upper)) {
            //equal, return true
            if (lower.val + upper.val == k) {
                return true;
            } else if (lower.val + upper.val > k) {//greater than sum, we need to lower down our sum, find the previous elem in the upper side
                upper = upperPop();
            } else {
                lower = lowerPop();//less than sum, we need to lower down our sum, find the previous elem in the lower side
            }

        }

        return false;
    }

    Stack<TreeNode> lower = new Stack<>();
    Stack<TreeNode> upper = new Stack<>();

    TreeNode lowerPop() {
        if (lower.empty())
            return null;
        TreeNode result = lower.pop();
        if (result.right != null) {
            lowerLimit(result.right);
        }
        return result;
    }

    TreeNode upperPop() {
        if (upper.empty())
            return null;
        TreeNode result = upper.pop();
        if (result.left != null) {
            upperLimit(result.left);
        }
        return result;
    }

    void lowerLimit(TreeNode root) {

        lower.push(root);
        TreeNode temp = root;

        //least minimum node
        while (temp.left != null) {
            lower.push(temp.left);
            temp = temp.left;
        }

    }


    void upperLimit(TreeNode root) {

        upper.push(root);
        TreeNode temp = root;

        //least minimum node
        while (temp.right != null) {
            upper.push(temp.right);
            temp = temp.right;
        }

    }


    @Test
    public void TestFindTarget() {
        BSTree tree = new BSTree();
        tree.insert(new int[]{5, 3, 6, 2, 4, 7});

        Assert.assertTrue(findTarget(tree.root, 9));


        tree = new BSTree();

        tree.insert(new int[]{5, 3, 6, 2, 4, 7});

        Assert.assertFalse(findTarget(tree.root, 28));


        tree = new BSTree();
        tree.insert(new int[]{10, 5, 15, 3, 12, 20, 1, 11, 13, 17, 22, 2});

        Assert.assertTrue(findTarget(tree.root, 15));


        tree = new BSTree();
        tree.insert(new int[]{10, 5, 15, 3, 12, 20, 1, 11, 13, 17, 22, 2});

        Assert.assertTrue(findTarget(tree.root, 15));
        Assert.assertTrue(findTarget(tree.root, 21));
        Assert.assertTrue(findTarget(tree.root, 12));
        Assert.assertTrue(findTarget(tree.root, 18));
        Assert.assertTrue(findTarget(tree.root, 7));
        Assert.assertTrue(findTarget(tree.root, 30));
        Assert.assertTrue(findTarget(tree.root, 42));
        Assert.assertTrue(findTarget(tree.root, 29));
        Assert.assertFalse(findTarget(tree.root, 100));
        Assert.assertFalse(findTarget(tree.root, 0));

        tree = new BSTree(10);
        Assert.assertEquals(false, findTarget(tree.root, 10));


        tree = new BSTree(10);
        tree.insert(new int[]{-2, 15, -3, -1, 12, 20, 11, 13, 17, 22});
        Assert.assertTrue(findTarget(tree.root, -4));
        Assert.assertTrue(findTarget(tree.root, -3));
        Assert.assertTrue(findTarget(tree.root, 10));
        Assert.assertTrue(findTarget(tree.root, 11));
        Assert.assertTrue(findTarget(tree.root, 20));


    }

}
