package main

// Problem 1
// Check if the string provided has all lower case characters
//All small letters came in the string however you might have also some capital letters in the same time but we care only to
//check if all small letters came into the string
func main() {
	println(run("ABC"))                           //all caps letters
	println(run("abcdefghijklmnopqrstuvwxyz"))    // all small letters
	println(run("abcdefghijklmnopqrstuvwxyzAAA")) // all small letters, having more caps letters
	println(run("abcdefghijklmnpqrstuvwxyz"))     //o is missing
	println(run("abcdefghijklmnOpqrstuvwxyz"))    //O is capital

	println("-----------")

	println(run1("ABC"))                          //all caps letters
	println(run1("abcdefghijklmnopqrstuvwxyz"))   // all small letters
	println(run("abcdefghijklmnopqrstuvwxyzAAA")) // all small letters, having more caps letters
	println(run1("abcdefghijklmnpqrstuvwxyz"))    // o is missing
	println(run1("abcdefghijklmnOpqrstuvwxyz"))   //O is capital

}

func run(str string) bool {

	//loop through the chars and store value into its corresponding bit, loop through the 28 bits and make sure they are all set to ones
	var chars []int = make([]int, 26)

	for _, v := range str {
		if sv := int(v); sv >= 97 && sv <= 122 {
			chars[sv%26]++
		}
	}

	for _, c := range chars {

		if c == 0 {
			return false
		}
	}
	return true

}

func run1(str string) bool {
	var result uint

	for _, v := range str {
		if sv := int(v); sv >= 97 && sv <= 122 {
			result |= (1 << uint(sv%26))
		}
	}

	for i := 0; i < 26; i++ {
		if (result & (1 << uint(i))) == 0 {
			return false
		}
	}

	return true

}
