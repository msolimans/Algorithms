package main

//Sum of array elements
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given an integer array, find sum of elements in it.

//Input:
//
//        First line contains an integer denoting the test cases 'T'. Every test case contains an integer value depicting size of array 'N' and N integer elements are to be inserted in the next line with spaces between them.
//
//        Output:
//
//        Print the sum of all elements of the array in separate line.
//
//        Constraints:
//
//        1 <= T <= 100
//
//        1 <= N<= 100
//
//        1 <= Arr[i] <= 100
//
//        Example:
//
//        Input:
//        2
//        3
//        3 2 1
//        4
//        1 2 3 4
//
//        Output:
//        6
//        10
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/sum-of-array-elements/0
//******************************************************************************************************************

import "fmt"

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

		println(run(arr))

	}
}

func run(arr []int) int {

	//initiate sum with 0
	sum := 0
	for _, v := range arr {
		//accumulate and each value from array into sum
		sum += v
	}

	//return sum
	return sum
}
