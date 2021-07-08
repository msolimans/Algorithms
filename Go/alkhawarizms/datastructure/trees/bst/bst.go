package bst

import (
	"github.com/golang-collections/collections/stack"
	"github.com/pkg/errors"
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
