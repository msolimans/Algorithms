package com.leetcode;

//m_49_GroupAnagrams 
//Show Topic Tags

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array of strings, group anagrams together.
//
//Example:
//
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//Note:
//
//All inputs will be in lowercase.
//The order of your output does not matter.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/group-anagrams/
//******************************************************************************************************************

public class m_49_GroupAnagrams {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new m_49_GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toArray()));

    }

    //only small letters .. starting at 97
    String countSort(String str) {
        int[] a = new int[26];
        for (int i = 0; i < str.length(); i++) {
            a[str.charAt(i) - 'a'] += 1;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < a[i]; j++)
                builder.append('a' + i);
        }

        return builder.toString();
    }

    @Test
    public void TestCountSort() {
        Assert.assertEquals("abc", countSort("bac"));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //map to all grouped keys [under one key]
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //sort them and put them under the same key
            String sorted = countSort(str);
            List<String> list = map.getOrDefault(sorted, new ArrayList<>());
            list.add(str);
            map.put(sorted, list);
        }

        //loop thru hashmap and export keys
        List<List<String>> result = new ArrayList<>();

        //export to results array
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    @Test
    public void TestGroupAnagrams() {

        List<List<String>> s = new ArrayList<>();

        s.add(Arrays.asList("eat", "tea", "ate"));
        s.add(Arrays.asList("bat"));
        s.add(Arrays.asList("tan", "nat"));

        Assert.assertArrayEquals(s.toArray(), groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toArray());
    }
}
