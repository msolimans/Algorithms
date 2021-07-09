package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestCommonStr(t *testing.T) {

	assert.Equal(t, "fl", commonStr("flow", "fly"))
	assert.Equal(t, "and", commonStr("andy", "and"))
	assert.Equal(t, "", commonStr("das", "bas"))

}

func TestLongestCommonPrefix(t *testing.T) {
	assert.Equal(t, "fl", longestCommonPrefix([]string{"fly", "flow", "flown", "floss"}))
	assert.Equal(t, "f", longestCommonPrefix([]string{"fly", "frank", "flown", "floss"}))
}
