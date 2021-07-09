package linkedlist

import (
	"fmt"
	"strings"
)

type Node struct {
	Value int
	Next  *Node
}

type LinkedList struct {
	head *Node
}

func (l *LinkedList) Prepend(val int) *Node {
	if l == nil {
		*l = LinkedList{}
	}

	if l.head == nil {
		l.head = &Node{Value: val}
	} else {

		phead := l.head
		l.head = &Node{Value: val, Next: phead}
	}
	return l.head
}

//O(n) to reach out to tail (can be optimized by memorizing tail as a node in LinkedList (same as head))
func (l *LinkedList) Append(val int) *Node {
	if l == nil {
		*l = LinkedList{}
	}

	if l.head == nil {
		l.head = &Node{Value: val}
		return l.head
	}

	curr := l.head
	for curr.Next != nil {
		curr = curr.Next
	}
	curr.Next = &Node{Value: val}
	return l.head
}

//O(n)
func (l *LinkedList) Lookup(val int) bool {
	curr := l.head
	for curr != nil {
		if curr.Value == val {
			return true
		}
	}
	return false
}

func (l *LinkedList) traverseToIndex(index int) *Node {
	//we added a pre here to simplify calculations
	//insert at specified zero-based index
	//1 - 2 -3 - 4
	curr := &Node{Next: l.head}
	for curr.Next != nil && index > 0 {
		curr = curr.Next
		index--
	}
	return curr
}
func (l *Node) String() string {
	c := l
	builder := strings.Builder{}
	for c != nil {
		builder.WriteString(fmt.Sprintf("%d", c.Value))
		c = c.Next
	}
	return builder.String()
}

//we loop until we reach the index before we need to put the value at
//we insert the new item
func (l *LinkedList) Insert(index, val int) *Node {

	target := l.traverseToIndex(index)
	temp := target.Next
	target.Next = &Node{Value: val}
	target.Next.Next = temp

	//only in case it was prepend (at index 0) make sure you update head of linkedList
	if index == 0 {
		l.head = target.Next
	}

	return l.head
}

func (l *LinkedList) RemoveAt(index int) bool {
	preHead := &Node{Next: l.head}
	prev := preHead
	curr := l.head

	for curr.Next != nil && index > 0 {
		prev = curr
		curr = curr.Next
		index--
	}

	if index > 0 {
		return false
	}

	prev.Next = curr.Next
	l.head = preHead.Next
	return true

	//1->2->3

}
