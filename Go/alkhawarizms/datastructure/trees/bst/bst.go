package bst

import "github.com/pkg/errors"

type BSTNode struct {
	value int
	rank  int
	left  *BSTNode
	right *BSTNode
}

type bsTree struct {
	root *BSTNode
}

func NewBSTree() *bsTree {
	return &bsTree{}
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
