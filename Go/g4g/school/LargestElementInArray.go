package main

//Largest Element In Array
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given an array, find the largest element in it.

//Input:
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n , the no of elements in the array. Then next line contains n integers of the array.
//
//        Output:
//        Print the maximum element in the array.
//
//        Constraints:
//        1<=T<=100
//        1<=n<=100
//        1<=a[i]<=1000
//
//        Example:
//        Input:
//        2
//        5
//        10 324 45 90 9808
//        7
//        1 2 0 3 2 4 5
//
//        Output :
//        9808
//        5
//

//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/largest-element-in-array/0/?ref=self
//******************************************************************************************************************


import (
	"fmt"
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

		fmt.Println(findLargestElement(arr))

	}

}


func findLargestElement(arr []int) int {

	//based on constraints => 1<=n<=100 so we are sure that there is one elem at least in array
	max := arr[0]

	//notice start is 1
	for i := 1;i<len(arr);i++{
		if arr[i] > max{
			max = arr[i]
		}
	}

	return max


}