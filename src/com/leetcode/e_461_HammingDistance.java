package com.leetcode;

/**
 * Created by msoliman on 6/24/17.
 */
public class e_461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int diff = 0;

        for (int i = 0; i < 32; i++) {
            if (((((x & (1 << i)) > 0)) && ((y & (1 << i)) == 0))
                    ||
                    ((((x & (1 << i)) == 0)) && ((y & (1 << i)) > 0))) {
                diff++;
            }
        }

        return diff;

    }


    public int hammingDistance2(int x, int y) {
        short diff = 0;


        //XOR both and the result should ony have 1s in case of differences
        // 1 ^ 0 = 1
        // 0 ^ 1 = 1
        //1 ^ 1 = 0
        //0 ^ 0 = 0
        int r = x ^ y;

        //loop through the result and count the
        for (short i = 0; i < 32; i++) {
            if((r & (1 << i)) > 0)
                diff++;

        }


        return diff;

    }


    public static void main(String[] args) {
        System.out.println(new e_461_HammingDistance().hammingDistance(1, 4));
        System.out.println(new e_461_HammingDistance().hammingDistance2(1, 4));
    }


}
