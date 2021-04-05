package main

import (
	"fmt"
)

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//Example 1:
//
//Input: ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//Note:
//
//All given inputs are in lowercase letters a-z.

//******************************************************************************************************************
//Companies: Amazon | 5  Microsoft | 2  IXL | 2  Cisco | 2  Twilio | 2  Snapchat | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/longest-common-prefix/
//******************************************************************************************************************

func main() {
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", "fly"}))
}

func commonStr(s1, s2 string) string {
	if len(s1) > len(s2) {
		return commonStr(s2, s1)
	}

	i := 0
	for i = 0; i < len(s1); i++ {
		if s1[i] != s2[i] {
			break
		}
	}

	return s1[0:i]
}

func longestCommonPrefix(strs []string) string {
	common := strs[0]
	for _, s := range strs {
		common = commonStr(common, s)
	}
	return common
}
