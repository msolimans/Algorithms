package main

import "fmt"

//Problem Title
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
//
//
//
//Example 1:
//
//Input: [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Example 2:
//
//Input: [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
//
//
//Note:
//
//1 <= A.length <= 10000
//-10000 <= A[i] <= 10000
//A is sorted in non-decreasing order.

//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: https://leetcode.com/problems/squares-of-a-sorted-array/
//******************************************************************************************************************

func main() {
	fmt.Println(sortedSquares([]int{-4, -1, 0, 3, 10}))
}

func sortedSquares(A []int) []int {
	//maintain current index in the result
	index := len(A) - 1
	//result arr
	result := make([]int, len(A))
	//pointers, compare 2 boundaries of A and choose the bigger one to put it at the end
	i := 0
	j := len(A) - 1

	for i <= j {
		//if element at i is bigger than at j after multiply, move ith element
		if A[i]*A[i] > A[j]*A[j] {
			result[index] = A[i] * A[i]
			//update pointer i
			i++
		} else {
			//after multiplication, if element at j is bigger than at i, move jth elem
			result[index] = A[j] * A[j]
			j--
		}

		//decrease index of result slice
		index--
	}

	return result

}
