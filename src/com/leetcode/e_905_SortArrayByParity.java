package com.leetcode;

//e_905_SortArrayByParity 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
//
//You may return any answer array that satisfies this condition.
//
//
//
//Example 1:
//
//Input: [3,1,2,4]
//Output: [2,4,3,1]
//The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//
//
//Note:
//
//1 <= A.length <= 5000
//0 <= A[i] <= 5000
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/sort-array-by-parity/
//******************************************************************************************************************

public class e_905_SortArrayByParity {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new e_905_SortArrayByParity().sortArrayByParity(new int[]{2,3,4,1})));
    }



    //In Place Swaps
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int[] sortArrayByParity(int[] A) {

        //start is a marker to the begining of odd numbers
        //end is a marker to the end of odd numbers
        int start=0,end=0;
        //temp is used for swapping operations
        int temp = 0;
        while(end <= A.length - 1) {
            if(A[end] % 2 > 0) { //that means it is odd, move end only and keep start as is
                //move end cursor more until we find even number to swap with index A[start]
                //i is the marker of the begining of odd
                end++;
            } else {
                //swap odd with even
                temp = A[start];//just temp/holder
                A[start] = A[end];//this even
                A[end]= temp; //this is odd
                start++;//move start to the new position [begining of odd numbers]
                end++;//step to the next elem
            }
        }

        return A;
    }


    //Brutforce algorithms, similar to selection sort
    //Time Complexity: O(n^2)
    public int[] sortArrayByParity2(int[] A) {
        boolean exit = false;
        for(int i=0;i<A.length-1;i++){//0 .. n-2
            if (A[i] % 2 == 0)
                continue;
            //if it is odd, find even to replace with
            for (int j=i+1;j<A.length;j++){//0 .. n-1
                if (A[j] % 2 == 0){
                    //swap
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    break;
                }

                //if we reached the last elem in array, it means all of them were check and all of them are odds
                if (j == A.length - 1){
                    exit = true;
                }

            }
            //all of them were checked, exit outer loop
            if (exit) {
                break;
            }
        }

        return A;
    }


    @Test
    public void TestsortArrayByParity(){
        Assert.assertArrayEquals(new int[]{2,4,3,1}, sortArrayByParity(new int[]{1,2,3,4}));
    }

    @Test
    public void TestsortArrayByParity2(){
        Assert.assertArrayEquals(new int[]{2,4,3,1}, sortArrayByParity2(new int[]{1,2,3,4}));

    }
}
