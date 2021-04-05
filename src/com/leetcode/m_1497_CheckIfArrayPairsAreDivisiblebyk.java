package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//m_1497_CheckIfArrayPairsAreDivisiblebyk
//Given an array of integers arr of even length n and an integer k.
//
//We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
//
//Return True If you can find a way to do that or False otherwise.
//
//
//
//Example 1:
//
//Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
//Output: true
//Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
//Example 2:
//
//Input: arr = [1,2,3,4,5,6], k = 7
//Output: true
//Explanation: Pairs are (1,6),(2,5) and(3,4).
//Example 3:
//
//Input: arr = [1,2,3,4,5,6], k = 10
//Output: false
//Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.
//Example 4:
//
//Input: arr = [-10,10], k = 2
//Output: true
//Example 5:
//
//Input: arr = [-1,1,-2,2,-3,3,-4,4], k = 3
//Output: true
//
//
//Constraints:
//
//arr.length == n
//1 <= n <= 105
//n is even.
//-109 <= arr[i] <= 109
//1 <= k <= 105
//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
public class m_1497_CheckIfArrayPairsAreDivisiblebyk {
    public boolean canArrange(int[] arr, int k) {
        //modulus to cut the number below k
        //create array of size k
        //loop thru array of size k and make sure elems are divisible by 2

        Map<Integer, Integer> mpBelowK = new HashMap<>();

        for (int i : arr) {
            int key = i % k;
            if (key < 0)
                key += k; //make it positive (-1 => 4 - -2 => 3)
            mpBelowK.put(key, mpBelowK.getOrDefault(key, 0) + 1);
        }

        for (int i : arr) {
            int target = i % k;
            if (target < 0)
                target += k; //make it positive (-1 => 4 - -2 => 3)

            target = k -  target;
            if (target == 0)
                continue; //skip zeros will check later

            if (mpBelowK.containsKey(target)) {
                mpBelowK.put(target, mpBelowK.get(target) - 1);
                if (mpBelowK.get(target) == 0)
                    mpBelowK.remove(target);
            }
        }

        if (mpBelowK.containsKey(0)) {
            if (mpBelowK.get(0) % 2 > 0)
                return false;
            mpBelowK.remove(0);
        }


        return mpBelowK.size() == 0;
    }

    //pretty similar soln with optimization (beats other solns with 98% in leetcode)
    public boolean canArrange1(int[] arr, int k) {
        //frequencies of items (make all items less than k and then record how many occurrence of each one)
        int[] freqs = new int[k];

        //count occurrence
        int t =0;
        for(int i: arr){
            t = i%k;
            //make sure we convert negative to positive to avoid out of bound exception
            if (t<0)
                t += k;

            freqs[t] +=1;
        }

        //we should have zeros count as even number
        if(freqs[0] %2 != 0)
            return false;

        //we split array in 2 halves - first half should plus second half should give us K otherwise return false
        for(int i=1;i<=freqs.length/2;i++) {
            if(freqs[i] != freqs[k-i])
                return false;
        }

        return true;
    }

    @Test
    public void TestcanArrange() {
        Assert.assertEquals(true, canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
        Assert.assertEquals(true, canArrange(new int[]{1,2,3,4,5,6}, 7));
        Assert.assertEquals(false, canArrange(new int[]{1,2,3,4,5,6}, 10));
        Assert.assertEquals(true, canArrange(new int[]{-10,10}, 2));
        Assert.assertEquals(true, canArrange(new int[]{-1,1,-2,2,-3,3,-4,4}, 3));
        /////
        Assert.assertEquals(true, canArrange1(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
        Assert.assertEquals(true, canArrange1(new int[]{1,2,3,4,5,6}, 7));
        Assert.assertEquals(false, canArrange1(new int[]{1,2,3,4,5,6}, 10));
        Assert.assertEquals(true, canArrange1(new int[]{-10,10}, 2));
        Assert.assertEquals(true, canArrange1(new int[]{-1,1,-2,2,-3,3,-4,4}, 3));
        Assert.assertEquals(false, canArrange1(new int[]{-1,-1,-1,-1,2,2,-2,-2}, 3));
    }

}
