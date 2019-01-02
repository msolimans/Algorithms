package main

//Reverse An Array
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************

//Given an array, print reverse of it.
//
//Input:
//
//First line contains an integer, the number of test cases 'T' Each test case should contain an integer, size of array 'N' in the first line. In the second line Input the integer elements of the array in a single line separated by space.
//
//Output:
//
//Print the array in reverse order in a single line separated by space.Each array is to be printed in separate line.
//
//Constraints:
//
//1 <= T <= 100
//
//1 <= N <=100
//
//0 <= Arr[i] <= 100
//
//Example:
//
//Input
//1
//4
//1 2 3 4
//
//Output:
//4 3 2 1

//******************************************************************************************************************
//Companies: Moonfrog-Labs, Infosys
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/reverse-an-array/0/?ref=self
//******************************************************************************************************************

import (
	"fmt"
	"strings"
)

func main() {

	var t int
	var n int

	//read T
	if _, err := fmt.Scan(&t); err != nil {
		panic(err)
	}

	//like while in most other languages
	for t > 0 {
		t--

		//read N
		if _, err := fmt.Scan(&n); err != nil {
			panic(err)
		}

		//Initiate Array of size N
		arr := make([]int, n)

		//loop N times and initiate array with user input
		for i := 0; i < n; i++ {

			if _, err := fmt.Scan(&arr[i]); err != nil {
				panic(err)
			}

		}
		fmt.Println(strings.Trim(fmt.Sprint(run(arr)), "[]"))
	}

}

func run(arr []int) []int {
	//2 vars to maintain current index in the array .. one from left and one from right
	s := 0
	e := len(arr) - 1
	//temp var used for swap opertion
	var t int

	//while loop, work as long as s is less than or equal to e
	for s <= e {

		//swap
		//preserve elem at s position
		t = arr[s]
		//put elem at index e into s position
		arr[s] = arr[e]
		//put elem at index s into e position
		arr[e] = t

		//increment s, decrement e
		s++
		e--
	}

	return arr
}
