package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 5/7/17.
 */
public class e_205_IsomorphicString {
    public static void main(String[] args) {

//        System.out.println(run("egg", "add"));
        System.out.println(run_arrays("foo", "bar"));
        System.out.println(run_arrays("paper", "title"));
        System.out.println(run_arrays("ab", "aa"));
        System.out.println(run_arrays("ab", "ca"));
    }

    static boolean run_arrays(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];


        for (int i = 0; i < s.length(); i++) {
            //check last encountered indexes of both characters .. if both of them were different means they are different pairs than before .. return false
            if (map1[s.charAt(i)] != map2[t.charAt(i)])
                return false;

            //save into the array the indexes of characters to the current index in the string .. once we encounter any similar pairs again we have to find them equal

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;

        }

        return true;

    }

    static boolean run(String s, String t) {

        if (s.length() != t.length())
            return false;


        Map<Character, Character> pairs = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            Character ch1 = s.charAt(i);
            Character ch2 = t.charAt(i);

            if (pairs.containsKey(ch1)) {
                if (!pairs.get(ch1).equals(ch2))
                    return false;
            } else {
                //check by value .. (not key) .. it doesn't contain the key nor the value
                if (!pairs.containsValue(ch2))
                    pairs.put(ch1, ch2);
                else
                    //it doesn;t contain the key however the value is assigned to a different key other than ch1
                    return false;

            }


        }

        return true;

    }

}
