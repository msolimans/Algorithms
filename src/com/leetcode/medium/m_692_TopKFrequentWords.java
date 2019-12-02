package com.leetcode.medium;

//m_692_TopKFrequentWords
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * HashTable, Heap, Trie
 */

/*Description*/
//******************************************************************************************************************
//Given a non-empty list of words, return the k most frequent elements.
//
//Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
//
//Example 1:
//Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//Output: ["i", "love"]
//Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.
//Example 2:
//Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//Output: ["the", "is", "sunny", "day"]
//Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//    with the number of occurrence being 4, 3, 2 and 1 respectively.
//Note:
//You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//Input words contain only lowercase letters.
//Follow up:
//Try to solve it in O(n log k) time and O(n) extra space.

//******************************************************************************************************************
//Companies: Amazon | 19  Yelp | 7  Google | 5  Facebook | 4  Bloomberg | 3  TripAdvisor | 3  Uber | 2  Apple | 2  Salesforce | 2  Oracle | 2  Expedia | 2  Atlassian | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/top-k-frequent-words/
//******************************************************************************************************************

public class m_692_TopKFrequentWords {


    public static void main(String[] args) {
        System.out.println(new m_692_TopKFrequentWords().topKFrequent(new String[]{"i", "love", "i", "leetcode"}, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {

        if (words == null || words.length == 0)
            return new ArrayList<>();

        //record occurrence of words in a hash map
        Map<String, Integer> map = new HashMap<>();
        //record the max occurrence
        int max = Integer.MIN_VALUE;

        for (String w : words) {
            int nv = map.getOrDefault(w, 0) + 1;
            if (nv > max)
                max = nv;
            map.put(w, nv);
        }

        //create buckets array that maps occurrence to list of words
        //unique words
        List<String>[] ks = new ArrayList[max + 1];
        for (String w : map.keySet()) {
            int indx = map.get(w);
            if (ks[indx] == null) {
                ks[indx] = new ArrayList<>();
            }

            ks[indx].add(w);
        }

        //result
        List<String> res = new ArrayList<>();

        //loop thru until we get k elems
        for (int i = ks.length - 1; (i >= 0 && k > 0); i--) {
            //if this bucket doesn't have any elems, skip it
            if (ks[i] == null) {
                continue;
            }

            //extract elems from this bucket such that it doesn't exceed k elems or what's left over
            //elems at ith index, means it occurred ith times in main input
            k = extractElems(ks[i].toArray(new String[0]), res, k);
        }


        return res;
    }

    int extractElems(String[] arr, List<String> res, int k) {
        //sort array
        if(arr.length > 1)
            Arrays.sort(arr);
        //loop thru and extract elems at this index such that they don't exceed k elems
        for (int i = 0; i < arr.length && k > 0; i++) {
            res.add(arr[i]);
            k--;
        }

        //return k [left over to decide whether we nned to continue to other buckets to extract more elems]
        return k;
    }

    @Test
    public void TestTopKFrequent() {

        Assert.assertArrayEquals(new String[]{},
                topKFrequent(new String[]{}, 1).toArray(new String[0]));


        Assert.assertArrayEquals(new String[]{"i",},
                topKFrequent(new String[]{"i"}, 2).toArray(new String[0]));

        Assert.assertArrayEquals(new String[]{"i",},
                topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1).toArray(new String[0]));


        Assert.assertArrayEquals(new String[]{"i", "love"},
                topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2).toArray(new String[0]));

        Assert.assertArrayEquals(new String[]{"the", "is", "sunny", "day"},
                topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4).toArray(new String[0]));


    }


}
