package e_21_MergeTwoSortedLists

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestMergeTwoSortedLists(t *testing.T) {
	l1 := NewList(1, 2, 3, 4)
	l2 := NewList(3, 4, 5, 6)
	res := mergeTwoLists(l1, l2)

	assert.Equal(t, "12334456", res.ToString())
}
