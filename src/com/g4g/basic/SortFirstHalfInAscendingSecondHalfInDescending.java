package com.g4g.basic;

import java.util.Arrays;
import java.util.Scanner;

//Problem Title
//Show Topic Tags

/**
 * Arrays, Sorting
 */

/*Description*/
//******************************************************************************************************************
// Given an array of integers, sort the first half of the array in ascending order and second half in descending order.

//Input:
//        The first line consists of an integer T i.e number of test cases. The first line of each test case consists of an integers N.The next line consists of N spaced integers.
//
//        Output:
//        Print the required output.
//
//        Constraints:
//        1<=T<=100
//        1<=N<=100
//        1<=a[i]<=1000
//
//        Example:
//        Input:
//        2
//        9
//        5 2 4 7 9 3 1 6 8
//        6
//        1 2 3 4 5 6
//
//        Output:
//        1 2 3 4 9 8 7 6 5
//        1 2 3 6 5 4
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/sort-first-half-in-ascending-and-second-half-in-descending/0/
//******************************************************************************************************************

public class SortFirstHalfInAscendingSecondHalfInDescending {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {

            int l = scan.nextInt();
            int[] arr = new int[l];

            int[] counting = new int[1000 + 1];

            for(int i =0;i<l;i++)
                arr[i] = scan.nextInt();

            //System.out.println(run(arr));
            System.out.println(countingSort(arr, counting));
        }
    }




    //using counting sort
    static  String countingSort(int[] arr, int[] counting){

        for(int i =0;i<counting.length;i++){
            //as inputs are all positives we don;t care about sign
            counting[i] = 0;
        }

        //occurence of elements in arr
        for(int i = 0; i< arr.length;i++){
            counting[arr[i]] += 1;
        }

        //calc mid of the array
        int mid = arr.length / 2;

        //indx maintains current index to be filled in the result array
        int indx  = 0;

        boolean exit = false;

        //loop in asc and fill until mid
        for(int i =0;i<counting.length;i++){

            if(counting[i] >= 1){
                for(int j = 0;j<counting[i];j++) {
                    arr[indx] = i;

                   // counting[i] -= 1;
                    if (++indx > mid - 1) {
                        exit = true;
                        break;
                    }
                }
            }

            if(exit)
                break;


        }

        exit = false;

        //loop in desc. and fill from end until you finish all rest elements
        for(int i =counting.length - 1;i >= 0;i--){

            if(counting[i] >= 1) {
                for(int j = 0;j<counting[i];j++) {
                    arr[indx] = i;

                    if (++indx > arr.length - 1) {
                        exit = true;
                        break;
                    }
                }
            }

            if(exit)
                break;
        }

        return Arrays.toString(arr).replaceAll("[\\,\\[\\]]", "");

    }



    //using selection sort items are of size 100
    static String run(int[] arr) {
         int mid = arr.length /2;

        int min, minIndx, temp;

         for(int i =0;i<mid;i++){
             min = arr[i];
             minIndx = i;

             //get min
             for(int j = i+1;j<arr.length;j++)
                 if(arr[j]< min) {
                     min = arr[j];
                     minIndx = j;
                 }

             //swap
             temp  = arr[i];
             arr[i] = min;
             arr[minIndx] = temp;

         }

        int max, maxIndx;

         for(int i = mid; i< arr.length;i++){

             max = arr[i];
             maxIndx = i;

             //get max
             for(int j = i+1;j<arr.length;j++)
                 if(arr[j] > max) {
                     max = arr[j];
                     maxIndx = j;
                 }

             if(i != maxIndx) {
                 //swap
                 temp = arr[i];
                 arr[i] = max;
                 arr[maxIndx] = temp;
             }
         }

         return Arrays.toString(arr).replaceAll("[\\,\\[\\]]", "");

    }


    //we can use insertion sort or any type of sort though
}
