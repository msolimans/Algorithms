package com.leetcode;

//m_648_ReplaceWords 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
//
//Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
//
//You need to output the sentence after the replacement.
//
//Example 1:
//
//Input: dict = ["cat", "bat", "rat"]
//sentence = "the cattle was rattled by the battery"
//Output: "the cat was rat by the bat"
//
//
//Note:
//
//The input will only have lower-case letters.
//1 <= dict words number <= 1000
//1 <= sentence words number <= 1000
//1 <= root length <= 100
//1 <= sentence words length <= 1000

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/replace-words/
//******************************************************************************************************************

public class m_648_ReplaceWords {


    public static void main(String[] args) {

        System.out.println(new m_648_ReplaceWords().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));

    }


    String getRoot(String str, Set<String> dict) {

        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(0, i)))
                return str.substring(0, i);

        }

        return str;
    }

    public String replaceWords(List<String> dict, String sentence) {


        if (dict == null || dict.size() == 0)
            return sentence;

        //load all dic in hashset
        Set<String> set = new HashSet<>(dict);

        StringBuilder result = new StringBuilder();
        //split sentence by space an then check loop thru the word n if we can find it in hashset, stop it n return such root word
        for (String s : sentence.split("\\s+")) {
            result.append(getRoot(s, set) + " ");
        }

        return result.toString().trim();

    }

    @Test
    public void TestReplaceWords() {
        Assert.assertEquals("the cat was rat by the bat",
                replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));

        Assert.assertEquals("the cattle was rattled by the battery",
                replaceWords(null, "the cattle was rattled by the battery"));

        Assert.assertEquals("the cat was rattled by the battery",
                replaceWords(Arrays.asList("cat"), "the cattle was rattled by the battery"));


    }

}
