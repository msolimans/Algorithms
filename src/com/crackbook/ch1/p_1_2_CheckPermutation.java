package com.crackbook.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 5/8/17.
 */
public class p_1_2_CheckPermutation {
    public static void main(String[] args){
        System.out.println(run_xor("a", "a"));
        System.out.println(run_map("abc", "abc"));
        System.out.println(run_sort("abc", "abc"));
        System.out.println(run_array("abc", "abc"));
    }


    //in case we supposed we have only characters
    static boolean run_array(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        int[] letters = new int[128];

        for(char c: s1.toCharArray()){
            letters[c]++;
        }

        for(char c: s2.toCharArray()){
            letters[c]--;
            if(letters[c] < 0)
                return false;

        }

        return true;
    }


    static boolean run_sort(String s1,String s2){
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);

        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s2Arr);

        s1 = new String(s1Arr);
        s2 = new String(s2Arr);

        return  s1.equals(s2);
    }


    static boolean run_map(String s1, String s2){

        if(s1 == null || s2 == null || s1.length() != s2.length())
            return false;


        Map<Character, Integer> map = new HashMap<>();

        for(int i =0;i<s1.length();i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0) + 1);
        }

        for(int i =0;i<s2.length();i++){
            int ch = map.getOrDefault(s2.charAt(i),0);
            if(ch == 0)
                return false;
            map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);

        }

        for(Character ch: map.keySet()){
            int i = map.get(ch);
            if(i > 0)
                return false;
        }

        return true;


    }

    static boolean run_xor(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        int result = 0;

        for(int i=0;i<s1.length();i++)
            result ^= s1.charAt(i);

        for(int i=0;i<s2.length();i++)
            result ^= s2.charAt(i);

        return result == 0;

    }
}
