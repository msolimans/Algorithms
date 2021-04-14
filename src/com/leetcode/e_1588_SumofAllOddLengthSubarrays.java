package com.leetcode;
//1588. Sum of All Odd Length Subarrays
//Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
//
//A subarray is a contiguous subsequence of the array.
//
//Return the sum of all odd-length subarrays of arr.
//
//
//
//Example 1:
//
//Input: arr = [1,4,2,5,3]
//Output: 58
//Explanation: The odd-length subarrays of arr and their sums are:
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
//Example 2:
//
//Input: arr = [1,2]
//Output: 3
//Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
//Example 3:
//
//Input: arr = [10,11,12]
//Output: 66
//
//
//Constraints:
//
//1 <= arr.length <= 100
//1 <= arr[i] <= 1000

import org.junit.Assert;
import org.junit.Test;

public class e_1588_SumofAllOddLengthSubarrays {


    //O(n) solution
    public int sumOddLengthSubarrays1(int[] arr) {
        //e.g. [1,4,2,5,3]
        //      0 1 2 3 4 => 5 - 0 * 1
        //                =>
        int sum = 0 ;
        for(int i=0;i<arr.length;i++ ){
            int totalCount = (arr.length - i) * (i+1); //all subarrays count => begins ends or in middle of this index
            int oddCount = (totalCount - 1) / 2 + 1; //half of total count
            sum += oddCount * arr[i];//how many times we will need to add this number to the sum
        }
        return sum;
    }

    //O(n^2) soln
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i =0;i<arr.length;i++) {
            sum += arr[i];
            int isum = arr[i];
            for(int j=i+1;j<arr.length;j++){
                isum += arr[j];
                if((j-i) % 2 > 0) {//diff between current position and main position is odd => we skip summation
                    continue;
                }
                //we sum here in case we get even steps (moves away from main position) which means it is odd x y z => x and y 1-0%2 is odd while x and z 2-0%2 is even
                sum += isum;
            }
        }
        return sum;
    }


    @Test
    public void TestsumOddLengthSubarrays() {
        Assert.assertEquals(58, sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        Assert.assertEquals(3, sumOddLengthSubarrays(new int[]{1,2}));
        Assert.assertEquals(66, sumOddLengthSubarrays(new int[]{10,11,12}));
    }


}
