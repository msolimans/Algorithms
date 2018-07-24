package com.leetcode;

//m_515_FindLargestValueInEachTreeRow
//Show Topic Tags

import com.alkhawarizms.DataStructure.Trees.Tree;
import com.leetcode.shared.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Trees, BFS
 */

/*Description*/
//******************************************************************************************************************
//You need to find the largest value in each row of a binary tree.
//
//        Example:
//        Input:
//
//         1
//        / \
//       3   2
//      / \   \
//     5   3   9
//
//     Output: [1, 3, 9]


//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
//******************************************************************************************************************

public class m_515_FindLargestValueInEachTreeRow {

        //should return all nodes in the next level with max value of current level
        Pair<Integer, List<TreeNode>> largestValue(List<TreeNode> level){

            int result = Integer.MIN_VALUE;
            List<TreeNode> nodes = new ArrayList<>();

            for(TreeNode node: level){
                if(result < node.val)
                    result = node.val;

                if(node.left != null)
                    nodes.add(node.left);
                if(node.right != null)
                    nodes.add(node.right);
            }

            return new Pair<>(result, nodes);
        }

        public List<Integer> largestValues(TreeNode root) {


            List<Integer> result = new ArrayList<>();

            if(root == null)
                return result;

            List<TreeNode> level = new ArrayList<>();
            level.add(root);

            while(level != null && level.size() > 0){
                //travers e
                Pair<Integer, List<TreeNode>> levelResult = largestValue(level);

                if(levelResult != null)
                    result.add(levelResult.getKey());

                level = levelResult == null?null:levelResult.getValue();

            }

            return result;

        }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);



        System.out.println(Arrays.toString(new m_515_FindLargestValueInEachTreeRow().largestValues(root).toArray()));


    }
}
