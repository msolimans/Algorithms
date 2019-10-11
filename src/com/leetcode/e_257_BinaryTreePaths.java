package com.leetcode;

//e_257_BinaryTreePaths 
//Show Topic Tags


import com.leetcode.shared.BSTree;
import com.leetcode.shared.TreeNode;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a binary tree, return all root-to-leaf paths.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/binary-tree-paths/
//******************************************************************************************************************

public class e_257_BinaryTreePaths {


    public static void main(String[] args) {

        System.out.println(new e_257_BinaryTreePaths().binaryTreePaths(new BSTree(new int[]{4,3,5,6}).root));

    }

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        //queue to make inorder traversal [level by level]
        Queue<Pair<TreeNode, String>> q = new LinkedList<>();
        List<String> result = new ArrayList<>();

        q.add(new Pair<>(root, (Integer.toString(root.val))));

        while (!q.isEmpty()) {
            //visit node
            Pair<TreeNode, String> pair = q.poll();

            //left subtree, collect current str value
            if (pair.getKey().left != null) {
                q.add(new Pair<>(pair.getKey().left, pair.getValue() + "->" + pair.getKey().left.val));
            }

            //right subtree
            if (pair.getKey().right != null) {
                q.add(new Pair<>(pair.getKey().right, pair.getValue() + "->" + pair.getKey().right.val));
            }


            //if we're at leaf level, add it to the result
            if (pair.getKey().left == null && pair.getKey().right == null) {
                result.add(pair.getValue());
            }

        }

        return result;

    }

    @Test
    public void TestbinaryTreePaths() {
        Assert.assertEquals(new ArrayList<>(), binaryTreePaths(new BSTree(new int[]{}).root));
        Assert.assertEquals(Arrays.asList("4->1", "4->5"), binaryTreePaths(new BSTree(new int[]{4, 5, 1}).root));
    }

}
