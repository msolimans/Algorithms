package com.leetcode;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by msoliman on 5/4/17.
 */
public class e_500_KeyboardRow {


    public static void main(String[] args){




//        System.out.println(Arrays.toString(run(new String[]{"Dad", "qwsdx", "asdfghj", "zxcv","edx" ,"Alaska"})));
        System.out.println(Arrays.toString(run(new String[]{"qwertyuiop"})));




    }

    static String[] run_regex(String[] words){
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[asdfghjkjl]*|[qwertyuiop]*|[zxcvbnm]*")).toArray(String[]::new);
    }

    static String[] run(String[] words){
        Map<Character, Integer> rows = new HashMap<>();

        rows.put('a', 2);
        rows.put('s', 2);
        rows.put('d', 2);
        rows.put('f', 2);
        rows.put('g', 2);
        rows.put('h', 2);
        rows.put('a', 2);
        rows.put('j', 2);
        rows.put('k', 2);
        rows.put('l', 2);


        rows.put('q', 1);
        rows.put('w', 1);
        rows.put('e', 1);
        rows.put('r', 1);
        rows.put('t', 1);
        rows.put('y', 1);
        rows.put('u', 1);
        rows.put('i', 1);
        rows.put('o', 1);
        rows.put('p', 1);

        rows.put('z', 3);
        rows.put('x', 3);
        rows.put('c', 3);
        rows.put('v', 3);
        rows.put('b', 3);
        rows.put('n', 3);
        rows.put('m', 3);

        List<String> res = new ArrayList();

        for(String ss: words){
            int row = -1;
            for(int i=0;i< ss.length();i++){
                if(row == -1)
                    row = rows.getOrDefault(Character.toLowerCase(ss.charAt(i)),0);
                else if(row != rows.getOrDefault(Character.toLowerCase(ss.charAt(i)) ,0)){
                    row = -1;
                    break;
                }
            }

            if(row != -1)
                res.add(ss);

        }

        //return res.toArray(new String[0]);
        return res.stream().toArray(String[]::new);

    }
}
