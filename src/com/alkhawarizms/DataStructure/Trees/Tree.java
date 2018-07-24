package com.alkhawarizms.DataStructure.Trees;

import java.util.Iterator;
import java.util.List;

/**
 * Created by msoliman on 1/19/17.
 * Trees have many real life implementations, find shortest paths
 * Methods:
 * height(): returns height of the tree = max{height(left), height(right)}
 * size(): returns how many nodes in the tree = traverse through all nodes in the tree and count .. preorder, postorder, inorder, or levelorder (breadth first search)
 * isRoot(): finds out whether node is a root node ?
 * root(): returns root element
 */
public class Tree<E> {


    Node<E> root;

    Node<E> parent(Node<E> n) {
        if (n.isRoot())
            return null;

        return n.parent;
    }

    Node Root() {
        return root;
    }

    int height(Tree t, Node n) {

        while (!n.isExternal()) {
            return 0;
        }

        int ch = 0;

        Iterator<Node<E>> it = n.children.iterator();

        while (it.hasNext()) {
            ch = max(ch, height(t, it.next()));
        }

        return ch;
    }

    static int max(int n, int n2) {
        return n > n2 ? n : n2;

    }


    //recursive
    int depth(Tree t, Node node) {
        if (node.isRoot())
            return 0;
        return 1 + depth(t, node.parent);
    }


  /*
    int dept_while(Tree t, Node node){
        int r = 0;
        while(!node.isRoot()){
            node = node.parent;
            r++;
        }
        r++;//for root
        return r;
    }
    */


}
