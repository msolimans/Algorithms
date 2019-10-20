package com.leetcode;

//e_237_DeleteNodeInALinkedList
//Show Topic Tags

import com.leetcode.shared.LinkedList;
import com.leetcode.shared.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
//
//Given linked list -- head = [4,5,1,9], which looks like following:
//
//
//      4->5->1->9
//
//
//Example 1:
//
//Input: head = [4,5,1,9], node = 5
//Output: [4,1,9]
//Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
//Example 2:
//
//Input: head = [4,5,1,9], node = 1
//Output: [4,5,9]
//Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
//
//
//Note:
//
//The linked list will have at least two elements.
//All of the nodes' values will be unique.
//The given node will not be the tail and it will always be a valid node of the linked list.
//Do not return anything from your function.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
//******************************************************************************************************************

public class e_237_DeleteNodeInALinkedList {


    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4});
        new e_237_DeleteNodeInALinkedList().deleteNode(list.root.next);//delete 2
        System.out.println(list.root.toString());//should print 134 [omitted 2]
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public void deleteNode(ListNode node) {
        //assigns node's value to next node's value
        node.val = node.next.val;
        //shift node's next to the one after next
        node.next = node.next.next;
    }

    @Test
    public void TestDeleteNode() {
        LinkedList list = new LinkedList(new int[]{4, 5, 9, 1});
        deleteNode(list.root.next.next);//delete node [9] => deletion of elem in middle of linked list
        Assert.assertEquals("451", list.root.toString());
        deleteNode(list.root);//delete node [4] => deletion of root
        Assert.assertEquals("51", list.root.toString());
        deleteNode(list.root);//delete node [5] => handles 2 elems in linked list
        Assert.assertEquals("1", list.root.toString());
    }

}
