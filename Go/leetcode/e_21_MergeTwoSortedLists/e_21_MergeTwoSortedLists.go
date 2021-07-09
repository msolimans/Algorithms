package e_21_MergeTwoSortedLists

import (
	"strconv"
	"strings"
)

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

func main() {

}

type ListNode struct {
	Value int
	Next  *ListNode
}

func NewListNode(value int) *ListNode {
	return &ListNode{Value: value}
}

func (l *ListNode) ToString() string {
	ch := l
	res := strings.Builder{}

	for ch != nil {
		res.WriteString(strconv.Itoa(ch.Value))
		ch = ch.Next
	}
	return res.String()
}

func NewList(ns ...int) *ListNode {
	if len(ns) == 0 {
		return nil
	}

	h := NewListNode(0)
	ch := h
	for _, v := range ns {
		ch.Next = NewListNode(v)
		ch = ch.Next
	}

	return h.Next
}

func mergeTwoLists(l1, l2 *ListNode) *ListNode {
	h := NewListNode(0)
	ch := h
	c1 := l1
	c2 := l2
	t := c1

	for c1 != nil && c2 != nil {
		if c1.Value < c2.Value {
			t = c1.Next
			c1.Next = nil
			ch.Next = c1
			c1 = t
		} else {
			t = c2.Next
			c2.Next = nil
			ch.Next = c2
			c2 = t
		}
		ch = ch.Next
	}

	if c1 != nil {
		ch.Next = c1
	}

	if c2 != nil {
		ch.Next = c2
	}

	return h.Next
}
