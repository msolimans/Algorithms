package main

//Problem Title
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************

//Description Goes here

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

		run(arr)

	}

}

//cast or change return type based on problem's needs
func run(arr []int) {
	//my function implementation should go here
	//fmt.Println(arr)
}
