package com.g4g.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Problem Title
//Show Topic Tags

/**
 * Arrays, Hashing
 */

/*Description*/
//******************************************************************************************************************
// Maximum possible sum
//        Given two arrays A and B of equal number of elements. The task is to find the maximum sum possible of a window in array B such that elements of same window in array A are unique.
//
//        Input:
//        The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.  First line of each test case starts with an integer N denoting the size of the arrays A and B. Second line of input contains N space separated integers Of array A. And third line of input contains N space separated integers Of array B.
//
//        Output:
//        For each test case, print the maximum possible sum In new line.
//
//        Constraints:
//        1<=T<=300
//        1<=N<=104
//        1<=A[i]<=106
//        1<=B[i]<=106
//
//        Example:
//        Input:
//        2
//        7
//        0 1 2 3 0 1 4
//        9 8 1 2 3 4 5
//        5
//        0 1 2 0 2
//        5 6 7 8 2
//        Output:
//        20
//        21
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************

public class MaximumPossibleSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int len = 0;
        while (T-- > 0) {

            len = scan.nextInt();
            int[] arr1 = new int[len];
            int[] arr2 = new int[len];

            //read all items and put into arr1
            for(int i =0;i<arr1.length;i++){
                arr1[i] = scan.nextInt();
            }

            //read all items and put into arr2
            for(int i =0;i<arr2.length;i++){
                arr2[i] = scan.nextInt();
            }

            //call your function of arr1 and arr2
            System.out.println(run(arr1,arr2));
        }
    }


    static int run(int[] arr1, int[] arr2) {
        int start = 0;
        int max = 0;
        int current = 0;
        Map<Integer, Integer> indices = new HashMap<>();

        for(int i=0;i<arr1.length;i++){
            ///as long as this item did not show up before add it to the indices map and add the value from arr2 into current element (once we will see a duplication we should update max)
            if(!indices.containsKey(arr1[i])){
                indices.put(arr1[i], i);
                current += arr2[i];
            }
            else{
                //shrink and expand window now (start represents the start index of the window)
                if(current > max)
                    max = current;

                //get current index (last occurrence of this element)
                int index = indices.get(arr1[i]);

                //update current, remove or subtract all way down to start
                for(int j=index;j>= start;j--){
                    current -= arr2[j];

                    //remove from map now all elements you have excluded
                    indices.remove(arr1[j]);
                }

                //add current element
                current += arr2[i];

                //update indices
                indices.put(arr1[i], i);

                //update start to exclude element that caused duplication/repetition
                start = index + 1;

            }
        }

        //required here as we might not see any duplication at all in the array (e.g. 1 2 3 4 5)
        return  max > current? max: current;

    }
}
