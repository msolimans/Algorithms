package com.probs;

/**
 * Created by msoliman on 4/21/17.
 */
public class Main {
    public static void main(String[] args) {

        String a1 = "abD21";
        String a2 = "abc";

        byte[] bts = a2.getBytes();

        System.out.print(bts.length);


        for(char c: a1.toCharArray()){

            for(int i=0;i<bts.length;i++){
                int r = c ^ bts[i];

            }


        }




        /*
        // Problem 2
        // Given an array find the elements of duplicates, find the element that comes only once
        int i = p_2_DuplicatedArray.run(new int[]{2,2,1,0,3,0,-1,3,-1});
        int i1 = p_2_DuplicatedArray.run(new int[]{2,1,0,3,0,-1,3,-1,1});
        System.out.println(i);
        System.out.println(i1);
        */

        /*
        // Problem 1
        // Check if the string provided has all lower case characters
        //all small letters are there
        System.out.print(p_1_SmallLetters.run("abcdefghijklmnSA#@!@#$%^FFDSASXCVG9876543erghnmo87yuhjnopqSAfw2rstuvwxyz"));
        //remove only "a"
        System.out.print(p_1_SmallLetters.run("bcdefghijklmnSA#@!@#$%^FFDSASXCVG9876543erghnmo87yuhjnopqSAfw2rstuvwxyz"));
        */


    }
}
