package com.leetcode;

//e_884_UncommonWordsfromTwoSentences 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
//
//A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
//
//Return a list of all uncommon words.
//
//You may return the list in any order.
//
//
//
//Example 1:
//
//Input: A = "this apple is sweet", B = "this apple is sour"
//Output: ["sweet","sour"]
//Example 2:
//
//Input: A = "apple apple", B = "banana"
//Output: ["banana"]
//
//
//Note:
//
//0 <= A.length <= 200
//0 <= B.length <= 200
//A and B both contain only spaces and lowercase letters.

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/uncommon-words-from-two-sentences/
//******************************************************************************************************************

public class e_884_UncommonWordsfromTwoSentences {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new e_884_UncommonWordsfromTwoSentences().uncommonFromSentences("", "B")));
    }

    void uncommonFromSentence(String A, Set<String> unique, Set<String> duplicates) {
        //split string by space
        for (String s : A.split("\\s+")) {
            //in case string was empty, or we do have couple of spaces as separator .. skip it
            if (s.equals(""))
                continue;

            //in case unique contains s, then add it to duplicates and remove it from unique
            if (unique.contains(s)) {
                duplicates.add(s);
                unique.remove(s);
                continue;
            }

            //in case duplicate doesn't have s, add it to unique
            //why we have this strange condition:
            //to handle such case `word word word` in the third one it will be added to `unique` again if we don't have this condition
            if (!duplicates.contains(s))
                unique.add(s);

        }

    }

    public String[] uncommonFromSentences(String A, String B) {

        Set<String> duplicates = new HashSet<>();
        Set<String> unique = new HashSet<>();

        //maintains unique set where we store only unique words
        //duplicates is the set that stores repeated words
        //simply it is unique words from both strings
        uncommonFromSentence(A, unique, duplicates);
        uncommonFromSentence(B, unique, duplicates);

        //convert set to list of string as a result
        String[] result = new String[unique.size()];
        return unique.toArray(result);
    }

    @Test
    public void TestUncommonFromSentences() {
        Assert.assertArrayEquals(new String[]{"sweet", "sour"}, uncommonFromSentences("this apple is sweet", "this apple is sour"));
        Assert.assertArrayEquals(new String[]{"banana"}, uncommonFromSentences("apple apple", "banana"));
        Assert.assertArrayEquals(new String[0], uncommonFromSentences("", ""));
        Assert.assertArrayEquals(new String[]{"d"}, uncommonFromSentences("", "d"));
        Assert.assertArrayEquals(new String[]{"ejt"}, uncommonFromSentences("s z z z s", "s z ejt"));
    }

}
