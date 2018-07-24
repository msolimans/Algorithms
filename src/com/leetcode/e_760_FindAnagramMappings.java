package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class e_760_FindAnagramMappings {

    //O(n^2) time (N Squared)
    public int[] anagramMappings0(int[] A, int[] B) {

        for(int i=0;i< A.length;i++){
            for(int j = 0;j<B.length;j++){
                if(A[i] == B[j]){
                    A[i] = j;
                    break;
                }
            }
        }

        return A;
    }


    //O(n) time complexity and O(n) space
    public int[] anagramMappings1(int[] A, int[] B) {

        //O(n) space and O(n) time complexity
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< B.length;i++){
           //indexing them into map
           map.put(B[i], i);
        }

        //we can save space here by adding the results into either A or B then return it
        //O(n) again here space and O(n) time
        int[] result = new int[A.length];
        for(int i=0;i< A.length;i++){
            result[i] = map.getOrDefault(A[i],-1);
        }

        return result;
    }





    public static void main(String[] args){
        System.out.println(
                Arrays.toString(new e_760_FindAnagramMappings().anagramMappings0(new int[]{12,28,46,32,50}, new int[]{50,12,32,46,28}))
        );

        System.out.println(
                Arrays.toString(new e_760_FindAnagramMappings().anagramMappings1(new int[]{12,28,46,32,50}, new int[]{50,12,32,46,28}))
        );

    }
}
