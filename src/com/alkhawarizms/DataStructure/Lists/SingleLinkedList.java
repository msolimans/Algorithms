package com.alkhawarizms.DataStructure.Lists;

/**
 * Created by msoliman on 4/22/17.
 * Single linked list has only one next pointer to the next element with no previous pointer
 * To add new element at the end of the list you have to loop through all elements to find the tail then push the element and change pointers
 * head and tail both will be representing actual nodes in this implementation, there is different implementation that might have head and tail
 * don't have any data except they are just pointing to elements (like LinkedList.java)
 */
public class SingleLinkedList<E> implements ILinkedList<E> {
    int size = 0;
    Node<E> head = null;
    Node<E> tail = null;


    @Override
    public boolean isEmpty() {
        if(head == null || size == 0)
            return true;

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E obj) {
        Node<E> node = new Node(obj);
        //point the new node to the current head
        node.next = head;
        //move the head to the new node
        head = node;

        //if the list was empty before addition, make the tail = head
        if(head.next == null)
            tail = head;

        size++;

    }

    @Override
    public void addLast(E obj) {
        Node<E> node = new Node(obj);
        //isEmpty
        if(isEmpty())
            head = tail = node;

        if(tail == null)
            head = tail = node;
        else {
            //make the last element in linked list to point to this node
            tail.next = node;
            //move the tail to the new node
            tail = node;
        }

        size++;
    }

    @Override
    public void addAt(E obj, int index) {
        if(index == 0)
            addFirst(obj);
        else if(index == size -1)
            addLast(obj);
        else{
            Node<E> node = new Node(obj);
            Node<E> target = getNodeAt(index - 1);
            node.next = target.next;
            target.next = node;

        }
    }

    @Override
    public void addBefore(E node, E obj) {
        if(isEmpty())
            return;

        if(head.getElem() == node) {
            addAt(obj, 0);
            return;
        }

        if(tail.getElem() == node) {
            addAt(obj, size - 2);
            return;
        }

        if(size>1) {
            Node<E> target = head;
            while (target != tail && target.next!= null) {
                if (target.next.getElem() == node){
                    Node<E> objNode = new Node(obj);
                    objNode.next = target.next;
                    target.next = objNode;
                }

            }
        }

    }

    @Override
    public void addAfter(E node, E obj) {

    }


    @Override
    public boolean removeFirst() {

        if(isEmpty())
            return  false;


        //both of them pointing to the same element (only one elem was there)
        if(head == tail)
            head = tail = null;
        else
            head = head.next;

        size--;

        return true;
    }

    @Override
    public boolean removeLast() {
        //empty list
        if(isEmpty())
            return false;

        //only one elem there inside the list
        if(head == tail)
            head = tail = null;
        else{
            //multiple elems inside the list .. loop through until previous last (tail)
            Node<E> n = head;

            while(n.next != tail)
                n=n.next;

            //change location of tail to point to the previous last elem
            tail = n;
            //make the next to the tail equals null
            tail.next = null;

        }

        size--;

        return  true;


    }

    @Override
    public boolean removeAt(int indx) {
        if(isEmpty())
            return false;
        if(indx>size())
            return  false;

        if(indx==0)
            return removeFirst();
        else if(indx == size-1)
            return removeLast();
        else {

            Node<E> elem = head;
            int count = 1;
            while(count++<indx-1){
                elem = elem.next;

            }


            elem.next = elem.next.next;

        }

        size--;

        return true;
    }

    @Override
    public E getFirst() {
        //return at 0
        return getAt(0);
    }

    @Override
    public E getLast() {
        //return at size -1

        return getAt(size-1);
    }

    @Override
    public E getAt(int indx) {
        //return at index
        if(isEmpty())
            return null;
        if(indx>size()-1)
            return null;

        Node<E> elem = head;

        while(--indx>=0){
            elem = elem.next;

        }
        return elem.getElem();


    }

    public Node<E> getNodeAt(int indx) {
        //return at index
        if(isEmpty())
            return null;
        if(indx>size()-1)
            return null;

        Node<E> elem = head;

        while(--indx>=0){
            elem = elem.next;

        }
        return elem;


    }
}
