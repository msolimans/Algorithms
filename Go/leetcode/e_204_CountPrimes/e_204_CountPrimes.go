package e_204_CountPrimes

import (
	"math"
)

//Problem Title
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************

//Description Goes here
//Count the number of prime numbers less than a non-negative number, n.
//
//Example:
//
//Input: 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: https://leetcode.com/problems/count-primes/
//******************************************************************************************************************

func main() {

}

func countPrimes(n int) int {

	nonPrimes := make([]bool, n)
	//mark non-prime numbers
	//recall for any prime number it is divisible only by itself and 1
	//we can only check the range from 2 .. sqrt(n) if the number is divisible by any number in this range so it is not prime
	//so we loop from 2 .. sqrt(n) to find out only NON-prime numbers .. from number's factors discover non prime numbers
	for i := 2; i <= int(math.Sqrt(float64(n))); i++ {
		//we start loop from i^2 .. n .. multiples of i such that it doesn't exceed n
		//examples:
		// 2*2 = 4 which is not a prime .. 2*2+2 = 6 ... 2*2+2+2=8, these are not primes
		// 3*3 = 9 which is not a prime .. 3*3+3 = 12 .. and so on!
		for j := i * i; j < n; j += i {
			nonPrimes[j] = true
		}
	}
	//we count anything in the array that were not marked as NON-prime
	count := 0
	for i := 2; i < n; i++ {
		if nonPrimes[i] == false {
			count++
		}
	}

	return count
}
