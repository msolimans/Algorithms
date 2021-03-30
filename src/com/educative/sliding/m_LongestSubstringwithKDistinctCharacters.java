package com.educative.sliding;


//Longest Substring with K Distinct Characters (medium)
//Given a string, find the length of the longest substring in it with no more than K distinct characters.
//
//Example 1:
//
//Input: String="araaccyyyyi", K=2
//              "a:0 r:1 "
//Output: 4
//Explanation: The longest substring with no more than '2' distinct characters is "araa".
//Example 2:
//
//Input: String="araaci", K=1
//Output: 2
//Explanation: The longest substring with no more than '1' distinct characters is "aa".
//Example 3:
//
//Input: String="cbbebi", K=3
//Output: 5
//Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
//link:
//https://www.educative.io/courses/grokking-the-coding-interview/YQQwQMWLx80

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class m_LongestSubstringwithKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(findLength("araacci", 2));
        System.out.println(findLength("araaccyyyyi", 2));
    }

    public static int findLength(String s, int k) {
        int left = 0, right = 0, length = 0;
        Map<Character, Integer> subs = new HashMap<>();
        int count = 0;
        int result = 0;

        while (right < s.length() && left <= right) {
            if (!subs.containsKey(s.charAt(right)) && subs.size() == k) {//full -> opt out till you get size = k - 1

                if (count > result)
                    result = count;

                if (subs.getOrDefault(s.charAt(left), 0) == 1)
                    subs.remove(s.charAt(left));
                else
                    subs.put(s.charAt(left), subs.get(s.charAt(left)) - 1);

                count--;
                left++;
                continue;
            }

            subs.put(s.charAt(right), subs.getOrDefault(s.charAt(right), 0) + 1);
            count++;

            right++;
        }

        if (count > result)//for handling "aarr" or "aaaaa" cases
            result = count;

        return result;


    }

    @Test
    public void TestFindLength() {

        Assert.assertEquals(4, findLength("araacci", 2));
        Assert.assertEquals(6, findLength("araaccyyyyi", 2));
    }


}
