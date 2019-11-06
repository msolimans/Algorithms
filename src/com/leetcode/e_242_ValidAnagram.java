package com.leetcode;

//e_242_ValidAnagram 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given two strings s and t , write a function to determine if t is an anagram of s.
//
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//
//Input: s = "rat", t = "car"
//Output: false
//Note:
//You may assume the string contains only lowercase alphabets.
//
//Follow up:
//What if the inputs contain unicode characters? How would you adapt your solution to such case?

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/valid-anagram/
//******************************************************************************************************************

public class e_242_ValidAnagram {


    public static void main(String[] args) {
        System.out.println(new e_242_ValidAnagram().isAnagram("anagram", "naagram"));
    }

    public boolean isAnagram(String s, String t) {

        //hashmap to preserve how many counts for each character in string 1
        Map<Character, Integer> result1 = new HashMap<>();

        for (char c : s.toCharArray()) {
            result1.put(c, result1.getOrDefault(c, 0) + 1);
        }

        //decrease occurrences of each character found in string2 from constructed hashmap
        int count = 0;
        for (char c : t.toCharArray()) {
            count = result1.getOrDefault(c, 0);
            //if this char not found, in first string, return false
            if (count == 0)
                return false;
            else if (count == 1)//if we have one occurrence remove it
                result1.remove(c);
            else//decrease count of occurrence in hashmap
                result1.put(c, count - 1);
        }

        //if we have any chars in hashmap, return false otherwise true˚
        return result1.isEmpty();
    }


    @Test
    public void TestisAnagram() {
        Assert.assertTrue(isAnagram("aa", "aa"));
        Assert.assertFalse(isAnagram("aa", "bb"));
        Assert.assertTrue(isAnagram("anagram", "naagram"));
        Assert.assertTrue(isAnagram("anagram%", "na%agram"));
        Assert.assertFalse(isAnagram("anagram%", "naagram"));
        Assert.assertFalse(isAnagram("car", "rat"));
        Assert.assertFalse(isAnagram("car", "rat"));
    }

}
