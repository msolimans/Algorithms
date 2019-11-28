package com.probs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by msoliman on 5/1/17.
 */
public class p_12_PermutationGeneration {


    public static void main(String[] args) {

        String[] ss = perm("abcd");
        System.out.println(ss.length + "pairs");
        System.out.println(Arrays.toString(ss));


        String[] ss2 = perm2("abcd");
        System.out.println(ss2.length + "pairs");
        System.out.println(Arrays.toString(ss2));

    }


    static String[] perm(String str) {

        if (str.length() == 2) {
            String s = new StringBuilder(str).reverse().toString();

            return new String[]{str, s};
        }


        List<String> arr = new ArrayList<>();


        for (int i = 0; i < str.length(); i++) {


            String[] ress = perm(
                    (i == 0 ? "" : str.substring(0, i)) +
                            (i == str.length() - 1 ? "" : str.substring(i + 1))
            );

            for (int j = 0; j < ress.length; j++) {
                ress[j] = str.charAt(i) + ress[j];
            }

            Collections.addAll(arr, ress);
        }

        return arr.toArray(new String[0]);
    }

    //another solution, easier to understand
    static String[] perm2(String str) {

        List<String> res = new ArrayList<>();
        perm2(str.toCharArray(), 0, str.length() - 1, res);
        return res.toArray(new String[0]);
    }


    //                  ABC                 => first level
    //      ABC         BAC         CBA     => second level
    //  ABC     ACB BAC     BCA CBA     CAB => third level, this is the result
    //height of this tree is exactly the length of string
    //Algorithm:
    //every time you swap first char with all other subsequent chars
    //go to the second, third, fourth, until end character to do the same operation above

    static void perm2(char[] str, int l, int r, List<String> res) {
        if (l >= r) {
            res.add(String.valueOf(str));
        } else {
            for (int i = l; i <= r; i++) {
                swap(str, l, i);
                perm2(str, l + 1, r, res);
                swap(str, l, i);//backtrack again to return the string to its normal/previous value in the above level. look at the levels above

            }
        }

    }


    static char[] swap(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
        return str;
    }


}
