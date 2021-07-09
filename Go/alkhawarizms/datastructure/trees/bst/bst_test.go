package bst

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestBsTree_Insert(t *testing.T) {
	bstree := NewBSTree()
	err := bstree.Insert(10)
	assert.Nil(t, err)
	err = bstree.Insert(20)
	assert.Nil(t, err)
	assert.True(t, bstree.root.value == 10)
	assert.True(t, bstree.root.right.value == 20)
	err = bstree.Insert(5)
	assert.Nil(t, err)
	assert.True(t, bstree.root.value == 10)
	assert.True(t, bstree.root.right.value == 20)
	assert.True(t, bstree.root.left.value == 5)
	//test
}

func TestBSTNode_Insert(t *testing.T) {

	var n *BSTNode = nil
	assert.NotNil(t, n.Insert(10))
	n = &BSTNode{value: 10}
	err := n.Insert(5)
	assert.Nil(t, err)
	assert.True(t, n.value == 10)
	assert.True(t, n.left.value == 5)

}

func TestBSTNode_Lookup(t *testing.T) {

	bstree := NewBSTree()
	err := bstree.Insert(10)
	assert.Nil(t, err)
	assert.True(t, bstree.Lookup(10))
	_ = bstree.Insert(5)
	_ = bstree.Insert(11)
	_ = bstree.Insert(20)
	_ = bstree.Insert(2)
	_ = bstree.Insert(1)
	assert.True(t, bstree.Lookup(1))
	assert.False(t, bstree.Lookup(0))

}

func newBSTree() *bsTree {
	bsTree := NewBSTree()
	bsTree.Insert(10)
	bsTree.Insert(5)
	bsTree.Insert(11)
	bsTree.Insert(2)
	bsTree.Insert(1)

	////////////////////////////////////
	//		10
	//	  5		11
	//	2
	//1
	////////////////////////////////////
	return bsTree
}

func TestBsTree_DepthFirstTraverse(t *testing.T) {
	bsTree := newBSTree()
	assert.Equal(t, "1052111", bsTree.DepthFirstTraverse())
}

func TestBsTree_BreadthFirstTraverse(t *testing.T) {
	bsTree := newBSTree()
	assert.Equal(t, "1051121", bsTree.BreadthFirstTraverse())
}

func TestBsTree_Remove(t *testing.T) {
	bsTree := newBSTree()
	assert.Equal(t, "1051121", bsTree.BreadthFirstTraverse())
	//			10
	//		5		11
	//	2
	//1

	////////////////////////////////
	bsTree = newBSTree()
	assert.True(t, bsTree.Remove(5))
	assert.Equal(t, "102111", bsTree.BreadthFirstTraverse())

	////////////////////////////////
	bsTree = newBSTree()
	bsTree.Insert(7)
	assert.True(t, bsTree.Remove(5))
	assert.Equal(t, "1071121", bsTree.BreadthFirstTraverse())

	////////////////////////////////
	bsTree = newBSTree()
	bsTree.Insert(7)
	bsTree.Insert(6)
	assert.True(t, bsTree.Remove(5))
	assert.Equal(t, "10611271", bsTree.BreadthFirstTraverse())

	////////////////////////////////
	bsTree = newBSTree()
	bsTree.Insert(7)
	bsTree.Insert(6)
	assert.True(t, bsTree.Remove(7))
	assert.Equal(t, "10511261", bsTree.BreadthFirstTraverse())
	////////////////////////////////
	bsTree = newBSTree()

	assert.True(t, bsTree.Remove(5))
	assert.True(t, bsTree.Remove(2))
	assert.Equal(t, "10111", bsTree.BreadthFirstTraverse())
	////////////////////////////////
	bsTree = newBSTree()
	assert.True(t, bsTree.Remove(11))
	assert.Equal(t, "10521", bsTree.BreadthFirstTraverse())
}
