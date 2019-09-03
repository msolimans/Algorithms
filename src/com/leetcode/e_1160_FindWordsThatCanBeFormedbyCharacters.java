package com.leetcode;

//e_1160_FindWordsThatCanBeFormedbyCharacters 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//You are given an array of strings words and a string chars.
//
//A string is good if it can be formed by characters from chars (each character can only be used once).
//
//Return the sum of lengths of all good strings in words.
//
//
//
//Example 1:
//
//Input: words = ["cat","bt","hat","tree"], chars = "atach"
//Output: 6
//Explanation:
//The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
//Example 2:
//
//Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//Output: 10
//Explanation:
//The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
//
//
//Note:
//
//1 <= words.length <= 1000
//1 <= words[i].length, chars.length <= 100
//All strings contain lowercase English letters only.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_1160_FindWordsThatCanBeFormedbyCharacters {


    public static void main(String[] args) {
        System.out.println(new e_1160_FindWordsThatCanBeFormedbyCharacters().countCharacters(new String[]{"ab", "ba"}, "ab"));
    }


    public int countCharacters(String[] words, String chars) {
        if(words.length == 0 || chars.length() == 0)
            return 0;

        //all lowercase chars need 26 arr [const]
        int[] arr = new int[26];
        for (char c : chars.toCharArray()) {
            arr[c % 97] += 1;
        }

        int sum = 0;
        for (String s : words) {
            //as arrays are passed by ref, we should copy the array here. we can make it in a recursive way as well however cloning is better in performance
            sum += countWord(s, Arrays.copyOf(arr, arr.length));
        }

        return sum;
    }


    int countWord(String word, int[] arr) {

        //loop thru word and check each char, if it exists decrease its count from arr and continue
        for (char c : word.toCharArray()) {
            //if any char doesn't exist, return 0
            if (arr[c % 97] == 0)
                return 0;
            arr[c % 97] -= 1;
        }

        //all chars exist, return word length
        return word.length();
    }


    @Test
    public void TestCountCharacters() {
        Assert.assertEquals(6, countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        Assert.assertEquals(3, countCharacters(new String[]{"cata", "bt", "hat", "tree"}, "atch"));
        Assert.assertEquals(10, countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

}
