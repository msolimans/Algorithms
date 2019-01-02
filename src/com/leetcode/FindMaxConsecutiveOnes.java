package com.leetcode;

/**
 * Created by msoliman on 2/16/17.
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] ar){
        System.out.print(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

   public static int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int max = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0) {
                current = 0;
            }
            else
                current++;

            if(max<current)
                max = current;
        }

        return  max;

    }
}
