package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msoliman on 2/17/17.
 */
public class e_448_NumbersDisappeared {
    public static void main(String[] str){
        System.out.print(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();

        for(int i =0;i< nums.length; i++){
            int currentIndx = Math.abs(nums[i]) - 1;
            if(nums[currentIndx] >0)
                nums[currentIndx] = -1*nums[currentIndx];
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0)
                result.add(i+1);
        }




        return  result;

    }

}
