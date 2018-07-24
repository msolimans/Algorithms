package main

import (
	"fmt"
	"../../utils"
	"math"
)

//Row With Minimum Number of 1's
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Determine the row index with minimum number of ones. The given 2D matrix has only zeroes and ones and also the matrix is sorted row wise . If two or more rows have same number of 1's than print the row with smallest index.
//
//Note: If there is no '1' in any of the row than print '-1'.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. The first line of each test case consists of two integer n and m. The next line consists of n*m spaced integers.
//
//Output:
//Print the index of the row with minimum number of 1's.
//
//Constraints:
//1<=T<=200
//1<=n,m<=100
//
//Example:
//Input:
//2
//3 3
//0 0 0 0 0 0 0 0 0
//4 4
//0 0 0 1 0 1 1 1 0 0 1 1 0 0 1 1
//
//Output:
//-1
//0
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/row-with-minimum-number-of-1s/0
//******************************************************************************************************************


func main() {

	var t int
	var n int //rows
	var m int //cols

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

		if _, err := fmt.Scan(&m); err!=nil{
			panic(err)
		}

		var item int

		r := utils.NewTwoDArray(n,m)
		//loop N times and initiate array with user input
		for i := 0; i < n; i++ {
			for j := 0;j<m;j++{
				if _, err := fmt.Scan(&item); err != nil {
					panic(err)
				}
				r.InsertAt(i,j,item)
			}

		}


		fmt.Println(getRowIndexWithMin1s(n, m, r))

	}

}


func getRowIndexWithMin1s(rows, cols int, array *utils.TwoDArray) (minIndx int) {

	//an array to keep track of counts of 1s for each row
	counts := make([]int, rows)

	for i :=0;i<rows;i++{
		for j:=0;j<cols;j++{
			if array.GetAt(i,j).(int) > 0{
				counts[i]+=1
			}
		}
	}


	minIndx = -1
	min := math.MaxInt32
	for i:=0;i<len(counts);i++{
		//make sure it has at least 1 and also the count of 1s there is less than the min
		if counts[i] >= 1 && counts[i] < min{
			//assign to min and also update minIndx (our target result)
			min = counts[i]
			minIndx = i
		}
	}

	return
}