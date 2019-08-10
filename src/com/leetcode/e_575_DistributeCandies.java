package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by msoliman on 5/7/17.
 */
public class e_575_DistributeCandies {
    public static void main(String[] args){
        System.out.println(run(new int[]{1,1,2,2,3,3}));
        System.out.println(run(new int[]{1,2,3,3}));

    }


    private static int run(int[] candies) {
        Set<Integer> kinds  = new HashSet<>();
        for(Integer i: candies)
            if(!kinds.contains(i))
                kinds.add(i);
        if(kinds.size() >= candies.length/2)
            return candies.length/2;

        return kinds.size();
    }
}
