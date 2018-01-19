package com.leetcode;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Created by msoliman on 2/17/17.
 */
public class e_414_ThirdMaximumNumber {




    public static void main(String[] str) {



        System.out.println(thirdMax(new int[]{1,2,2}));
        System.out.println(thirdMax(new int[]{2,2,3,1}));
        System.out.println(thirdMax(new int[]{3,2,1}));

     /*   System.out.println(thirdMax1(new int[]{3,2,1}));
        System.out.println(thirdMax1(new int[]{1,2,1}));
        System.out.println(thirdMax1(new int[]{5,2,2}));
        System.out.println(thirdMax1(new int[]{5,2,3,2}));
        System.out.println(thirdMax1(new int[]{3,4,2}));
        System.out.println(thirdMax1(new int[]{4,2,2,1}));
        System.out.println(thirdMax1(new int[]{2,1}));
        System.out.println(thirdMax1(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax1(new int[]{2, 2, 3, 1,8,9,10}));
*/



    }


    //more refined solution
    public static int thirdMax(int[] nums) {
        //m1 is the greatest or the biggest number
        Integer m1 = null;
        Integer m2 = null;
        Integer m3 = null;

        for (Integer i : nums) {

            if (i.equals(m1) || i.equals(m2) || i.equals(m3))
                continue;

            if (m1 == null || i > m1) {
                m3 = m2;
                m2 = m1;

                m1 = i;
            } else if (m2 == null || i > m2) {
                m3 = m2;
                m2 = i;
            } else if (m3 == null || i > m3)
                m3 = i;
        }

        return m3 == null ? m1 : m3;


    }

    public static int thirdMax1(int[] nums) {
        //max is the biggest number
        //secMax is the 2nd biggest
        //thirdMax is the 3rd max
        if (nums.length == 0)
            return -1;

        if (nums.length == 1)
            return nums[0];

        Integer max = nums[0];
        Integer secMax = null;

        Integer third = null;


        for (Integer i = 1; i < nums.length; i++) {

            if(
                    (max != null && nums[i] == max)
                        ||    (secMax != null && nums[i] == secMax)
                        || (third != null && nums[i] == third))
                continue;

            if (nums[i] > max) {
                third = secMax;
                secMax = max;
                max = nums[i];

            } else {



                //between 2ndmax and max
                if (secMax == null || (nums[i] > secMax && nums[i] < max)) {

                    third = secMax;
                    secMax = nums[i];

                } else if (third == null || (nums[i] > third && nums[i] < secMax))
                    third = nums[i];


            }

        }


        if (third == null)
            return max;

        return third;

    }


}
