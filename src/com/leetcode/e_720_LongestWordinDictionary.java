package com.leetcode;

//e_720_LongestWordinDictionary
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Trie
 */

/*Description*/
//******************************************************************************************************************
//Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
//
//If there is no answer, return the empty string.
//Example 1:
//Input:
//words = ["w","wo","wor","worl", "world"]
//Output: "world"
//Explanation:
//The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
//Example 2:
//Input:
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//Output: "apple"
//Explanation:
//Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
//Note:
//
//All the strings in the input will only contain lowercase letters.
//The length of words will be in the range [1, 1000].
//The length of words[i] will be in the range [1, 30].
//******************************************************************************************************************
//Companies: Google | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/longest-word-in-dictionary/
//******************************************************************************************************************

public class e_720_LongestWordinDictionary {

    class TrieNode {
        TrieNode[] vals;
        boolean endOfWord;

        TrieNode() {
            vals = new TrieNode[26];
        }
    }

    public class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            insert(word, root);
        }

        void insert(String word, TrieNode node) {
            if (word == null || word.length() == 0)
                return;

            if (node == null)
                node = root;

            int index = word.charAt(0) - 'a';

            if (node.vals[index] == null)
                node.vals[index] = new TrieNode();

            if (word.length() == 1)
                node.vals[index].endOfWord = true;


            insert(word.substring(1), node.vals[index]);
        }


    }


    String result = "";

    public String longestWord(String[] words) {

        Trie t = new Trie();
        result = "";

        //index all words in Trie
        for (String w : words) {
            t.insert(w);
        }


        //DFS traverse and make sure every node make sure it constructs a complete word, if not exit n don't continue this branch
        longestWord(t.root, "");
        return result;
    }

    void longestWord(TrieNode node, String word) {
        //if node's null, means we are done
        if (node == null || node.vals == null) {
            return;
        }

        //if word's length is greater than zero and it doesn't form a complete word [exit, don't continue this branch]
        if (word.length() > 0 && !node.endOfWord)
            return;

        //dfs traversal
        for (int i = 0; i < node.vals.length; i++) {
            if (node.vals[i] != null)
                longestWord(node.vals[i], word + (char) (i + 'a'));
        }

        //if we constructed a word that greater than the result, update result
        if (word.length() > result.length())
            result = word;
    }

    public static void main(String[] args) {
        System.out.println(new e_720_LongestWordinDictionary().longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
    }

    //2nd Solution Nicer solution without using Trie O(nlogn) for sort can be done in O(n) as long it has 1000
    public String longestWord1(String[] words) {
        Arrays.sort(words);
        String ans = "";
        Set<String> set = new HashSet<>();
        for(String word : words)
            if((word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) && word.length() > ans.length()) {
                set.add(word);
                ans = word;
            }
        return ans;
    }

    @Test
    public void TestLongestWord() {
        Assert.assertEquals("world", new e_720_LongestWordinDictionary().longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        Assert.assertEquals("apple", new e_720_LongestWordinDictionary().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        Assert.assertEquals("", new e_720_LongestWordinDictionary().longestWord(new String[]{"apple", "banana", "zebra"}));


        Assert.assertEquals("bun", new e_720_LongestWordinDictionary().longestWord1(new String[]{ "b", "bu", "bun", "wo", "wor", "worl", "world"}));
        Assert.assertEquals("", new e_720_LongestWordinDictionary().longestWord1(new String[]{ "wo", "wor", "worl", "world"}));
        Assert.assertEquals("apple", new e_720_LongestWordinDictionary().longestWord1(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        Assert.assertEquals("", new e_720_LongestWordinDictionary().longestWord1(new String[]{"apple", "banana", "zebra"}));

    }


}
