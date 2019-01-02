package main

//Sum of array
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given an integer array find sum of it.

//Input:
//        First line contains an integer, the number of test cases 'T' Each test case should contain an integer, size of array 'N' in the first line. In the second line Input the integer elements of the array in a single line separated by space.
//
//
//        Output:
//        Print the sum in seperate line.
//
//
//        Constraints:
//
//        1 <= T <= 30
//
//        1 <= N <= 100
//
//        1 <= Arr[i] <= 100
//
//
//
//        Example:
//
//        Input
//        1
//        4
//        1 2 3 4
//
//        Output:
//        10
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link:https://practice.geeksforgeeks.org/problems/sum-of-array/0
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

		println(sumOfArray(arr))

	}

}

//cast or change return type based on problem's needs
func sumOfArray(arr []int) int {
	result := 0
	for _, v := range arr {
		result += v
	}

	return result
}
