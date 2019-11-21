package com.leetcode;

//e_203_RemoveLinkedListElements 
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
//Remove all elements from a linked list of integers that have value val.
//
//Example:
//
//Input:  1->2->6->3->4->5->6, val = 6
//Output: 1->2->3->4->5

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/remove-linked-list-elements/
//******************************************************************************************************************

public class e_203_RemoveLinkedListElements {


    public static void main(String[] args) {


    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode removeElements(ListNode head, int val) {

        //a new node prior to head
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode current = preHead;

        //loop thru starting from preHead [validating current node has next node]
        while (current.next != null) {

            //if next node equals `val`, remove it
            if (current.next.val == val) {
                //move next node to next next node to remove that `val` from linked list
                current.next = current.next.next;
            }

            //if next node not null and next node's val doesnt equal to `val` move cursor forward [this will solve problem like 1->1->1 and val=1]
            if (current.next != null && current.next.val != val)
                current = current.next;
        }


        return preHead.next;
    }

    @Test
    public void TestRemoveElements() {
        Assert.assertEquals(new LinkedList(new int[]{1, 2, 3, 4, 5}).root.toString(), removeElements(new LinkedList(new int[]{1, 2, 6, 3, 4, 5, 6}).root, 6).toString());
        Assert.assertNull(removeElements(new LinkedList(new int[]{1, 1, 1}).root, 1));
        Assert.assertNull(removeElements(new LinkedList(new int[]{1, 1}).root, 1));
    }

}
