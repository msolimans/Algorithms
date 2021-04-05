package e_26_RemoveDuplicatesFromSortedArray

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestRemoveDuplicates(t *testing.T) {
	assert.Equal(t, 2, removeDuplicates([]int{1, 1, 2}))
	assert.Equal(t, 1, removeDuplicates([]int{1}))

	assert.Equal(t, 0, removeDuplicates([]int{}))
	assert.Equal(t, 1, removeDuplicates([]int{1}))
	assert.Equal(t, 1, removeDuplicates([]int{1, 1, 1, 1, 1}))
	assert.Equal(t, 5, removeDuplicates([]int{1, 2, 3, 4, 5}))
	assert.Equal(t, 2, removeDuplicates([]int{1, 1, 2, 2, 2}))
	assert.Equal(t, 5, removeDuplicates([]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}))
	assert.Equal(t, 2, removeDuplicates([]int{1, 1, 2}))
}
