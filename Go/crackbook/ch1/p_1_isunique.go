package main

//test 
//Chapter 1
//Is Unique
//Show Topic Tags

/**
 * Strings, Bit Manipulation
 */

/*Description*/
//******************************************************************************************************************
//Given a string, validate whether all characters coming in that string are unique
//Example
//"abcd" => true
//"abca" => false
//******************************************************************************************************************

func main() {

	//bit manipulation tests
	println(is_unique_bit("abca"))
	println(is_unique_bit("abcdeA"))
	println(is_unique_bit("ABCcba"))
	println(is_unique_bit(""))
	println(is_unique_bit("abc"))

	println("------------")

	//brute force tests
	println(is_unique("abca"))
	println(is_unique("abcdeA"))
	println(is_unique("ABCcba"))
	println(is_unique(""))

}

func is_unique_bit(str string) bool {
	result := 0
	for i := 0; i < len(str); i++ {
		indx := str[i] - 'a'

		if result&(1<<uint(indx)) > 0 {
			return false
		}

		result |= 1 << uint(indx)

	}

	return true
}

//brute force
func is_unique(str string) bool {
	for i := 0; i < len(str)-1; i++ {
		for j := i + 1; j < len(str); j++ {
			if str[i] == str[j] {
				return false
			}
		}
	}

	return true
}
