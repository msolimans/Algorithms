package com.leetcode.shared;

import java.util.Stack;

/**
 * Created by msoliman on 1/18/18.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    //preorder traversal .. node -> left -> right
    //inorder traversal .. left -> node -> right
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = this;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.empty()) break;
                node = stack.pop();
                builder.append(node.val);
                node = node.right;
            }
        }

        return builder.toString();

    }


}
