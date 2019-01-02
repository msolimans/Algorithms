package com.g4g.easy;

import java.util.LinkedList;
import java.util.Scanner;


//Determine if Two Trees are Identical (Function Problem)
//Show Topic Tags

/**
 * Trees
 */

/*Description*/
//******************************************************************************************************************
//Given  two  binary trees, your task is to find if both of them are identical or not .

//Input:
//        The task is to complete the method which takes 2 argument, the  roots r1 and r2  of the  Binary Trees. The struct Node has a data part which stores the data,
//        pointer to left child and pointer to right child.

//        There are multiple test cases. For each test case, this method will be called individually.
//
//        Output:
//        The function should return true if both trees are identical else false.
//
//        Constraints:
//        1 <=T<= 30
//        1 <=Number of nodes<= 100
//        1 <=Data of a node<= 1000
//
//        Example:
//        Input
//        2
//        2
//        1 2 L 1 3 R
//        2
//        1 2 L 1 3 R
//        2
//        1 2 L 1 3 R
//        2
//        1 3 L 1 2 R
//
//        Output
//        1
//        0
//
//        In above example there is one  test case which represent two trees with 3 nodes and 2 edges where in first test case both trees are identical having the root as 1,
//        left child of 1 is 2 and right child of 1 is 3 where as in second test case both trees are not identical.
//
//
//        Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only.
//        As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
//******************************************************************************************************************
//Companies: Microsoft, Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1/
//******************************************************************************************************************

public class DetermineIfTwoTreesAreIdentical {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }


    static class BST {
        Node root;

        public BST() {
            root = null;
        }

        public BST(int d) {
            root = new Node(d);
        }

        private void add(Node n, int d) {
            if (d <= n.data) {
                if (n.left == null)
                    n.left = new Node(d);
                else
                    add(n.left, d);
            }

            if(d > n.data){
                if (n.right == null)
                    n.right = new Node(d);
                else
                    add(n.right, d);
            }
        }

        public void add(int d) {
            if (root == null) {
                root = new Node(d);
                return;
            }

            add(root, d);
        }
    }


    //IMPORTANT NOTICE
    //PLEASE NOTE THAT LOCAL TESTING BASED ON BINARY SEARCH TREE, IF YOU WANT TO TEST, PLEASE MAKE SURE TO USE G4G SITE TO TEST ONLY isIdentical()
    //IF YOU WANT TO TEST BASED ON BST, USE FUNCTION NAMED isIdentical1()
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        BST bst1 = new BST();
        BST bst2 = new BST();

        while (T-- > 0) {
            int len = scan.nextInt();
            for(int i=0;i<len;i++)
                bst1.add(scan.nextInt());
            len = scan.nextInt();
            for(int i=0;i<len;i++)
                bst1.add(scan.nextInt());

            System.out.println(isIdentical(bst1.root, bst2.root));
        }
    }

    //these are some test cases
    //3
    //2
    //        1 2 L 1 3 R
    //2
    //        1 2 R 1 3 L
    //2
    //        1 2 L 1 3 R
    //2
    //        1 3 L 1 2 R

    //NON-BST VERSION (CAN BE TEST ONLY IN G4G website)
    //using DFS for any tree, add all nodes in a queue then traverse into the other tree and make dequeue each item you visit a node and make sure both equal
    //it needs more space to be added, check the next solution where we don't need to add a space
    //O(n1+n2) where n1 is number of nodes in list1 and n2 is the number of nodes in list2
    static boolean isIdentical(Node root1, Node root2){

        if(root1.data != root2.data)
            return false;

        LinkedList<Node> lst1 = new LinkedList<>();
        LinkedList<Node> lst2 = new LinkedList<>();

        //DFS based on a stack (remember LIFO, Last-in First-out) instead of queue
        lst1.add(root1);
        lst2.add(root2);

        while (!lst1.isEmpty()){
            Node n1 = lst1.pollLast();
            Node n2 = lst2.pollLast();

            //validate each left/right leaves of each node
            //check if the left node of current visited node from the first tree is exactly the same as left node of the current visited node from the second tree
            if((n1.left != null && n2.left == null) || (n1.left == null && n2.left != null) || (n1.left != null && n2.left != null && n1.left.data != n2.left.data))
                return false;

            //check if the right node of current visited node from the first tree is exactly the same as right node of the current visited node from the second tree
            if((n1.right != null && n2.right == null) || (n1.right == null && n2.right != null) || (n1.right != null && n2.right != null && n1.right.data != n2.right.data))
                return false;

            //add children to the stack for visiting all nodes in the tree
            if(n1.right != null)
                lst1.add(n1.right);

            if(n1.left != null)
                lst1.add(n1.left);

            if(n2.right != null)
                lst2.add(n2.right);
            if(n2.left != null)
                lst2.add(n2.left);

        }

        //validate if any left nodes in lst2 that might be there in lst2 only but not in lst1
        if(!lst2.isEmpty())
            return false;

        return  true;
    }

    //BST VERSION
    // This can be working fine in case it is a correct binary search tree, the question mentioned it is BST however in test cases it is not.
    // Above solution will work fine where I used Depth First Search (DFS)
    /* Should return true if trees with roots as root1 and root2 are identical else false */
    static boolean isIdentical2(Node root1, Node root2)
    {
        //Your code here
        LinkedList<Node> lst1 = new LinkedList<>();
        LinkedList<Node> lst2 = new LinkedList<>();

        lst1.add(root1);
        lst2.add(root2);

        while(!lst1.isEmpty()){

            Node n1 = lst1.pollFirst();
            Node n2 = lst2.pollFirst();

            if(n1.data != n2.data)
                return false;

            ////////////////////////////

            if(n1.left != null)
                lst1.add(n1.left);
            if(n1.right != null)
                lst1.add(n1.right);

            ////////////////////////////

            if(n2.left != null)
                lst2.add(n2.left);
            if(n2.right != null)
                lst2.add(n2.right);

        }

        return lst2.size() <= 0;
    }
}
