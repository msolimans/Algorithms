package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestCountPrimes(t *testing.T) {
	assert.Equal(t, 4, countPrimes(10))
}
