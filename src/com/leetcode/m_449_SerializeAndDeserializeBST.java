package com.leetcode;

//449. Serialize and Deserialize BST
//Show Topic Tags

import com.leetcode.shared.TreeNode;

import java.util.Base64;
import java.util.LinkedList;
import java.util.Objects;

/**
 * BST, Breadth First Search
 */

/*Description*/
//******************************************************************************************************************
//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//        Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//        The encoded string should be as compact as possible.
//
//        Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
//


//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/serialize-and-deserialize-bst/description/
//******************************************************************************************************************




public class m_449_SerializeAndDeserializeBST {

    public static class Codec {
        // Encodes a tree to a single string.
        //traverse using DFS (depth first search) to get your string, combine or compact same number into one e.g. 2/4
        public String serialize(TreeNode root) {
            if(root == null)
                return  "";

            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.addFirst(root);
            StringBuilder builder = new StringBuilder();
            int last = root.val;
            int count = 0;//no occurrence yet

            while (!stack.isEmpty()) {
                TreeNode node = stack.pollFirst();


                if (node.val != last) {

                    builder.append(last);

                    if (count > 1)
                        builder.append("/").append(count);

                    builder.append(",");

                    last = node.val;

                    count = 1; //just occurs now
                } else {
                    count++;
                }


                if (node.right != null)
                    stack.addFirst(node.right);

                if (node.left != null)
                    stack.addFirst(node.left);

            }

            builder.append(last);

            if (count > 1)
                builder.append("/").append(count);

            return builder.toString();

        }

        TreeNode add(TreeNode root, int i, int count) {
            if (count == 0)
                return root;

            //add items into the tree node here (count is how many times we should add this item
            while (count-- > 0) {


                if (root == null) {
                    root = new TreeNode(i);
                    continue;
                }


                TreeNode current = root;
                while (true) {
                    if (i <= current.val) {

                        if (current.left == null) {
                            current.left = new TreeNode(i);
                            break;
                        }

                        current = current.left;
                    }

                    if (i > current.val) {
                        if (current.right == null) {
                            current.right = new TreeNode(i);
                            break;
                        }

                        current = current.right;
                    }

                }

            }

            return  root;

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null || Objects.equals(data.trim(), ""))
                return null;

            String[] items = data.split(",");
            TreeNode root = null;

            for (String item : items) {
                int i = 0;
                int count = 1;

                if (item.contains("/")) {
                    String[] iitem = item.split("/");
                    i = Integer.parseInt(iitem[0]);
                    count = Integer.parseInt(iitem[1]);
                } else {
                    i = Integer.parseInt(item);
                }

                root = add(root, i,count);


            }

            return root;

        }


    }


    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(3);

        node.left.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(2);
        node.left.left.left.left = new TreeNode(2);
        node.left.left.left.left.left = new TreeNode(1);

        node.right = new TreeNode(8);
        node.right.left = new TreeNode(7);
        node.right.left.left = new TreeNode(6);
        node.right.left.left.left = new TreeNode(6);

        node.right.right = new TreeNode(9);
        node.right.right.left = new TreeNode(9);
        node.right.right.left.left = new TreeNode(9);


        Codec codec = new Codec();
        String n1 = codec.serialize(node);
        TreeNode n2 = codec.deserialize(n1);
        String n3 = codec.serialize(n2);

        System.out.println(n3);


    }
}
