package com.leetcode;

//e_572_SubtreeofAnotherTree 
//Show Topic Tags

import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
// A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
//
//Example 1:
//Given tree s:
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//Given tree t:
//   4
//  / \
// 1   2
//Return true, because t has the same structure and node values with a subtree of s.
//Example 2:
//Given tree s:
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
//Given tree t:
//   4
//  / \
// 1   2
//Return false.

//******************************************************************************************************************
//Companies: Amazon | 57  Microsoft | 5  Google | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/subtree-of-another-tree/
//******************************************************************************************************************

public class e_572_SubtreeofAnotherTree {


    public static void main(String[] args) {


    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        if(t == null)
            return false;

        //get all nodes that match t's val
        List<TreeNode> sq = findNode(s, t.val);

        //if none found, return false
        if (sq == null)
            return false;

        //loop thru all found matchin nodes and check if they're the same
        for(TreeNode q: sq) {
            if (isSame(q, t))//if any of them are similar, return true
                return true;
        }

        //none of matched nodes were equally same, returns false
        return false;
    }

    boolean isSame(TreeNode s, TreeNode t) {

        if (s == null && t == null)
            return true;

        if (s == null && t != null)
            return false;
        if (t == null && s != null)
            return false;


        //preorder traversal
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    List<TreeNode> findNode(TreeNode node, int val) {
        //if node is null, not found, return null then
        if (node == null)
            return null;

        List<TreeNode> lst = new ArrayList<>();

        //if requested val equals node's val, return node
        if (node.val == val){
            lst.add(node);
        }


        //findNode in left branch
        List<TreeNode> l = findNode(node.left, val);
        //check if we have it
        if (l != null) {
            lst.addAll(l);
        }

        //if it doesn't exist, check right subtree
        List<TreeNode> r = findNode(node.right, val);
        if (r != null) {
            lst.addAll(r);
        }

        //doesn't exist
        return lst;
    }


    //second soln

    public boolean isSubtree2(TreeNode s, TreeNode t) {

        if (s == null && t == null)
            return true;

        if(t == null)
            return false;


        String str = preorder(s, "l");
        String ttr = preorder(t, "l");
        if(str.contains(ttr))
            return true;
        return false;


    }


    String preorder(TreeNode node, String s) {
        if (node == null){
            return s;
        }

        return "#" + node.val + " "+  preorder(node.left, "l") + " "+ preorder(node.right,"r");
    }

    @Test
    public void TestIsSubtree() {

        Assert.assertTrue(isSubtree(null, null));
        Assert.assertFalse(isSubtree(null, new TreeNode(2)));
        Assert.assertFalse(isSubtree( new TreeNode(2), null));

        Assert.assertTrue(isSubtree(new TreeNode(4), new TreeNode(4)));
        Assert.assertFalse(isSubtree(new TreeNode(2), new TreeNode(4)));

        Assert.assertTrue(isSubtree2(null, null));
        Assert.assertFalse(isSubtree2(null, new TreeNode(2)));
        Assert.assertFalse(isSubtree2( new TreeNode(2), null));

        Assert.assertTrue(isSubtree2(new TreeNode(4), new TreeNode(4)));
        Assert.assertFalse(isSubtree2(new TreeNode(2), new TreeNode(4)));

        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(4);
        p.right = new TreeNode(5);
        p.left.left = new TreeNode(1);
        p.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        Assert.assertTrue(isSubtree(p, t));
        Assert.assertTrue(isSubtree2(p, t));

        p.left.right.left = new TreeNode(0);
        Assert.assertFalse(isSubtree(p, t));
        Assert.assertFalse(isSubtree2(p, t));

        p.left.right.left = null;
        p.left.right = null;
        p.right.val = 4;
        p.right.left = new TreeNode(1);
        p.right.right = new TreeNode(2);
        Assert.assertTrue(isSubtree(p,t));
        Assert.assertTrue(isSubtree2(p,t));

    }

}
