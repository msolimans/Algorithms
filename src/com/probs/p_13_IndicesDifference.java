package com.probs;

/**
 * Created by msoliman on 5/2/17.
 * Given an array of integers and an integer K, find out whether there are two distinct indices I and J
 * such that nums1[I]=nums2[J] and the absolute diff between I and J equals K
 */
public class p_13_IndicesDifference {
    public static void main(String[] args){

        System.out.println(diff(new int[]{1,2,3,4}, new int[]{1,2,3,4,2},3));
        System.out.println(diff(new int[]{1,2,3,4}, new int[]{1,2,3,4,5},3));
        System.out.println(diff(new int[]{1,2,1,1,1}, new int[]{1,2},3));

    }


    static boolean diff(int[] nums1, int[] nums2, int k){
        int i = nums1.length - 1;

        while(i >= 0) {

            if(i - nums2.length - 1 > k)
                continue;


            for(int j = 0; j < nums2.length;){



                int diff = i - j;

                if(diff < 0)
                    diff = -diff;

                if(diff == k) {
                    if (nums1[i] == nums2[j])
                        return true;
                    else
                        break;

                }

                if(diff > k)
                    j+=diff-k;
                else
                    j+=k-diff;

            }

            i--;
        }


        return false;

    }

}
