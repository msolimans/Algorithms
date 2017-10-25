package com.leetcode;

//3. Longest Substring Without Repeating Characters

import java.util.HashSet;
import java.util.Set;

/**
    Given a string, find the length of the longest substring without repeating characters.

        Examples:

        Given "abcabcbb", the answer is "abc", which the length is 3.

        Given "bbbbb", the answer is "b", with the length of 1.

        Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/

public class m_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("sssss"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("c"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcfdgea"));

    }

    //brute force algorithm (however it is correct but performance is bad and it will give time limit exceeded in leetcode)
    public int lengthOfLongestSubstring(String s) {

        Set<Character> sb = new HashSet<>();
        int max = 0;

        for(int i =0;i<s.length();i++){

            sb = new HashSet<>();
            sb.add(s.charAt(i));

            for(int j =i+1;j<s.length();j++) {

                if (sb.contains(s.charAt(j))) {

                    if (sb.size() > max)
                        max = sb.size();

                    //no need to continue any more as we found a duplicate
                    break;
                }

                sb.add(s.charAt(j));

                if (sb.size() > max)
                    max = sb.size();
            }
        }

        return  max > sb.size() ? max: sb.size();

    }

    public int lengthOfLongestSubstring1(String s) {

        //however solution looks like complex but it is very easy if you try to trace it down on a paper.

        //we should keep 2 arrays of constant size (256), one for current and one for repeated characters (you will understand whatis the meaning of current/repeated later)
        //for each occurrence of a character, you will add one to every element that came before as long as it is not equal to this character
        return  0;


    }
}
