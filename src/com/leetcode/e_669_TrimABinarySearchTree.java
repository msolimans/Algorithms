package com.leetcode;

//e_669_TrimABinarySearchTree
//Show Topic Tags


import java.util.LinkedList;

/**
 * Binary Tree
 */

/*Description*/
//******************************************************************************************************************


//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link:
//******************************************************************************************************************

public class e_669_TrimABinarySearchTree {


    //This section only used for supporting my tests
    //Supportive code only (not part of solution)
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public  TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public e_669_TrimABinarySearchTree(){
        root = null;
    }

    public TreeNode root = null;

    public  void addToRoot(int val){
        if(root == null)
        {
            root = new TreeNode(val);
            return;
        }

        add(root, val);

    }

     public String printResult(){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(result);
        StringBuilder builder = new StringBuilder();

        while(!queue.isEmpty()){
            TreeNode current = queue.pollFirst();

            builder.append(current.val + " ");

            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);

        }

        return   builder.toString().trim();

    }

    //End Supportive Code Section


    //Solution Starts here
    //Solution is simple make a BFS traversal over the binary tree and collect the result into result TreeNode, at the end return the result

    TreeNode result = null;

    public void add(TreeNode node, int val){
        if(val < node.val)
            if(node.left == null)
                node.left = new TreeNode(val);

            else
                add(node.left, val);
        else{
            if(node.right == null)
                node.right = new TreeNode(val);
            else
                add(node.right, val);

        }
    }



    private void addToResult(int val){
        if(result == null)
        {
            result = new TreeNode(val);
            return;
        }

        add(result, val);

    }

    public TreeNode trimBST(TreeNode root, int L, int R){
        result = null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode head = queue.pollFirst();

            //visit the node
            if(head.val >= L && head.val <= R)
                addToResult(head.val);


            //enqueue to the queue
            if(head.left != null)
                queue.add(head.left);
            if(head.right != null)
                queue.add(head.right);



        }

        return result;
    }


   //Solution Ends Here

    public static void main(String[] args) {

        e_669_TrimABinarySearchTree solution = new e_669_TrimABinarySearchTree();

        solution.addToRoot(1);
        solution.addToRoot(0);
        solution.addToRoot(2);


        TreeNode result  = solution.trimBST(solution.root, 1,2);

        System.out.println(solution.printResult());

        //////////////

        solution = new e_669_TrimABinarySearchTree();

        solution.addToRoot(3);
        solution.addToRoot(0);
        solution.addToRoot(4);
        solution.addToRoot(2);
        solution.addToRoot(1);
        result  = solution.trimBST(solution.root, 1,3);
        System.out.println(solution.printResult());



    }
}
