package com.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 5/4/17.
 */
public class e_409_Palindrome {
   /* Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

    This is case sensitive, for example "Aa" is not considered a palindrome here.

    Note:
    Assume the length of given string will not exceed 1,010.

    Example:

    Input:
            "abccccdd"

    Output:
            7

    Input:
            civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth
    Output:
            983


    Explanation:
    One longest palindrome that can be built is "dccaccd", whose length is 7.

    */


    public static void main(String[] args) {

        System.out.println(run("abccccdd"));

    }


    static int run(String str) {

        int[] arr = new int[60];


        for (int i = 0; i < str.length(); i++) {

            int ich = str.charAt(i) % 60;
            arr[ich]++;
        }

        System.out.println(Arrays.toString(arr));

        int result = 0;



        boolean hasOdd = false;

        for (int i : arr) {
            if (i % 2 == 0)
                result += i;
            else {

                result +=(i - 1);
                hasOdd = true;
            }
        }




        return result + (hasOdd?1:0);

    }


}
