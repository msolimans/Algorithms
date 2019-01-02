package main

//Upper Case Conversion
//Show Topic Tags

/**
 * Arrays
 */

/*Description*/
//******************************************************************************************************************
//Given a string , write a program to title case every first letter of words in string.
//
//Input:
//The first line consists of an integer T i.e number of test cases. The first and only line of each test case consists of a string s.
//
//Output:
//Print the required output.
//
//Constraints:
//1<=T<=100
//1<=|Length of string|<=1000
//
//Example:
//Input:
//1
//I love programming
//
//Output:
//I Love Programming
//******************************************************************************************************************
//Companies: Nagarro
//******************************************************************************************************************
//Link: https://practice.geeksforgeeks.org/problems/upper-case-conversion/0
//******************************************************************************************************************

import (
	"bufio"
	"fmt"
	"os"
	"regexp"
	"strings"
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
		//scan family is usually used for spaces
		scanner := bufio.NewScanner(os.Stdin)
		scanner.Scan()
		s := scanner.Text()

		if err := scanner.Err(); err != nil {
			os.Exit(1)
		}

		println(upperCaseConversion(s))
		println(upperCaseConversion1(s))
		println(upperCaseConversion2(s))

	}

}

//using regular loop O(n)
func upperCaseConversion(str string) string {
	//as string is immutable cost of operation will be better if we can convert it to an array

	//copy str into []byte
	arr := []byte(str)
	up := true
	//loop through array
	for i, c := range arr {
		if c == ' ' {
			up = true
		} else if up {
			arr[i] = byte(strings.ToUpper(string(arr[i]))[0])
			up = false
		}
	}

	//convert from []byte to string
	return string(arr)
}

//split method, everytime we added strings it needs new memory allocations
func upperCaseConversion1(str string) string {

	strs := strings.Split(str, " ")
	result := ""
	for _, s := range strs {
		result += strings.Title(s) + " "
	}

	return result
}

//using reguar expression
func upperCaseConversion2(str string) string {
	re := regexp.MustCompile(`\s+([a-z])`)
	return strings.Title(re.ReplaceAllStringFunc(str, func(match string) string {
		return strings.ToUpper(match)
	}))

}
