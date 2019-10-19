package com.leetcode;

//e_21_MergeTwoSortedLists 
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
//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
//Example:
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/merge-two-sorted-lists/
//******************************************************************************************************************

public class e_21_MergeTwoSortedLists {


    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(new int[]{1, 2, 4});
        LinkedList l2 = new LinkedList(new int[]{1, 3, 4});

        System.out.println(new e_21_MergeTwoSortedLists().mergeTwoLists(l1.root, l2.root).toString());
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //head of result
        ListNode h1 = new ListNode(0);
        //add l1 to head
        h1.next = l1;
        //current indicators for list1 and list2
        ListNode c1 = h1;
        ListNode c2 = l2;

        ListNode temp;
        ListNode c2temp;


        //current node in list1 and current node in list2 [both are not nulls]
        while (c1.next != null && c2 != null) {

            //if next node's value in list1 greater than current node's value in list2, change next node of list1 to current node's value from list2
            if (c1.next.val > c2.val) {

                //preserve next node in temp
                temp = c1.next;
                //preserve current node from list2 in temp2
                c2temp = c2;
                //move current to next node in the list
                c2 = c2.next;
                //move current's next to temp from list2 [temp2]
                c1.next = c2temp;
                //temp from list2 is now the node that was moved as it was less than current node in list1
                //make its next node point to original next node in list1
                c2temp.next = temp;
            } else {
                //just move indicator [cursor] of list1 to next node
                c1 = c1.next;
            }
        }


        //in case if there's any node left in list2, move them to list1
        while (c2 != null) {
            c1.next = c2;
            c1 = c1.next;
            c2 = c2.next;
        }


        //return next list node of head as a result
        return h1.next;
    }

    @Test
    public void TestMergeTwoLists() {
        LinkedList l1 = new LinkedList(new int[]{1, 2, 4});
        LinkedList l2 = new LinkedList(new int[]{1, 3, 4});
        ListNode result = mergeTwoLists(l1.root, l2.root);

        Assert.assertEquals("112344", result.toString());

        l1 = new LinkedList(new int[]{1, 2, 4});
        l2 = new LinkedList(new int[]{1,});
        result = mergeTwoLists(l1.root, l2.root);

        Assert.assertEquals("1124", result.toString());


        l1 = new LinkedList(new int[]{1, 4});
        l2 = new LinkedList(new int[]{1,});
        result = mergeTwoLists(l1.root, l2.root);

        Assert.assertEquals("114", result.toString());


        l1 = new LinkedList(new int[]{1});
        l2 = new LinkedList(new int[]{1,});
        result = mergeTwoLists(l1.root, l2.root);

        Assert.assertEquals("11", result.toString());


        l1 = new LinkedList(new int[]{});
        l2 = new LinkedList(new int[]{1,});
        result = mergeTwoLists(l1.root, l2.root);

        Assert.assertEquals("1", result.toString());

        l1 = new LinkedList(new int[]{1});
        l2 = new LinkedList(new int[]{});
        result = mergeTwoLists(l1.root, l2.root);

        Assert.assertEquals("1", result.toString());

    }


}
