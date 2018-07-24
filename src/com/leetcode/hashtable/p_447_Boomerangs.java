package com.leetcode.hashtable;

/**
 * Created by msoliman on 5/4/17.
 */
public class p_447_Boomerangs {
    public static void main(String[] args) {

        System.out.println(run(new int[][]{{2, 1, 0}, {3, 1, 0}, {1, 1, 0}}));
        System.out.println(run(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }


    static int chkdiff(int[] i, int[] j, int[] k) {
        for (int indx = 0; indx < i.length; indx++) {

            if (Math.abs(i[indx] - j[indx]) != Math.abs(i[indx] - k[indx]))
                return 0;


        }

        return 1;

    }


    //permutation
    static int run(int[][] nums){

        return 0;
    }

    //for only 3 groups

    static int run_3(int[][] nums) {



        if(nums.length< 3)
            return 0;

        int result = 0;
        int count = 0;

        while (count < 3) {

            if (count > 0) {
                int[] first = nums[0];

                //swap now
                nums[0] = nums[count];
                nums[count] = first;
            }


            int[] i = nums[0];

            int[] j = nums[1];
            int[] k = nums[2];


            //chk diff
            result += chkdiff(i,j,k);
            result += chkdiff(i,k,j);

            count++;

        }

        return result;


    }
}
