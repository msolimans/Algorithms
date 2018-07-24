package main

import "regexp"

//
//Reverse an array without affecting special characters
//Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.
//
//Examples:
//
//Input:   str = "a,b$c"
//Output:  str = "c,b$a"
//Note that $ and , are not moved anywhere.
//Only subsequence "abc" is reversed
//
//Input:   str = "Ab,c,de!$"
//Output:  str = "ed,c,bA!$"
//Ref: https://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/


func main() {
	if res, err := swap("Ab,c,de!$"); err != nil {
		println("Error :" , err)
	} else {
		println(res)
	}
}

func swap(str string) (string, error) {
	i := 0
	j := len(str) - 1
	re, err := regexp.Compile("[a-zA-Z1-9]")

	if err != nil {
		return "", err
	}


	runes := []rune(str)
	for i < j  {

		if !re.Match([]byte(string(runes[i]))){
			i++
			continue
		}

		if !re.Match([]byte(string(runes[j]))){
			j--
			continue
		}

		temp := runes[i]

		runes[i] = runes[j]
		runes[j] = temp
		i++
		j--
	}

	return string(runes), nil

}
