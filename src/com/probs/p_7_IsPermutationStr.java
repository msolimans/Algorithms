package com.probs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 4/25/17.
 */
public class p_7_IsPermutationStr {
    //given 2 strings, write a method to decide if one is a permutation of the other
    public static void main(String[] args) {
        System.out.print(isPermutationN2("ax", "ax"));

    }


    static boolean isPermutation(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;


        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i),   map.get(str1.charAt(i)) + 1);
        }

        for (int i = 0; i < str2.length(); i++) {

            int m = (int) map.getOrDefault(str2.charAt(i), 0);

            if (m <= 0)
                return false;

            map.put(str2.charAt(i), m - 1);
        }

        for (Object c : map.keySet()) {
            int m = (int) map.getOrDefault(c, 0);
            if (m > 0)
                return false;
        }


        return true;
    }


    static boolean isPermutationN2(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;


        int offsetDiff = 0;

        for (int i = 0; i < str1.length(); i++) {
            boolean occured = false;
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    occured = true;

                    if (i != j)
                        offsetDiff++;


                }

            }

            if (!occured)
                return false;
        }

        return offsetDiff > 0;

    }
}
