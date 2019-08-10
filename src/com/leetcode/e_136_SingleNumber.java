package com.leetcode;

/**
 * Created by msoliman on 5/4/17.
 */
public class e_136_SingleNumber {
    public static void main(String[] args){
        System.out.println(run(new int[]{1,2,3,2,1}));
        System.out.println(run(new int[]{1}));

    }

    private static int run(int[] nums) {
        int result = 0;

        for (int i :
                nums) {
            result ^= i;
        }

        return result;

    }
}
