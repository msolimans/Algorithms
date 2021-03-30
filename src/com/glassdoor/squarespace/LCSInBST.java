package com.glassdoor.squarespace;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


//Company: SquareSpace
class BST {

    BSTNode root;


    void insert(int val) {
        if (root == null)
            root = new BSTNode(val);
        insert(val, root);

    }

    void insert(int val, BSTNode node) {

        if (val <= node.val) {
            if (node.left == null)
                node.left = new BSTNode(val);
            else {
                insert(val, node.left);
            }
        } else {
            if (node.right == null)
                node.right = new BSTNode(val);
            else
                insert(val, node.right);
        }
    }


}

class BSTNode {
    int val;
    BSTNode left;
    BSTNode right;

    public BSTNode(int val) {
        this.val = val;
    }
}


//get least common ancestor of binary search tree
public class LCSInBST {

    int least = 0;

    int lca(BSTNode root, int v1, int v2) {
        Set<Integer> set = getPath(root, v1);
        lca(root, v2, set);
        return least;

    }

    void lca(BSTNode root, int v, Set<Integer> path) {

        if (root == null)
            return;

        if (path.contains(root.val))
            least = root.val;

        if (v < root.val)
            lca(root.left, v, path);
        else if (v > root.val)
            lca(root.right, v, path);
    }

    Set<Integer> getPath(BSTNode root, int v) {
        Stack<BSTNode> s = new Stack<>();
        Set<Integer> res = new HashSet<>();

        s.add(root);
        while (!s.isEmpty()) {
            BSTNode c = s.pop();
            res.add(c.val);
            if (v < c.val)
                s.push(c.left);
            else if (v > c.val)
                s.push(c.right);
            else
                break;//equal

        }

        return res;
    }

    @Test
    public void TestLCA() {
        BST t = new BST();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(3);
        t.insert(6);
        t.insert(11);

        Assert.assertEquals(10, lca(t.root, 5, 11));
        Assert.assertEquals(15, lca(t.root, 11, 15));
        Assert.assertEquals(5, lca(t.root, 6, 3));
    }


}
