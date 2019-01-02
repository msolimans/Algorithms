package com.ocw.c6006.lect5;

import java.util.LinkedList;

public class RunwayTimesInBST {
    //In this lecture 2 operations were discussed, insert and how many landings before time T
    //in this class, an implementation to those functions based on Binary Search Tree (BST)

    public static  void  main(String[] args){
        RunwayTimesInBST runwayTimesInBST = new RunwayTimesInBST();
        runwayTimesInBST.insert(49);
        runwayTimesInBST.insert(79);
        runwayTimesInBST.insert(46);
        runwayTimesInBST.insert(43);
        runwayTimesInBST.insert(64);
        runwayTimesInBST.insert(83);

        runwayTimesInBST.print();

    }

    //Breadth First Traversal to print it
    void print(){
        if(root == null)
            return;

        LinkedList lst = new LinkedList<BSTNode>();

        lst.add(root);
        while(!lst.isEmpty()){
            BSTNode node = (BSTNode)lst.pollFirst();
            System.out.println(node.value);
            if(node.left != null);
                lst.add(node.left);
            if(node.right != null)
                lst.add(node.right);

        }
    }

    //in order traversal
    void sortedprint(){
        sortedprint(root);
    }

    void sortedprint(BSTNode node){
        if(node == null)
            return;

        sortedprint(node.left);
        System.out.println(node.value);
        sortedprint(node.right);

    }



    //BST node represntation
    class BSTNode{
        int value;
        BSTNode left;
        BSTNode right;
        BSTNode parent;

        public BSTNode(int t){
            this.value = t;
        }
    }


    BSTNode root;
    final int k = 3;

    public boolean insert(int t){

        if(root == null) {
            //initialize root node for the first call
            root = new BSTNode(t);
            return true;
        }
        return insert(root, t);
    }

    private boolean insert(BSTNode node, int t){


        //violation check of K time offset (if difference is less than K)
        if(Math.abs(root.value - t) < k)
            return  false;

        //find its location
        //check whether the inserted value is less than the current node's value. if so go left
        if(t <= node.value)
            if(node.left == null) {
                node.left = new BSTNode(t);
                return true;
            }
            else
                return insert(node.left, t);
         //the inserted value is greater than the current node's value. go right
        else
            if(node.right == null) {
                node.right = new BSTNode(t);
                return  true;
            }
            else
                return insert(node.right, t);

    }


}
