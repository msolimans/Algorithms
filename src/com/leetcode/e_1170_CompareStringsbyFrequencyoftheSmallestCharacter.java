package com.leetcode;

//e_1170_Compare StringsbyFrequencyoftheSmallestCharacter 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
//
//Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
//
//
//
//Example 1:
//
//Input: queries = ["cbd"], words = ["zaaaz"]
//Output: [1]
//Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
//Example 2:
//
//Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
//Output: [1,2]
//Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
//
//
//Constraints:
//
//1 <= queries.length <= 2000
//1 <= words.length <= 2000
//1 <= queries[i].length, words[i].length <= 10
//queries[i][j], words[i][j] are English lowercase letters.
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
//******************************************************************************************************************

public class e_1170_CompareStringsbyFrequencyoftheSmallestCharacter {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new e_1170_CompareStringsbyFrequencyoftheSmallestCharacter().numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));
    }

    //frequency func to calc least character freq in word
    int f(String word) {
        if (word.length() == 0)
            return 0;

        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0)
                return arr[i];
        }

        return 0;
    }

    //O(n) with auxiliary space O(n)
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //create frequency array
        int[] freqs = new int[2000];

        //word freq, min and max frequencies
        int wf = 0, min = 0, max = 0;

        //loop thru the array of words, calc freq of each word and save freq of word in the index
        for (String word : words) {
            wf = f(word);
            if (wf > max)
                max = wf;
            if (wf < min)
                min = wf;
            freqs[wf]++;
        }

        //cumulative update of frequencies
        for (int i = max - 1; i >= min; i--)
            freqs[i] = freqs[i] + freqs[i + 1];

        //result array
        int[] res = new int[queries.length];

        //loop thru queries
        for (int i = 0; i < queries.length; i++) {
            //calc freq of query
            int qf = f(queries[i]);
            //if freq exceeds the max frequencies in words, continue , skip it will be zero in result
            if (qf >= max)
                continue;

            //otherwose, save in result the next freq [counts] from frequencies after "query frequency"
            //O(1)
            res[i] = freqs[qf + 1];
        }

        return res;
    }


    @Test
    public void Testf() {
        Assert.assertEquals(1, f("abc"));
        Assert.assertEquals(2, f("abca"));
        Assert.assertEquals(0, f(""));
    }

    @Test
    public void TestNumSmallerByFrequency() {
        Assert.assertArrayEquals(new int[]{1}, numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"}));
        Assert.assertArrayEquals(new int[]{1, 2}, numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"}));
    }


}
