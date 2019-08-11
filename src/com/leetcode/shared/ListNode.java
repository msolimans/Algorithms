package com.leetcode.shared;

//supporting class for simplifying unit test cases
//represents a node in a linked list
public class ListNode {

    public int val;
    public ListNode next;

    ListNode(int i) {
        val = i;
    }


    //supporting methods only used for debugging and unit tests

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder builder = new StringBuilder();

        while (node != null) {
            builder.append(node.val);
            node = node.next;
        }

        return builder.toString();
    }
}
