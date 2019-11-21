package com.leetcode;

//e_234_PalindromeLinkedList 
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
//Given a singly linked list, determine if it is a palindrome.
//
//Example 1:
//
//Input: 1->2
//Output: false
//Example 2:
//
//Input: 1->2->2->1
//Output: true
//Follow up:
//Could you do it in O(n) time and O(1) space?

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/palindrome-linked-list/
//******************************************************************************************************************

public class e_234_PalindromeLinkedList {


    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 2, 1});

        System.out.println(new e_234_PalindromeLinkedList().isPalindrome2(list.root));
        System.out.println(new e_234_PalindromeLinkedList().isPalindrome(list.root));

    }

    ////////////////////////////////////////////////////////////////

    //O(n) with auxiliary space O(n)
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        Stack<Integer> stack = new Stack<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current.val);

            current = current.next;
        }

        int length = stack.size() / 2;
        current = head;

        while (--length >= 0) {
            if (stack.pop() != current.val)
                return false;
            current = current.next;
        }

        return true;
    }

    ////////////////

    //2nd Solution:
    //O(n) with auxiliary space O(1)

    public boolean isPalindrome2(ListNode head) {

        if (head == null) {
            return true;
        }

        int length = getSize(head);
        if (length == 1)
            return true;
        else if (length == 2) {
            return head.next.val == head.val;
        }


        ListNode second = findMiddleNode(head);
        if (length % 2 > 0)
            second = second.next;

        ListNode reversed = reverseList(head, (length / 2) - 1);

        while (second != null) {
            if (second.val != reversed.val) {
                return false;
            } else {
                second = second.next;
                reversed = reversed.next;
            }
        }

        return true;
    }


    int getSize(ListNode head) {
        if (head == null)
            return 0;
        int s = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            s++;
        }

        return s;
    }


    ListNode findMiddleNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;//double until it ends
            slowNode = slowNode.next;//at this time this is in the middle
        }
        return slowNode;
    }


    ListNode reverseList(ListNode node, int len) {
        if (node == null)
            return null;


        //      c
        //0->2->1->3->4
        //p------->c c->t
        //t=1->2->3
        //p->3->4


        ListNode pre = new ListNode(0);
        pre.next = node;
        while (--len >= 0 && node.next != null) {
            ListNode tomove = node.next;
            node.next = tomove.next;
            tomove.next = null;
            ListNode temp = pre.next;
            pre.next = tomove;
            tomove.next = temp;

        }

        //return the first elem in the list
        return pre.next;
    }


    @Test
    public void TestfindMiddleNode() {
        //length 7 returns 4th node = 7/2 = 3 => add 1 ="4"
        ListNode middle = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = middle;
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(10);
        Assert.assertEquals(middle, findMiddleNode(head));

        //length 3, returns 2nd node => 3/2 = 1 => add 1 ="2"
        middle = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = middle;
        head2.next.next = new ListNode(2);
        Assert.assertEquals(middle, findMiddleNode(head2));


        //length 4, returns 3rd node => 4/2 = 2 => add 1 ="3"
        middle = new ListNode(5);
        head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = middle;
        head2.next.next.next = new ListNode(2);
        Assert.assertEquals(middle, findMiddleNode(head2));


        //length 4, returns 3rd node => 4/2 = 2 => add 1 ="3"
        middle = new ListNode(5);
        head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = middle;
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(2);
        Assert.assertEquals(middle, findMiddleNode(head2));


        middle = new ListNode(5);
        ListNode head3 = new ListNode(1);
        head3.next = middle;
        Assert.assertEquals(middle, findMiddleNode(head3));


    }

    @Test
    public void TestreverseList() {

        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        Assert.assertEquals("1345", reverseList(head, 1).toString());

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        Assert.assertEquals("321456", reverseList(head, 2).toString());

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        Assert.assertEquals("12", reverseList(head2, 2).toString());
    }


    ////////////////////////////////////////////////////////////////

    @Test
    public void TestIsPalindrome() {
        LinkedList list = new LinkedList(new int[]{1, 2, 3, 2, 1});
        Assert.assertTrue(isPalindrome2(list.root));
        list = new LinkedList(new int[]{1, 2,});
        Assert.assertFalse(isPalindrome(list.root));
        Assert.assertFalse(isPalindrome2(list.root));

        list = new LinkedList(new int[]{1,});
        Assert.assertTrue(isPalindrome(list.root));
        Assert.assertTrue(isPalindrome2(list.root));

        list = new LinkedList(new int[]{1, 2, 1});
        Assert.assertTrue(isPalindrome(list.root));
        Assert.assertTrue(isPalindrome2(list.root));

        list = new LinkedList(new int[]{});
        Assert.assertTrue(isPalindrome(list.root));
        Assert.assertTrue(isPalindrome2(list.root));

        list = new LinkedList(new int[]{});
        Assert.assertTrue(isPalindrome(list.root));
        Assert.assertTrue(isPalindrome2(list.root));
        //
        list = new LinkedList(new int[]{1, 0, 0});
        Assert.assertFalse(isPalindrome(list.root));
        Assert.assertFalse(isPalindrome2(list.root));

        list = new LinkedList(new int[]{1, 0, 0, 0});
        Assert.assertFalse(isPalindrome(list.root));
        Assert.assertFalse(isPalindrome2(list.root));

    }


}
