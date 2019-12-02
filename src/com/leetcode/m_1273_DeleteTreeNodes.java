package com.leetcode;

//m_1273_DeleteTreeNodes 
//Show Topic Tags

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dynamic Programming, DFS
 */

/*Description*/
//******************************************************************************************************************
//A tree rooted at node 0 is given as follows:
//
//The number of nodes is nodes;
//The value of the i-th node is value[i];
//The parent of the i-th node is parent[i].
//Remove every subtree whose sum of values of nodes is zero.
//
//After doing so, return the number of nodes remaining in the tree.
//
//
//
//Example 1:
//             0 (1)
//           /   \
//          1     2
//         /    / | \
//        3    4  5  6
//
//Input: nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
//Output: 2
//
//
//Constraints:
//
//1 <= nodes <= 10^4
//-10^5 <= value[i] <= 10^5
//parent.length == nodes
//parent[0] == -1 which indicates that 0 is the root.

//******************************************************************************************************************
//Companies: Microsoft
//******************************************************************************************************************
//Link: https://leetcode.com/problems/delete-tree-nodes/
//******************************************************************************************************************

public class m_1273_DeleteTreeNodes {


    public static void main(String[] args) {


    }

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        //sums of all children that are non-zero at index i
        int[] childs = new int[value.length];

        for (int i = parent.length - 1; i > 0; i--) {


            if (value[i] == 0)
                continue;

            //if current value at index i is not zero, means we should include IT (1) + and its children (child[i])
            //get parent index of current node
            int parentIndex = parent[i];

            childs[parentIndex] += childs[i] + 1;

            //add current value to parent for subsequent calcs
            value[parentIndex] += value[i];

        }

        //if children's count under root is not zero, don't forget to count root as well
        if (value[0] != 0)
            return 1 + childs[0];

        return 0;
    }



    //DFS solution
    //count of parent = 1 [in case it is total > zero] + count of all children
    //recursively count the valid children until we reach base case where no children [in this case count them in case they're not null]
    public int deleteTreeNodes2(int nodes, int[] parent, int[] value) {
        //represent only parents in list with their children as [indices in values]
        //2 -> ith index of all children of parent p
        Map<Integer, List<Integer>> parents = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            List<Integer> lst = parents.getOrDefault(parent[i], new ArrayList<>());
            lst.add(i);
            parents.putIfAbsent(parent[i], lst);
        }

        //start with root at index 0
        return getCount(parents, value, 0).getValue();


    }

    //returns sum and count of valid children
    //2nd Solution, DFS sum and count all sub-nodes .. if total is zero return in count
    Pair<Integer, Integer> getCount(Map<Integer, List<Integer>> map, int[] value, int i) {

        //add current value of p's index
        int total = value[i];
        int count = 1;

        //base case .. no children, return total and count
        if (map.get(i) == null) {
            return new Pair<>(total, total == 0 ? 0 : count);
        }

        //loop thru all children and calc
        for (int child : map.get(i)) {
            //get count of valid childs of every child under parent p
            Pair<Integer, Integer> childs = getCount(map, value, child);

            //add sum of child to current parent's total
            total += childs.getKey();

            //if child's total not zero, add its count otherwise don't add anything
            if (childs.getKey() != 0)
                count += childs.getValue();
        }

        //return parent's total and count, bubbles up to root to return valid count
        return new Pair<>(total, total == 0 ? 0 : count);
    }


    @Test
    public void TestDeleteTreeNodes() {
        Assert.assertEquals(6, deleteTreeNodes(7, new int[]{-1, 0, 0, 1, 2, 2, 2}, new int[]{1, -2, 4, 0, -2, -1, -2}));
        Assert.assertEquals(2, deleteTreeNodes(7, new int[]{-1, 0, 0, 1, 2, 2, 2}, new int[]{1, -2, 4, 0, -2, -1, -1}));
        Assert.assertEquals(0, deleteTreeNodes(7, new int[]{-1, 0, 0, 1, 2, 2, 2}, new int[]{1, -2, 4, 1, -2, -1, -1}));
        Assert.assertEquals(0, deleteTreeNodes(2, new int[]{-1, 0}, new int[]{1, -1}));
        Assert.assertEquals(1, deleteTreeNodes(1, new int[]{-1}, new int[]{1}));

        ///////

        Assert.assertEquals(6, deleteTreeNodes2(7, new int[]{-1, 0, 0, 1, 2, 2, 2}, new int[]{1, -2, 4, 0, -2, -1, -2}));
        Assert.assertEquals(2, deleteTreeNodes2(7, new int[]{-1, 0, 0, 1, 2, 2, 2}, new int[]{1, -2, 4, 0, -2, -1, -1}));
        Assert.assertEquals(1, deleteTreeNodes2(1, new int[]{-1}, new int[]{1}));
        Assert.assertEquals(0, deleteTreeNodes2(2, new int[]{-1, 0}, new int[]{1, -1}));
    }

}
