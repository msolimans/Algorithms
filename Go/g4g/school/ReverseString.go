package main

//Reverse a string
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given a string S as input. You have to reverse the given string.
//
//Input: First line of input contains a single integer T which denotes the number of test cases. T test cases follows, first line of each test case contains a string S.
//
//Output: Corresponding to each test case, print the string S in reverse order.
//
//Constraints:
//
//1<=T<=100
//3<= length(S) <=1000
//
//
//Example:
//
//Input:
//3
//Geeks
//GeeksforGeeks
//GeeksQuiz
//
//Output:
//skeeG
//skeeGrofskeeG
//ziuQskeeG
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/sum-of-array-elements/0
//******************************************************************************************************************

import (
	"fmt"
	"github.com/golang-collections/collections/stack"
)

func main() {

	var t int


	//read T
	if _, err := fmt.Scan(&t); err != nil {
		panic(err)
	}

	//like while in most other languages
	for t > 0 {
		t--

		var current []byte

		//scan into byte array directly to be able to modify and play with the string
		if _, err := fmt.Scan(&current); err != nil {
			panic(err)
		}

		fmt.Println(reverseString(current))
		fmt.Println(string(reverseStringUsingStack(current)))
	}



}


//reverse byte array and returns result as string
func reverseString(arr []byte) string {

	//very simple 2 variables maintains the indexes and swap
	for s,e := 0, len(arr)-1; s < e; s, e = s+1, e -  1 {
		//swap
		temp := arr[s]
		arr[s] = arr[e]
		arr[e] = temp
	}


	//convert to string
	return string(arr)

}


//reverse byte array and returns result as string
func reverseStringUsingStack(arr []byte) []byte {

	 //push all elems from array into stack

	 stack := stack.New()
	 for _,b := range arr{
		 stack.Push(b)
	 }
	 //pop from stack back into array
	for i:=0;stack.Len() > 0;i++{
		if b, ok := stack.Pop().(byte); ok != true{
			//type assertion
			arr[i] = b
		}
	}

	return arr
}



