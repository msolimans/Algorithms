package e_28_ImplementstrStr

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestStrStr(t *testing.T) {
	assert.Equal(t, 0, strStr("a", ""))
	assert.Equal(t, 0, strStr("", ""))
	assert.Equal(t, 2, strStr("hello", "ll"))
	assert.Equal(t, 0, strStr("hello", "he"))
	assert.Equal(t, -1, strStr("aaaaa", "bba"))
	assert.Equal(t, 4, strStr("mississippi", "issip"))
	assert.Equal(t, 3, strStr("hello", "lo"))
	assert.Equal(t, 9, strStr("hello world", "ld"))
}
