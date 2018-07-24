package com.crackbook.ch1;

/**
 * Created by msoliman on 5/15/17.
 */
public class p_1_6_StringCompression {
    public static void main(String[] args) {
        System.out.println(run("aabbcccdddde"));

    }

    static String run(String str) {

        if (str.length() <= 2)
            return str;


        StringBuilder sb = new StringBuilder();

        int i = 0, j = 1;

        while (j < str.length()) {

            if (str.charAt(i) != str.charAt(j)) {
                sb.append(String.valueOf(str.charAt(i)) + (j - i == 1? "": j-i));

                i = j;
                j++;
            } else {
                j++;


            }
        }

        sb.append(String.valueOf(str.charAt(i)) + (j-i == 1?"":j-i));


        return str.length() == sb.length() ? str : sb.toString();
    }
}
