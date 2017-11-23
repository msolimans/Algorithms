package com.g4g.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


//Even and odd elements at even and odd positions
//Show Topic Tags

/**
 * Array
 */

/*Description*/
//******************************************************************************************************************
//Given an array. The task is to arrange the array such that odd elements occupy the odd positions and even elements occupy the even positions. The order of elements must remain same. Consider zero-based indexing. After printing according to conditions, if remaining, print the remaining elements as it is.

//Input:
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.
//
//        Output:
//        For each test case, in a new line print the arranged array.
//
//        Constraints:
//        1<=T<=100
//        1<=N<=105
//        1<=A[i]<=105
//
//        Example:
//        Input:
//        2
//        6
//        1 2 3 4 5 6
//        4
//        3 2 4 1
//        Output:
//        2 1 4 3 6 5
//        2 3 4 1
//******************************************************************************************************************
//Companies: Amazon
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/even-and-odd-elements-at-even-and-odd-positions/0
//******************************************************************************************************************

public class EvenAndOddNumbersAtEvenAndOddPositions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            int[] arr = new int[scan.nextInt()];
            for(int i =0;i<arr.length;i++)
                arr[i] = scan.nextInt();


            System.out.println(
                    Arrays.toString(run1(arr)).replaceAll("[\\[\\]]\\,", "").trim()
            );
        }
    }


    //O(n) however we need O(n) space too.
    //preserve 2 queues one for odd and the other for even
    //fill both queues then start fill the array again from queues
    static int[] run1(int[] arr){
        LinkedList<Integer> odd = new LinkedList<Integer>();
        LinkedList<Integer> even = new LinkedList<Integer>();

        for(int i=0;i< arr.length;i++){
            if(arr[i] % 2 == 0)
                even.add(arr[i]);
            else
                odd.add(arr[i]);
        }

        for(int i=0;i<arr.length;i++){
            if(i%2 == 0) {
                //make sure even has elements first, if not we are printing all remaining elements from other queue
                if (!even.isEmpty())
                    arr[i] = even.pollFirst();
                else
                    arr[i] = odd.pollFirst();
            }else{
                //make sure odd has elements first, if not we are printing all remaining elements from other queue
                if (!odd.isEmpty())
                    arr[i] = odd.pollFirst();
                else
                    arr[i] = even.pollFirst();

            }


        }

        return  arr;

    }




    //we should have another solution
    //it is some kind of selection sort
    //O(n^2), no space required
    static int[] run(int[] arr) {

        int i1= 0;
        int i2 = 0;
        while(i1 < arr.length - 1){ // loop until previous last element

            if((arr[i1] % 2 == 0 && i1 % 2 > 0) || //current element's value is even and index is odd
            (arr[i1] % 2 > 0 && i1 % 2 == 0)){ //current element's value is odd and index is even

                //start find the next
                if(i1 % 2 == 0) {//even, find next even


                    int prev = arr[i1];
                    i2 = i1 + 1;

                    while(i2<arr.length && arr[i2] % 2 > 0){

                        int tmp = arr[i2];
                        arr[i2] = prev;
                        prev = tmp;
                    }


                    if(i2 == arr.length -1)
                        return arr;

                }
                else{//find next odd

                }
            }

            i1++;

        }


        return  arr;
    }
}
