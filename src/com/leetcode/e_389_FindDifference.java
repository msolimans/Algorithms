package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by msoliman on 5/5/17.
 */
public class e_389_FindDifference {
    public static void main(String[] args){
        System.out.println(run_using_hashset("abcdef", "abcde"));
        System.out.println(run("abcdef", "abcde"));

    }

    static char run(String s, String t){

        if(s.length() == 0 && t.length() == 0) return ' ';

        if(s.length() < t.length()) return run(t,s);




        int i = s.charAt(0);
        for(int indx = 1;indx<s.length();indx++)
            i = i ^ s.charAt(indx);

        for(int indx = 0;indx<t.length();indx++)
            i = i ^ t.charAt(indx);

        return (char)i;
    }


    static char run_using_hashset(String s, String t){
        Set<Character> set = new HashSet<>();

        if(s.length() == 0 && t.length() == 0)
            return ' ';

        if(s.length() > t.length())
            return run_using_hashset(t, s);

        for(int i =0;i<s.length();i++){
            set.add(s.charAt(i));
        }

        for(int i =0;i<t.length();i++)
            if(!set.contains(t.charAt(i)))
                return t.charAt(i);


        return ' ';

    }
}
