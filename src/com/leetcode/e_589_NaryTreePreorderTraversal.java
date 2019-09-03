package com.leetcode;

//e_589_NaryTreePreorderTraversal 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an n-ary tree, return the preorder traversal of its nodes' values.
//
//For example, given a 3-ary tree:
//                      1
//                    / | \
//                   3  2  4
//                  / \
//                 5   6
//
//Return its preorder traversal as: [1,3,5,6,2,4].
//
//
//
//Note:
//
//Recursive solution is trivial, could you do it iteratively?

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
//******************************************************************************************************************

//used for N-ary Tree
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class e_589_NaryTreePreorderTraversal {

    static List<Node> ns2nd;

    //{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
    static {
        List<Node> ns3rd = new ArrayList<>();
        ns3rd.add(new Node(5));
        ns3rd.add(new Node(6));


        ns2nd = new ArrayList<>();
        ns2nd.add(new Node(3, ns3rd));
        ns2nd.add(new Node(2));
        ns2nd.add(new Node(4));

    }

    public static void main(String[] args) {
        System.out.println(new e_589_NaryTreePreorderTraversal().preorder(new Node(1, ns2nd)));
    }


    //always use stack or recursion for preorder traversal
    public List<Integer> preorder(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            Node n = stack.pop();

            result.add(n.val);

            if (n.children != null) {
                //we need to reverse list here, why?
                // lets recall stack is a last in first out so if we put children in order we will get the right nodes first before the left side
                //     1
                //   2   3
                //if we don't reverse we will end up with 1 3 2 .. if we reverse => 1 2 3
                Collections.reverse(n.children);
                for (Node c : n.children) {
                    stack.push(c);
                }
            }
        }

        return result;
    }


    //a recursive solution
    public List<Integer> preorder2(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        //result=current node + its children
        result.add(root.val);

        //check if we children
        if (root.children != null)
            //if so, loop thru them and recursively call the same function
            for (Node node : root.children) {
                result.addAll(preorder(node));
            }

        return result;
    }

    @Test
    public void Testpreorder() {

        //preorder2 was intentionally added at first as preorder changes the original data itself [reverse children]
        Assert.assertArrayEquals(new Object[]{1, 3, 5, 6, 2, 4}, preorder2(new Node(1, ns2nd)).toArray());
        Assert.assertArrayEquals(new Object[]{1}, preorder2(new Node(1)).toArray());
        Assert.assertArrayEquals(new Object[]{}, preorder2(null).toArray());

        Assert.assertArrayEquals(new Object[]{1, 3, 5, 6, 2, 4}, preorder(new Node(1, ns2nd)).toArray());
        Assert.assertArrayEquals(new Object[]{1}, preorder(new Node(1)).toArray());
        Assert.assertArrayEquals(new Object[]{}, preorder(null).toArray());

    }



}
