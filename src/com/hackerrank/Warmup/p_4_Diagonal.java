package com.hackerrank.Warmup;

import java.util.Scanner;

/**
 * Created by msoliman on 5/9/17.
 * https://www.hackerrank.com/challenges/diagonal-difference
 * Given a square matrix of size , calculate the absolute difference between the sums of its diagonals.

 Input Format

 The first line contains a single integer, . The next  lines denote the matrix's rows, with each line containing space-separated integers describing the columns.

 Constraints


 Output Format

 Print the absolute difference between the two sums of the matrix's diagonals as a single integer.

 Sample Input

 3
 11 2 4
 4 5 6
 10 8 -12
 Sample Output

 15
 Explanation

 The primary diagonal is:

 11
 5
 -12
 Sum across the primary diagonal: 11 + 5 - 12 = 4

 The secondary diagonal is:

 4
 5
 10
 Sum across the secondary diagonal: 4 + 5 + 10 = 19
 Difference: |4 - 19| = 15
 */
public class p_4_Diagonal {

    public static void main(String[] args) {

        //System.out.println(diagonalDiff(new int[][]{{11,2,4},{4,5,6},{10,8,-12}}));
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] nums = new int[length][length];
        int r=0;
        int c=0;
        length = length * length;

        while(--length>=0){

            nums[r][c] = sc.nextInt();

            if(c==nums.length-1) {
                c = 0;
                r++;
            }else
                c++;

        }
        System.out.println(diagonalDiff(nums));

    }

    static int diagonalDiff(int[][] nums){
        int left = 0;
        int right = 0;
        int j = nums.length-1;
        for(int i=0;i<nums.length;i++){
            left += nums[i][i];

            right += nums[i][j];
            j--;

        }

        return Math.abs(left- right);
    }
}
