package com.leetcode;

import com.leetcode.shared.LinkedList;
import com.leetcode.shared.ListNode;
import org.junit.Assert;
import org.junit.Test;

//m_61_RotateList 
//Show Topic Tags

/**
 * LinkedList, TwoPointer
 */

/*Description*/
//******************************************************************************************************************
//Given a linked list, rotate the list to the right by k places, where k is non-negative.
//
//Example 1:
//
//Input: 1->2->3->4->5->NULL, k = 2
//Output: 4->5->1->2->3->NULL
//Explanation:
//rotate 1 steps to the right: 5->1->2->3->4->NULL
//rotate 2 steps to the right: 4->5->1->2->3->NULL
//Example 2:
//
//Input: 0->1->2->NULL, k = 4
//Output: 2->0->1->NULL
//Explanation:
//rotate 1 steps to the right: 2->0->1->NULL
//rotate 2 steps to the right: 1->2->0->NULL
//rotate 3 steps to the right: 0->1->2->NULL
//rotate 4 steps to the right: 2->0->1->NULL

//******************************************************************************************************************
//Companies: Microsoft | 4  Amazon | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/rotate-list/
//******************************************************************************************************************

public class m_61_RotateList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    //O(nk)
    //25% Faster, Optimized below
    public ListNode rotateRight1(ListNode head, int k) {

        //rotate k times, everytime we rotate one time
        int len = getLength(head);
        if (len <= 1)
            return head;


        //Will give time Limit exceeded in leetcode in case we don't have this modulus,
        // so there is a need to optimize it in case we have k greater than len of list
        //e.g. len = 3 and k = 200000
        k = k % len;

        //every time we rotate items in linkedlist by 1 step
        for (int i = 0; i < k; i++) {
            //loop thru until we reach previous last elem
            //1->2->3->4->5->NULL           => this should result in 4
            ListNode current = head;
            while (current.next != null && current.next.next != null) {
                current = current.next;
            }

            //current.next is the last node, stores it
            ListNode temp = current.next;
            //remove the link to the last node
            current.next = null;
            //put this last node in front of the list
            temp.next = head;
            //update head to that moved last node
            head = temp;
        }

        return head;
    }

    //get length of linked list
    int getLength(ListNode head) {
        if (head == null)
            return 0;

        return 1 + getLength(head.next);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //O(n), Optimized - 100% Faster
    //Walk n-k nodes
    //Cut the list in 2 parts
    //  point the last node to null
    //  link end of list to the head of the list
    ListNode rotateRight(ListNode head, int k) {

        int len = getLength(head);

        if (len == 0)
            return null;

        //make it within range 0 .. n
        k = k % len;

        if (k == 0)
            return head;


        ListNode c = head;
        int ic = 1;

        //imagine list looks like
        //  0->1->2->..(n-k-1)->(n-k)..->n
        //                ^        ^___________this is where we need to cut the list in 2 parts, it will be new head
        //                |               ^____this is where we need to link end of list to head of list
        //                |____________________this is our new end of list, next node should be NULL

        //1) walk n-k steps or nodes
        while (c != null && ic + 1 <= len - k) {
            c = c.next;
            ic++;
        }

        //2) do the following:
        //c now refers to the cutting point where we need to cut the list
        // H....->C->next....E
        //t = c.next //should be our new head
        //c.next->null [end of new list]
        //End should point to Head resulting in
        //      next....E->H ...->C->null
        ListNode temp = c.next;
        c.next = null;
        c = temp;
        while (c != null && c.next != null) {
            c = c.next;
        }

        if (c != null) {
            c.next = head;
            head = temp;
        }

        return head;
    }


    @Test
    public void TestGetLength() {
        Assert.assertEquals(0, getLength(null));
        Assert.assertEquals(1, getLength(new ListNode(10)));
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        Assert.assertEquals(2, getLength(head));
        head.next.next = new ListNode(30);
        Assert.assertEquals(3, getLength(head));


    }


    @Test
    public void TestRotateRights() {
        LinkedList ls = new LinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result = ls.root.next.next.next;

        Assert.assertEquals(result, rotateRight(ls.root, 2));


        LinkedList ls1 = new LinkedList(new int[]{0, 1, 2});
        ListNode result1 = ls1.root.next.next;
        ListNode result11 = ls1.root;

        Assert.assertEquals(result1, rotateRight(ls1.root, 4));
        Assert.assertEquals(result11, rotateRight(ls1.root, 2000000000));


        LinkedList ls2 = new LinkedList(new int[]{0, 1});
        ListNode result2 = ls2.root.next;


        Assert.assertEquals(ls2.root, rotateRight(ls2.root, 4));
        Assert.assertEquals(result2, rotateRight(ls2.root, 5));


    }


    @Test
    public void Testm_61_RotateList1() {

        Assert.assertEquals(null, rotateRight1(null, 0));

        LinkedList ls = new LinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result = ls.root.next.next.next;

        Assert.assertEquals(result, rotateRight1(ls.root, 2));


        LinkedList ls1 = new LinkedList(new int[]{0, 1, 2});
        ListNode result1 = ls1.root.next.next;
        ListNode result11 = ls1.root;

        Assert.assertEquals(result1, rotateRight1(ls1.root, 4));
        Assert.assertEquals(result11, rotateRight1(ls1.root, 2000000000));


        LinkedList ls2 = new LinkedList(new int[]{0, 1});
        ListNode result2 = ls2.root.next;

        Assert.assertEquals(ls2.root, rotateRight1(ls2.root, 4));
        Assert.assertEquals(result2, rotateRight1(ls2.root, 5));


    }
}
