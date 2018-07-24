package main

//Display Longest Name
//Show Topic Tags

/**
 * Arrays, Strings
 */

/*Description*/
//******************************************************************************************************************
//Given a list of names, display the longest name.

//Input: First line of input contains an integer T, the number of test cases. T test cases follows. First line of each test case contains an integer N, i.e total number of names. Next N lines contains names of different length.
//
//
//        Output: Longest name in the list of names.
//
//
//        Constraints:
//
//        1<=T<=10
//        1<=N<=10
//
//
//        Example:
//
//        Input:
//        1
//        5
//        Geek
//        Geeks
//        Geeksfor
//        GeeksforGeek
//        GeeksforGeeks
//
//        Output:
//        GeeksforGeeks
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/display-longest-name/0/
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

		current := ""
		max := ""


		//no need for array here to save memory space
		for ;n > 0;n-- {
			if _,err := fmt.Scan(&current); err != nil{
				panic("error while reading your input ")
			}
			if len(current) > len(max){
				max = current
			}

		}

		fmt.Println(max)

	}

}
