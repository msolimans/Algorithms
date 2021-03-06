package com.leetcode.shared;

public class LinkedList {
    public ListNode root = null;
    public ListNode tail = null;

    public LinkedList() {
        root = null;
    }

    public LinkedList(int[] elems) {
        for (int i : elems) {
            add(i);
        }
    }


    public void add(int i) {
        if (root == null) {
            root = new ListNode(i);
            tail = root;
            return;
        }

        ListNode n = root;
        while (n.next != null) {
            n = n.next;
        }

        n.next = new ListNode(i);
        tail = n.next;
    }

    public ListNode pollFirst() throws Exception {
        if(root == null){
            throw  new Exception("empty!");
        }

        ListNode n = root;
        root = root.next;
        return n;
    }

    public boolean empty() {
        return root == null;
    }

}
