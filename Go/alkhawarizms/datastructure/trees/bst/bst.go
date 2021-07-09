package bst

import (
	"fmt"
	"github.com/golang-collections/collections/queue"
	"github.com/golang-collections/collections/stack"
	"github.com/pkg/errors"
	"strings"
)

//Number of nodes in each level 2^Level_Index
//# of nodes => 2^h - 1 where h is the hight = how many levels in tree
//log(nodes) = height (steps to find items)
//Balance BST using AVL or RedBlack Trees
//Perfect Binary Tree (all nodes have 2 children)
//Full Binary Tree (every node has 0 or 2 childs)
type BSTNode struct {
	value int
	left  *BSTNode
	right *BSTNode
}

type bsTree struct {
	root *BSTNode
}

func NewBSTree() *bsTree {
	return &bsTree{}
}
func (b *bsTree) Lookup(value int) bool {
	//queu := queue.New()
	stack := stack.New()

	if b == nil {
		return false
	}

	stack.Push(b.root)
	for stack.Len() > 0 {
		item := stack.Pop().(*BSTNode)
		//exhausted - no more items
		if item == nil {
			return false
		}

		//we found it
		if item.value == value {
			return true
		} else { //less than current item go left
			if value < item.value {
				stack.Push(item.left)
			} else { //go right
				stack.Push(item.right)
			}
		}
	}

	return false
}

func (b *bsTree) Insert(value int) error {
	if b.root == nil {
		b.root = &BSTNode{value: value}
		return nil
	}

	return b.root.Insert(value)
}

func (b *bsTree) DepthFirstTraverse() string {
	str := strings.Builder{}
	stack := stack.New()
	if b.root != nil {
		stack.Push(b.root)
	}

	for stack.Len() != 0 {
		node := stack.Pop().(*BSTNode)

		str.WriteString(fmt.Sprintf("%d", node.value))

		if node.right != nil {
			stack.Push(node.right)
		}

		if node.left != nil {
			stack.Push(node.left)
		}

	}
	return str.String()

}

//level by level traversal
func (b *bsTree) BreadthFirstTraverse() string {
	str := strings.Builder{}
	queue := queue.New()
	if b.root != nil {
		queue.Enqueue(b.root)
	}

	for queue.Len() != 0 {
		node := queue.Dequeue().(*BSTNode)

		str.WriteString(fmt.Sprintf("%d", node.value))

		if node.left != nil {
			queue.Enqueue(node.left)
		}

		if node.right != nil {
			queue.Enqueue(node.right)
		}

	}
	return str.String()

}

func (b *BSTNode) Insert(value int) error {
	if b == nil {
		return errors.New("node nil")
	}
	if value <= b.value {
		if b.left == nil {
			b.left = &BSTNode{value: value}
		} else {
			return b.left.Insert(value)
		}
	} else {
		if b.right == nil {
			b.right = &BSTNode{value: value}
		} else {
			return b.right.Insert(value)
		}

	}

	return nil
}

func (b *bsTree) Remove(value int) bool {
	//find element first and keep track of its parent
	//do one of three operations:
	//1 node doesn't have right node
	//2 node has right child (right child doesn't have left child)
	//3 node has right child (right child has left child)
	current := b.root
	var parent *BSTNode = nil
	for current != nil {
		//not found
		if value < current.value {
			parent = current
			current = current.left
		} else if value > current.value {
			parent = current
			current = current.right
		} else { //found

			if current.right == nil {
				//current is the root itself
				if parent == nil {
					b.root = current.left
				} else if current.value < parent.value { //in the left
					parent.left = current.left
				} else {
					parent.right = current.left
				}
			} else if current.right != nil && current.right.left == nil { //there's right but no right's left child
				if parent == nil {
					tmp := b.root.left //preserve left child
					b.root = current.right
					b.root.left = tmp //return left child
					//current.right.left = current.left //whatever in the left side
					//		4
					//	3		5
					//remove 4 =>
					//		5
					//	3
				} else if current.value < parent.value { //in the left
					//		 		6
					//	 		4
					//		3		5
					//remove 4

					parent.left = current.right
					parent.left.left = current.left

				} else {

					//		2
					//	1		4
					//		3		5

					parent.right = current.right
					parent.right.left = current.left
				}
			} else {
				//go one step right and then all way down to the left (gives us the smallest number in this case)
				smallestParent := current.right
				smallest := current.right.left
				//while we have left childs, we continue moving on
				for smallest.left != nil {
					smallestParent = smallest
					smallest = smallest.left
				}

				//		2
				//	1		4
				//		3		5
				//remove 2

				//take care of right part of the smallest since we know that it doesn't have any left childs so we only care about right
				//put it under smallestParent
				smallestParent.left = smallest.right
				//then we move smallest to the main node
				smallest.left = current.left
				smallest.right = current.right

				//adjust parent to make sure we have parent pointing to the new node (smallest)
				if parent == nil {
					b.root = smallest
				} else if current.value < parent.value {
					parent.left = smallest
				} else {
					parent.right = smallest
				}

			}

			return true
		}
	}

	return false
}
