package com.leetcode.discuss.google;

//Title: CompareStrings
//----------------------------------------------------------------------------------------------------
//Description:

//One string is strictly smaller than another when the
//frequency of occurrence of the smallest character
//in the string is less than the frequency of
//occurrence of the smallest character in the
//comparison string.
//
//For example, string "abcd" is smaller than string
//"aaa" because the smallest character (in
//lexicographical order) in "abcd" is ‘a’, with a
//frequency of 1, and the smallest character in "aaa"
//is also ‘a’, but with a frequency of 3. In another
//example, string "a" is smaller than string "bb"
//because the smallest character in "a" is ‘a’ with a
//frequency of 1, and the smallest character in "bb"
//
//is 'b' with a frequency of 2.
//
//Write a function that, given string A (which
//contains M strings delimited by ',') and string B
//(which contains N strings delimited by ','), returns
//an array C of N integers. For 0 < J <N, values of
//C[J] specify the number of strings in A which are
//strictly smaller than the comparison J-th string in B
//(starting from 0).
//For example, given strings A and B such that:
//A= "abcd aabc bd"
//
//B = "aaa aa"
//
//the function should return [3, 2], because:
//
//All the strings in the array are strictly smaller than
//"aaa" on the basis of the given comparison
//criteria;
//
//Strings "abcd" and "bd" are strictly smaller than
//
//aa .
//
//Assume that:
//e 1<N,™M<s 10000
//e 1 < length of any string contained by Aor B
//< 10
//e All the input strings comprise only lowercase
//English alphabet letters (a-z)
//
//In your solution, focus on correctness. The
//performance of your solution will not be the
//primary focus of the assessment.
//----------------------------------------------------------------------------------------------------
//Company: Google
//----------------------------------------------------------------------------------------------------
//https://leetcode.com/discuss/interview-question/352458/
//----------------------------------------------------------------------------------------------------
import org.junit.Assert;
import org.junit.Test;

public class CompareStrings {

    int freq(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }


        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0)
                return counts[i];
        }


        return 0;
    }

    int[] frequencies(String m, String n) {
        String[] ms = m.split(",");
        String[] ns = n.split(",");

        //as long as string's length >= 0 and <= 10 we don't need more than 10 as array size
        int[] freqs = new int[11];
        for (String str : ms) {
            freqs[freq(str)]++;
        }

        for (int i = 1; i < freqs.length; i++) {
            freqs[i] += freqs[i - 1];
        }

        int[] result = new int[ns.length];

        for (int i = 0; i < ns.length; i++) {
            int nf = freq(ns[i]);
            if (nf > 0)
                result[i] = freqs[nf - 1];
        }

        return result;
    }

    @Test
    public void TestFrequencies() {
        Assert.assertArrayEquals(new int[]{3,2}, frequencies("abcd,aabc,bd", "aaa,aa"));
    }
}
