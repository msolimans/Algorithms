package com.alkhawarizms.DataStructure.Lists;

import java.util.Iterator;

/**
 * Created by msoliman on 1/21/17.
 *
 *
 * Tests
     LinkedList<Integer> ls = new LinkedList<>();
         ls.add(10);
         ls.add(20);
         ls.add(100);
         ls.addFirst(200);
         System.out.println(ls.getAt(0).getElem());
         System.out.println(ls.getLast().getElem());

         System.out.println(ls.getAt(1).getElem());
         System.out.println(ls.getAt(2).getElem());

 */

public class LinkedList<E> implements ILinkedList<E>, Iterator<E> {


/*
3 issues you have to take care of in linked lists
    1. empty list
    2. beginning of the list
    3. midest of the list
*/

    Node<E> head = new Node();
    Node<E> tail = new Node();

    int size = 0;
    Node<E> current = head;


    public LinkedList() {
        size = 0;
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    @Override
    public E next() {
        return (E) current.next;
    }



    public int size() {
        return size;
    }

    ///O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        Node n = new Node(e);
        if (isEmpty()) {
            head.next = n;
            tail.prev = n;
            n.prev = head;
            n.next = tail;
        } else {
            //add before to the tail
            n.prev = tail.prev;
            n.next = tail;

            tail.prev.next = n;
            tail.prev = n;

        }

        size++;
    }

    public void addFirst(E elem) {

        Node<E> n = new Node();
        n.elem = elem;
        n.next = head.next;
        n.prev = head;


        head.next.prev = n;
        head.next = n;


        size++;

    }

    public void addLast(E elem) {

        Node<E> n = new Node();
        n.elem = elem;
        n.next = tail;
        n.prev = tail.prev;


        tail.prev.next = n;
        tail.prev = n;


        size++;
    }

    @Override
    public void addAt(E obj, int index) {

    }

    @Override
    public void addBefore(E node, E obj) {

    }

    @Override
    public void addAfter(E node, E obj) {

    }


    //takes O(1)
    private boolean remove(Node n) {

        if (n != null && n.next != null && n.prev != null) {
            n.prev.next = n.next;
            n.next.prev = n.prev;

            n = null;
            size--;
            return true;
        }

        return false;
    }

    public boolean removeFirst() {
        return removeAt(0);
    }

    public boolean removeLast() {
        return removeAt(size - 1);
    }

    public boolean removeAt(int indx) {

        if (isEmpty() || indx >= size)
            return false;

        Node<E> n = getNodeAt(indx);

        return remove(n);
    }

    public E getLast() {
        if (size == 0)
            return null;

        if (tail.prev != null)
            return tail.prev.elem;
        return null;
    }

    public E getFirst() {
        if (size == 0)
            return null;

        if (head.next != null)
            return head.next.elem;

        return null;
    }

    private Node<E> getNodeAt(int indx) {

        if (isEmpty() || indx >= size)
            return null;

        Node<E> n = head;
        while (indx >= 0 && n.next != null) {

            n = n.next;
            if (indx == 0) {
                return n;
            }

            indx--;

        }

        return null;
    }

    public E getAt(int indx) {

        Node<E> n = getNodeAt(indx);
        if (n == null)
            return null;
        return n.elem;
    }


}
