package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 2/14/17.
 */
public class e_1twosum {
    //brute force
    public static int[] twoSum(int[] nums, int target) {
        for(int i =0;i<=nums.length-2;i++)
            for(int j =i+1;j<= nums.length-1;j++)

                if((nums[i]+ nums[j]) == target)
                    return new int[]{i,j};
        return new int[]{};
    }

    //[1,2,3,4,5,6,7] => 9
    //[9,2,1,5,0,3,6] => 9
    //9,2,1,5,0,3,6 -> map (n)

    //hashmap
    public  static int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> mappings = new HashMap();

        for(int i=0;i<nums.length;i++)
            mappings.put(nums[i], i);

        for(int i=0;i<nums.length; i++){
            int complement = target - nums[i];
            if(mappings.containsKey(complement) && mappings.get(complement) != i)
                return new int[]{i, mappings.get(complement)};
        }
        return new int[]{};


    }

    public static void main(String[] args) {
        //System.out.print(Arrays.toString(twoSum2(new int[]{  2,7,11,15},9)));
        //System.out.print(Arrays.toString(twoSum2(new int[]{ -3,4,3,90},0)));


    }

}
