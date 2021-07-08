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
