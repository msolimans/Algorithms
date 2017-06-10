package com.alkhawarizms.DataStructure.Trees;

import java.util.List;

/**
 * Created by msoliman on 4/24/17.
 */
public class Node<E> {
    public E key;
    public List<Node<E>> children;
    public Node<E> parent;

    boolean isExternal(){
        if(children == null)
            return true;
        return false;
    }

    boolean isRoot(){
        return parent == null;
    }
}
