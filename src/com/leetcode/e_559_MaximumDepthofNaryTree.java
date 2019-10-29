package com.leetcode;

//e_559_MaximumDepthofNaryTree 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a n-ary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//For example, given a 3-ary tree:
//
//              1
//             /|\
//            3 2 4
//           / \
//          5   6
//We should return its max depth, which is 3.
//
//Note:
//
//The depth of the tree is at most 1000.
//The total number of nodes is at most 5000.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
//******************************************************************************************************************

public class e_559_MaximumDepthofNaryTree {


    public static void main(String[] args) {


    }


    public int maxDepth(Node root) {

        //if root is null, return 0
        if (root == null )
            return 0;


        //if there's no children [null] or children array is empty, return 1 [which includes current node "root"]
        if(root.children == null || root.children.size() == 0)
            return 1;


        //preserve up to date 'max'
        int max = 0;

        for (Node n : root.children) {
            //loop thru children n get max depth for each node [add 1 "current node"]
            int branch = 1 + maxDepth(n);

            //check if size of branch is greater than max, update max
            if (branch > max)
                max = branch;
        }

        return max;
    }


    @Test
    public void TestMaxDepth() {

        Node n1 = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node root = new Node(1, Arrays.asList(n1, new Node(2), new Node(4)));
        int result =  maxDepth(root);
        Assert.assertEquals(3,result);

        root = null;

        Assert.assertEquals(0, maxDepth(root));

    }


}
