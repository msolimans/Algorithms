package com.g4g.easy;

import java.util.*;


//Next greater number set digits
//Show Topic Tags

/**
 * Searching, Maths
 */

/*Description*/
//******************************************************************************************************************
//Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.

//Input:
//
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is n,n is the number.
//
//        Output:
//
//        Print the greater number than n with same set of digits and if not possible then print "not possible" without double quote.
//
//        Constraints:
//
//        1 ≤ T ≤ 100
//        1 ≤ n ≤ 100000
//
//        Example:
//
//        Input
//        2
//        143
//        431
//
//        Output
//        314
//        not possible
//******************************************************************************************************************
//Companies: Samsung, Oxigen Wallet, Morgan-Stanley, Microsoft, Hike, Amazon, Adobe, Zillious, Vizury Interactive S, Snapdeal
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/next-greater-number-set-digits/0
//******************************************************************************************************************

public class NextGreaterNumberSetDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            System.out.println (run(scan.nextInt()));
        }
    }

    //Analysis (Thoughts)
    /**
    first thought came to my mind is to extract the digits and sort the number in desc order then compare with the original number again if it is bigger that is
      however this idea looks good but I will tell you it is not gonna be working in some cases where we have number like 4 1 3 3 so if we did this algorithm it will make 4 3 3 1
      however the correct answer should be 4 3 1 3 did you notice we just moved only one digit to get ONLY THE NEXT number
    New algorithm:
      is to extract the numbers and to compare from left to right if there is a digit bigger than the current digit, if so swap and that is it (we got it)
      let's trace it on 4 1 4
          1 > 4   (NO)    -> SKIP
          4 > 1   (YES)   -> SWAP
          4 4 1   (RESULT)
      Another trace on 4 1 3 3 (the one that caused a problem)
          1 > 4   (NO)    -> SKIP
          3 > 1   (YES)   -> SWAP
          4 3 1 3 (RESULT)
      Another trace on 4 5 6 6 7
          5 > 4   (NO)    -> SKIP
          6 > 5   (YES)   -> SWAP
          4 6 5 6 7 (RESULT)      => notice this wrong answer as we should have 4 5 6 7 6 the next bigger
          Did you notice we can do the swap from RIGHT to LEFT to get exactly the next bigger number
      Let's trace on 1 2 1 0 2 1 (From RIGHT to LEFT)
          1 > 2   (NO)    -> SKIP
          1 > 0   (YES)   -> SWAP and SHIFT - I CAN LITERALLY SAY INJECT/INSERT and SHIFT to the RIGHT all elements
          1 2 1 1 0 2
      Another example:
           4 2 3 1
          1 > 3   (NO)    -> SKIP
          1 > 2   (NO)    -> SKIP
          1 > 4   (NO)    -> SKIP
          START NOW WITH 3
          3 > 2   (YES)   -> SWAP and SIFT
          4 3 2 1
      One problem: check this number 4 6 1 0
          0 > 1   NO
          0 > 6   NO
          0 > 4   NO
          1 > 6   NO
          1 > 4   NO
          6 > 4   YES     -> insert it and SHIFT
          6 4 1 0         => however this wrong number as the correct one is 6 0 1 4
          Did you notice that it is not just shifting but it is sorting digits after the SWAP operation happened to get THE NEXT digit
      One last problem I promise :) check this number 26963
      If you applied this kind of loop in algorithm you will end up in the first iteration with 2 swapped with 3 resulting in 32669 however this is a wrong answer
      so loop should be changed to move and compare all previous elements with the current element in the loop if we noticed one bigger swap and do the same algorithm
          It works finally :) hope you understand and enjoyed
     */
    static String run(int n) {
        List<Integer> arr = new ArrayList<>();

        int indx = 0;

        //notice the digits  are stored in reversed order
        while(n > 0){
            int remainder = n % (int) Math.pow(10, indx+1);
            n = n - remainder;
            arr.add(remainder / (int) Math.pow(10, indx));
            indx++;
        }

        int[] digits = arr.stream().mapToInt(Integer::intValue).toArray();

        //move through the array and swap any element in case we got one otherwise return "not possible"
        //notice the upper bound of i = size - 2 to avoid exception in j = i+1
        for(int j=1;j<digits.length;j++){
            for(int i=0; i<= j; i++){
                if(digits[i] > digits[j]){
                    //swap
                    int current = digits[i];
                    digits[i] = digits[j];
                    digits[j] = current;
                    //we can use PQ or make another array to sort separately and then clone it back to the original one here (a lot of ways)
                    //sort desc. until that digit (0 .... j - 1)
                    PriorityQueue<Integer> pqDigits = new PriorityQueue<>(Collections.reverseOrder());

                    //all elements before swapped one (0 .... j - 1)
                    for(int k=0;k<j;k++){
                        pqDigits.add(digits[k]);
                    }

                    //Extract them now in sorted order and put them back again
                    for(int k = 0;k<j;k++){
                        int hj = pqDigits.poll();
                        digits[k] =  hj;
                    }

                    //return the result
                    return Integer.toString(result(digits));
                }
            }
        }

        return "not possible";
    }

    //digits comes from right to left
    //simply it is decimal number and you can calc using powers of 10s
    static int result(int[] reversedDigits){

        int result = 0;

        for(int i =0;i<reversedDigits.length;i++){
            result += reversedDigits[i] * (int) Math.pow(10, i);
        }

        return result;
    }
}
