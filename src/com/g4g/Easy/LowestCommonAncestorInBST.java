package com.g4g.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//Lowest Common Ancestor in a BST (Function Problem)
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a Binary Search Tree and 2 nodes value n1 and n2  , your task is to find the lowest common ancestor of the two nodes . You are required to complete the function LCA . You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.

//Input:
//        The task is to complete the method LCA which takes 3 arguments, root of the Tree and two nodes value  n1 and n2 . The struct node has a data part which stores the data, pointer to left child and pointer to right child.
//        There are multiple test cases. For each test case, this method will be called individually.
//
//        Output:
//        The function should return the node which is the least common ancestor of the two nodes n1 and n2 .
//
//        Constraints:
//        1 <=T<= 100
//        1 <=Number of nodes<= 100
//        1 <=Data of a node<= 1000
//
//        Example:
//
//        Input
//        1
//        6
//        5 4 6 3 7 8
//        7 8
//
//        Output
//        7
//
//        Explanation
//        The BST in above test case will look like
//
//         5
//        /  \
//       4    6
//      /      \
//     3        7
//               \
//                8
//        here the LCA of 7 and 8 is 7 .
//
//
//        Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
//******************************************************************************************************************
//Companies: VMWare, Oracle
//******************************************************************************************************************
//Link:http://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
//******************************************************************************************************************
class Node{
    int data;
    Node left;
    Node right;

    public Node(int d){
        this.data = d;
        left = right = null;
    }
}
class BST{
    Node root;
    BST(Node r){
        root = r;
    }

    BST(){
        root = null;
    }
    void add(Node n, int d){
        if(d <= n.data) {
            if(n.left == null)
                n.left = new Node(d);
            else
                add(n.left, d);
        }else{
            if(n.right == null)
                n.right = new Node(d);
            else
                add(n.right, d);
        }

    }


    public void add(int d){
        if(root == null)
        {
            root = new Node(d);
            return;
        }

        add(root, d);
    }

    public void print(){
        print(root);
    }
    void print(Node n){
        if(n == null)
            return;
        System.out.println(n.data);
        print(n.left);
        print(n.right);
    }
}
//All code above was just added to make it workable in local environment only
public class LowestCommonAncestorInBST {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            BST bst = new BST();

            int len = scan.nextInt();
            for(int i=0;i<len;i++){
                bst.add(scan.nextInt());
            }


            bst.print();

            int n1= scan.nextInt();
            int n2 = scan.nextInt();
            System.out.println(lca(bst.root, n1,n2));
        }
    }

    static boolean traverseToNode(Node node, int n, int level, Map<Integer, Node> path){
        //stopping conditions
        //search exhausted without finding the element/item.
        if(node == null)
            return false;
        //search finished, once item found, save it and stop recursion
        if(node.data == n){
            path.put(level, node);
            return  true;
        }

        path.put(level, node);
        //traverse to the left in case the value is LESS than the current node's value
        if(n < node.data)
            return traverseToNode(node.left, n, ++level, path);
        else
            //traverse to the right in case the value is GREATER  than the current node's value
            return traverseToNode(node.right, n, ++level, path);

    }

    //get the common ancestor algorithm here
    static int findCommonAncestor(Map<Integer, Node> p1, Map<Integer, Node> p2){
        //make sure always p1 is smaller in size (performance)
        if(p1.size() > p2.size())
            return  findCommonAncestor(p2,p1);

        int max = -1;
        for(int l: p1.keySet()){
            if(l > max && p2.containsKey(l)){
                max = l;
            }
        }

        return max;
    }

    //just copy the following code to make it workable in g4g
    static Node lca(Node node, int n1, int n2)
    {
        //Search for the first item (n1)
        //Store its path, each time you visit a node store the level along with Node value.
        Map<Integer, Node> n1Path = new HashMap<>();
        traverseToNode(node, n1, 0, n1Path);

        //Search for the second item (n2)
        Map<Integer, Node> n2Path = new HashMap<>();
        traverseToNode(node, n2, 0, n2Path);


        //find the highest common level now is the intersection in-between both nodes (n1,n2)
        int level = findCommonAncestor(n1Path, n2Path);
        //get it from any of the stored paths
        return n1Path.get(level);

        //can be simplified to
        //return n1Path.get(findCommonAncestor(n1Path, n2Path));
    }
}
