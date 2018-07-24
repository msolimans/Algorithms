package com.crackbook.ch1;

import java.beans.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by msoliman on 5/8/17.
 */
public class p_1_1_IsUnique {

    /*Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
    Hints: #44, # 777, # 732*/
    public static void main(String[] args) {

        System.out.println(run_set("abcb"));
        System.out.println(run_bruteforce("abcb"));

        System.out.println(run_array("acb"));
        System.out.println(run_bit("acb"));
    }


    static boolean run_bit(String str) {
        //32 bits (we need only to turn on the bit of index same as the character)
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'a';

            //if this bit was turned on before, it means it was encountered before so return false
            if ((result & (1 << ch)) > 0)
                return false;
        }

        return true;

    }


    static boolean run_array(String str) {
        int[] chars = new int[256];
        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i)] > 0)
                return false;
            chars[str.charAt(i)]++;
        }
        return true;
    }

    static boolean run_set(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++)
            if (set.contains(str.charAt(i)))
                return false;
            else
                set.add(str.charAt(i));

        return true;
    }

    static boolean run_bruteforce(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }

        return true;


    }
}
