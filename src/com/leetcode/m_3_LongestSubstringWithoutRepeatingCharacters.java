package com.leetcode;

//3. Longest Substring Without Repeating Characters

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

public class m_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("sssss"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("c"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcfdgea"));
        System.out.println("--------------------------------");
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("sssss"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("pwwkew"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("bbbbb"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("c"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2(""));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("dvdf"));
        System.out.println(new m_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("abcfdgea"));

    }

    //brute force algorithm, however it is correct but performance is bad
    //it will give time limit exceeded in leetcode
    public int lengthOfLongestSubstring2(String s) {

        Set<Character> sb = new HashSet<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            sb = new HashSet<>();
            sb.add(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {

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

        return max > sb.size() ? max : sb.size();

    }


    @Test
    public void TestlengthOfLongestSubstring2() {
        Assert.assertEquals(3, lengthOfLongestSubstring2("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring2("sssss"));
        Assert.assertEquals(7, lengthOfLongestSubstring2("abcfdgea"));
        Assert.assertEquals(2, lengthOfLongestSubstring2("aba"));
        Assert.assertEquals(2, lengthOfLongestSubstring2("baa"));
        Assert.assertEquals(2, lengthOfLongestSubstring2("aab"));
        Assert.assertEquals(3, lengthOfLongestSubstring2("dvdf"));
        Assert.assertEquals(0, lengthOfLongestSubstring2(""));
        Assert.assertEquals(1, lengthOfLongestSubstring2("a"));
        Assert.assertEquals(2, lengthOfLongestSubstring2("aabb"));
        Assert.assertEquals(3, lengthOfLongestSubstring2("aabcbca"));
        Assert.assertEquals(5, lengthOfLongestSubstring2("aabcdedac"));
        Assert.assertEquals(3, lengthOfLongestSubstring2("pwwkew"));
        Assert.assertEquals(1, lengthOfLongestSubstring2("bbbbbb"));
    }


    public int lengthOfLongestSubstring(String s) {

        //sliding window solution
        //move the window and keep updating elems with its last index
        //if we encounter an elem we visited before we calc the size, shrink the window (change start) and continue
        int start = 0, end = 0, max = 0;
        //map should have [updated] latest index of each character, for example abcassw, a can be found at index=0,3
        //it should have first {a:0} then it will be updated to {a:3}
        Map<Character, Integer> map = new HashMap<>();
        int lastBroken = 0;

        int size = 0;
        while (start <= end && end < s.length()) {
            if (map.containsKey(s.charAt(end))) { //012345

                if (size > max)
                    max = size;

                //move start to the duplicate elem's index + 1 [to avoid duplicate]
                //e.g. 'oabcad' at 2nd 'a' we get 1st 'a' index then add 1 to start from '..bca'
                //lastBroken is very important here to make sure we don't go before duplicate char
                // e.g. aabcbca check last 'a' it was encountered before, but it will go back to index 1 but we have duplicate cases in between so that's why we have last broken in place
                //another case here aabccdefwqrab
                start = lastBroken > map.get(s.charAt(end)) + 1 ? lastBroken : map.get(s.charAt(end)) + 1;
                lastBroken = start;
                //recalc size [shrinked now]
                size = end - start;
            }

            //update size, add current 1 [for current char]
            size++;
            //last index of current elem
            map.put(s.charAt(end), end);
            //move end pointer
            end++;
        }

        return max > size ? max : size;

    }

    @Test
    public void TestlengthOfLongestSubstring() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("sssss"));
        Assert.assertEquals(7, lengthOfLongestSubstring("abcfdgea"));
        Assert.assertEquals(2, lengthOfLongestSubstring("aba"));
        Assert.assertEquals(2, lengthOfLongestSubstring("baa"));
        Assert.assertEquals(2, lengthOfLongestSubstring("aab"));
        Assert.assertEquals(3, lengthOfLongestSubstring("dvdf"));
        Assert.assertEquals(0, lengthOfLongestSubstring(""));
        Assert.assertEquals(1, lengthOfLongestSubstring("a"));
        Assert.assertEquals(2, lengthOfLongestSubstring("aabb"));
        Assert.assertEquals(3, lengthOfLongestSubstring("aabcbca"));
        Assert.assertEquals(9, lengthOfLongestSubstring("aabccdefwqrab"));
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbbb"));
    }

}
