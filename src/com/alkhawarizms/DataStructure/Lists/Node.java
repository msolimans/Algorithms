package com.alkhawarizms.DataStructure.Lists;

/**
 * Created by msoliman on 4/22/17.
 */
public class Node<E> {

        E elem;
        Node<E> next;
        Node<E> prev;

        public Node() {
            elem = null;
        }

        public Node(E elem) {
            this.elem = elem;
        }

        public E getElem() {
            return elem;
        }

}
