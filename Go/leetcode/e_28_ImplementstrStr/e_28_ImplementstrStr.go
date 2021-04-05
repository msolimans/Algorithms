package e_28_ImplementstrStr

/*Description*/
//******************************************************************************************************************

//Implement strStr().
//
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//
//        Input: haystack = "hello", needle = "ll"
//        Output: 2
//        Example 2:
//
//        Input: haystack = "aaaaa", needle = "bba"
//        Output: -1
//        Clarification:
//
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
//

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/implement-strstr/
//******************************************************************************************************************

func strStr(haystack, needle string) int {

	if len(needle) == 0 {
		return 0
	}

	l := len(needle) - 1

	//O(nk)
	for i := 0; i <= len(haystack)-len(needle); i++ { //O(n)
		if compare(haystack, needle, i, i+l) { //O(k)
			return i
		}
	}

	return -1
}

func compare(h, n string, s, e int) bool {

	for i, j := s, 0; i <= e; {
		if h[i] != n[j] {
			return false
		}

		i++
		j++
	}

	return true
}
