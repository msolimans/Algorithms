package com.leetcode;

//e_206_ReverseLinkedList 
//Show Topic Tags

import com.leetcode.shared.LinkedList;
import com.leetcode.shared.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Reverse a singly linked list.
//
//Example:
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
//Follow up:
//
//A linked list can be reversed either iteratively or recursively. Could you implement both?

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/reverse-linked-list/
//******************************************************************************************************************

public class e_206_ReverseLinkedList {


    public static void main(String[] args) {

        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4});
        System.out.println(new e_206_ReverseLinkedList().reverseList(list.root));

        list = new LinkedList(new int[]{9, 2});
        System.out.println(new e_206_ReverseLinkedList().reverseList(list.root));

        list = new LinkedList(new int[]{2});
        System.out.println(new e_206_ReverseLinkedList().reverseList(list.root));

        list = new LinkedList(new int[]{});
        System.out.println(new e_206_ReverseLinkedList().reverseList(list.root));


        list = new LinkedList(new int[]{1, 2, 3, 4});
        System.out.println(new e_206_ReverseLinkedList().reverseList2(list.root));


        list = new LinkedList(new int[]{9, 2});
        System.out.println(new e_206_ReverseLinkedList().reverseList2(list.root));

        list = new LinkedList(new int[]{2});
        System.out.println(new e_206_ReverseLinkedList().reverseList2(list.root));

        list = new LinkedList(new int[]{});
        System.out.println(new e_206_ReverseLinkedList().reverseList2(list.root));


    }

    //using stack
    //O(n) space for stack
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        //push all of them n stack
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        //reverse by pop out from stack and change the next
        head = stack.pop();
        ListNode last = head;
        while (!stack.empty()) {
            last.next = stack.pop();
            last = last.next;
        }
        //empty the last elem otherwise it will be circular
        last.next = null;

        //return the new head pointer
        return head;
    }

    //using while loop
    //O(n) with constant space O(3)
    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return null;

        //temp is used for holding the next node to the current node before change
        ListNode temp;
        //current holds the current node
        ListNode current = head.next;
        //prev holds the previous node before any changes
        ListNode prev = head;
        //reset the first element [head] to point to null] otherwise we will end up with infinite circular loop
        prev.next = null;

        //loop thru as long as current is not null
        while (current != null) {
            //hold the next node e.g. 1->2->3->4 => in case current = 2, we are holding here 3 in temp
            temp = current.next;
            //assign the next node to current to the prev e.g. 1->2->3->4 => in case current = 2, assign .next to 1
            current.next = prev;
            //make prev as current e.g. 1->2->3->4 => prev will be 2
            prev = current;
            //current will be temp, in our example it will be 3
            current = temp;
        }

        //return the prev here as long as current is now null, we should return the prev not the current
        return prev;
    }



    @Test
    public void TestReverseList() {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4});
        Assert.assertEquals(list.tail, reverseList(list.root));
    }

    @Test
    public void TestReverseList2() {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4});
        Assert.assertEquals(list.tail, reverseList2(list.root));
    }


}
