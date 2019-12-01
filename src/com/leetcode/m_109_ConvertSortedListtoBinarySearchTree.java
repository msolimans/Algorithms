package com.leetcode;

//m_109_ConvertSortedListtoBinarySearchTree
//Show Topic Tags

import com.leetcode.shared.ListNode;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//Example:
//
//Given the sorted linked list: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//******************************************************************************************************************
//Companies: Amazon | 10  Facebook | 6  Google | 2
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class m_109_ConvertSortedListtoBinarySearchTree {


    public static void main(String[] args) {


    }


    //find middle and separate tail from rest of list nodes to avoid revisiting the same nodes again
    ListNode findMiddle(ListNode head) {


        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        //separate prev mid in this case
        //just in case head is null, prevSlow is null in this case
        if (prevSlow != null)
            prevSlow.next = null;

        return slow;
    }


    //find middle by specifying the boundary of search or interest.
    //same way as above but without the need to modify the input which is better
    ListNode findMiddle(ListNode head, ListNode tail) {
        //this case will fix stackoverflow issue when you have both head and tail pointing to the same node
        //1->2->3->4->null => outputs 2
        //1->2->3->null    => outputs 2
        //1->2->null       => outputs 2
        //1->null          => outputs 1
        //1                => outputs null
        //1->2->null
        //^--^
        //h  t             => outputs 1
        //
        if (head == tail)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    @Test
    public void TestFindMiddle() {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);

        System.out.println(findMiddle(head, head.next).val);
        System.out.println(findMiddle(head, head).val);


        System.out.println(findMiddle(head.next, null).val);

        System.out.println(findMiddle(head).val);
    }


    //1) find middle elem in LinkedList
    //2) create TreeNode
    //3) divide linked list into 2 parts, recursively construct left subtree from left sublist and right subtree from right sublist [repeat 1 and 2]
    public TreeNode sortedListToBST(ListNode head, ListNode tail) {

        if (head == null)
            return null;

        ListNode mid = findMiddle(head, tail);
        if(mid == null)
            return null;

        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(head, mid);
        node.right = sortedListToBST(mid.next, tail);

        return node;
    }


    public TreeNode sortedListToBST2(ListNode head) {
        return sortedListToBST(head, null);
    }


    //1) find middle elem in LinkedList
    //2) create TreeNode
    //3) divide linked list into 2 parts, recursively construct left subtree from left sublist and right subtree from right sublist [repeat 1 and 2]
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null)
            return null;

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode mid = findMiddle(head);

        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);

        return node;
    }


    @Test
    public void TestSortedListToBST() {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        Assert.assertEquals("1020304050", sortedListToBST2(head).toString());
        Assert.assertEquals("1020304050", sortedListToBST(head).toString());
    }

}
