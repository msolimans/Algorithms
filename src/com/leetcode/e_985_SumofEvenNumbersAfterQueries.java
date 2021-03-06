package com.leetcode;

//e_985_SumofEvenNumbersAfterQueries
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//We have an array A of integers, and an array queries of queries.
//
//For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
//
//(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
//
//Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
//
//
//
//Example 1:
//
//Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
//Output: [8,6,2,4]
//Explanation:
//At the beginning, the array is [1,2,3,4].
//After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
//After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
//After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
//After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
//
//
//Note:
//
//1 <= A.length <= 10000
//-10000 <= A[i] <= 10000
//1 <= queries.length <= 10000
//-10000 <= queries[i][0] <= 10000
//0 <= queries[i][1] < A.length

//******************************************************************************************************************
//Companies: Indeed
//******************************************************************************************************************
//Link: https://leetcode.com/problems/sum-of-even-numbers-after-queries/
//******************************************************************************************************************

public class e_985_SumofEvenNumbersAfterQueries {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new e_985_SumofEvenNumbersAfterQueries().sumEvenAfterQueries(new int[]{1, 2, 3}, new int[][]{{1, 0}})));
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        if (A.length == 0 || queries.length == 0)
            return new int[]{};

        int sum = 0;
        //calc even numbers
        for (int i : A) {
            if (i % 2 == 0)
                sum += i;
        }


        int i = 0;
        int[] result = new int[queries.length];

        for (int[] item : queries) {
            int valToAdd = item[0];
            int index = item[1];

            int nval = A[index] + valToAdd;
            boolean nvalEven = nval % 2 == 0;
            boolean valEven = A[index] % 2 == 0;

            if (valEven && nvalEven) {// even => even we only add the [val to be added]
                sum += valToAdd;
            } else if (!valEven && nvalEven) {//odd => even
                sum += nval;
            } else if (valEven && !nvalEven) {//even => odd
                sum -= A[index];//remove old val
            }
            //from odd => odd => we will not change anything

            //update A
            A[index] = nval;
            result[i++] = sum;
        }

        return result;

    }

    //More Efficient one!
    //Simple idea, within the loop
    //  1) check if the elem is even, subtract it from accumlative sum
    //  2) add the new value
    //  3) add it again only in case the new value is still even
    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {

        int sum = 0;
        //calc even numbers
        for (int i : A) {
            if (i % 2 == 0)
                sum += i;
        }

        int[] result = new int[queries.length];
        int i = 0;

        for (int[] item : queries) {
            int val = item[0], index = item[1];

            if (A[index] % 2 == 0)//if current elem is even, remove it from sum
                sum -= A[index];
            A[index] += val;//add val
            if (A[index] % 2 == 0)//if even after addition, add new val
                sum += A[index];
            result[i++] = sum;
        }

        return result;

    }


    @Test
    public void TestsumEvenAfterQueries() {

        Assert.assertArrayEquals(new int[]{}, sumEvenAfterQueries(new int[]{}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}));
        Assert.assertArrayEquals(new int[]{}, sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{}));
        Assert.assertArrayEquals(new int[]{8, 6, 2, 4}, sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}));
        Assert.assertArrayEquals(new int[]{8, 6, 2, 4}, sumEvenAfterQueries2(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}));
    }

}
