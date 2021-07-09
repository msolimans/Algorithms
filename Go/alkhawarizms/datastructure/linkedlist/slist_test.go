package linkedlist

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

var l = &LinkedList{
	head: &Node{Value: 10,
		Next: &Node{
			Value: 20,
			Next: &Node{
				Value: 30,
			},
		}},
}

func TestNode_String(t *testing.T) {

	assert.Equal(t, "102030", l.head.String())
}

func Test_traverseToIndex(t *testing.T) {
	//0	- 	1 - 2
	//10 - 20 - 30
	assert.Equal(t, "0102030", l.traverseToIndex(0).String())
	assert.Equal(t, "102030", l.traverseToIndex(1).String())
	assert.Equal(t, "2030", l.traverseToIndex(2).String())
	assert.Equal(t, "30", l.traverseToIndex(3).String())
	assert.Equal(t, "30", l.traverseToIndex(4).String())
}

func TestLinkedList_Insert(t *testing.T) {
	assert.Equal(t, "10152030", l.Insert(1, 15).String())
	assert.Equal(t, "1015203040", l.Insert(4, 40).String())
	assert.Equal(t, "51015203040", l.Insert(0, 5).String())
}

func TestLinkedList_Prepend(t *testing.T) {
	assert.Equal(t, "5102030", l.Prepend(5).String())
	assert.Equal(t, "15102030", l.Prepend(1).String())
}

func TestLinkedList_Append(t *testing.T) {
	assert.Equal(t, "10203040", l.Append(40).String())
	assert.Equal(t, "1020304050", l.Append(50).String())
}

func TestLinkedList_RemoveAt(t *testing.T) {
	assert.True(t, l.RemoveAt(0))
	assert.Equal(t, "2030", l.head.String())
	assert.True(t, l.RemoveAt(1))
	assert.Equal(t, "20", l.head.String())
}
