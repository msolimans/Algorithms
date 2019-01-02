package com.crackbook.ch1;

import java.util.Arrays;

/**
 * Created by msoliman on 5/8/17.
 */
public class p_1_3_URLify {

    /*
    URLify: Write a method to replace all spaces in a string with '%20' You may assume that the string has sufficient space at the end to hold the additional
    characters, and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character array so that you can perform this
    operation in place.)

    EXAMPLE
    Input: "Mr John Smith       ", 13
    Output: "Mr%20J ohn%20Smith"

    Hints: #53, #7 78

    */

    public static void main(String[] args) {

//        System.out.print(run("Mr John Smith       ",13));

        System.out.print(run_inplace("Mr John Smith       ", 13));

    }

    static void shift(char[] chs, int start, int offset) {
        int i = start ;
        char temp, prev = ' ';

        while (i <= chs.length - 1) {

            temp = chs[i];
            chs[i] = prev;
            prev = temp;


            i += offset;
        }

    }

    static String run_inplace(String s, int l) {

        if (l > s.length())
            l = s.length();

        char[] chs = s.toCharArray();


        for (int i = 0; i < l - 1; i++) {
            if (chs[i] == ' ') {
                chs[i] = '%';
                //shifting .. 2 shifts till reaching the end

                shift(chs, i + 1, 2);
                shift(chs, i + 2, 2);
                chs[i + 1] = '2';
               chs[i + 2] = '0';
            }
        }

        return String.valueOf(chs);
    }

    static String run(String str, int length) {

        StringBuilder b = new StringBuilder();


        int indx = 0;

        while (--length >= 0) {

            if (str.charAt(indx) == ' ')
                b.append("%20");
            else
                b.append(str.charAt(indx));

            indx++;
        }


        return b.toString();
    }

}
