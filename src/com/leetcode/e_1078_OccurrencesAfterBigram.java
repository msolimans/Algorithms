package com.leetcode;

//1078. Occurrences After Bigram
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
//
//For each such occurrence, add "third" to the answer, and return the answer.
//
//
//
//Example 1:
//
//Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
//Output: ["girl","student"]
//Example 2:
//
//Input: text = "we will we will rock you", first = "we", second = "will"
//Output: ["we","rock"]
//
//
//Note:
//
//1 <= text.length <= 1000
//text consists of space separated words, where each word consists of lowercase English letters.
//1 <= first.length, second.length <= 10
//first and second consist of lowercase English letters.
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: https://leetcode.com/problems/occurrences-after-bigram/
//******************************************************************************************************************


public class e_1078_OccurrencesAfterBigram {
    public static void main(String[] args) {
        String[] result = new e_1078_OccurrencesAfterBigram().findOcurrences("alice is a good girl she is a good student", "a", "good");
        for (String s :
                result) {
            System.out.printf("%s\n",s);
        }
    }

    public String[] findOcurrences(String text, String first, String second) {


        //sply string by space
        String[] strs = text.split("\\s+");
        //store current first and second
        String cfirst = "";
        String cseconf = "";
        //result
        List<String> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            //incase of empty elems
            if (strs[i].trim().equals("")) continue;
            //always keep track and update of current first/second
            cfirst = cseconf;
            cseconf = strs[i];
            //if both equals, add the next elem to the results
            if (cfirst.equals(first) && cseconf.equals(second)) {
                if (i < strs.length - 1) {
                    result.add(strs[i + 1]);
                }
            }
        }

        return result.stream().toArray(String[]::new);
    }

    //better soln to search manually
    public String[] findOcurrences2(String text, String first, String second) {
        String pattern = first + " " + second;
        int skip = first.equals(second) ? first.length() : pattern.length();
        int idx = text.indexOf(pattern);
        List<String> tmpRet = new ArrayList<>();
        while (idx != -1) {
            int startIdx = idx + skip + 1;
            if (startIdx >= text.length()) {
                break;
            }
            int endIdx = text.indexOf(' ', idx + skip + 1);
            String tmpStr;
            if (endIdx == -1) {
                tmpStr = text.substring(startIdx);
            } else {
                tmpStr = text.substring(startIdx, endIdx);
            }
            tmpRet.add(tmpStr);
            idx = text.indexOf(pattern, idx + skip);
        }
        if (tmpRet.isEmpty()) {
            return new String[0];
        }
        String[] ret = new String[tmpRet.size()];
        for (int i = 0; i < tmpRet.size(); ++i) {
            ret[i] = tmpRet.get(i);
        }
        return ret;
    }

    @Test
    public void TestfindOcurrences() {
        Assert.assertArrayEquals(new String[]{}, findOcurrences("", "", ""));
        Assert.assertArrayEquals(new String[]{"girl", "student"}, findOcurrences("alice is a good girl she is a good student", "a", "good"));
        Assert.assertArrayEquals(new String[]{"we", "rock"}, findOcurrences("we will we will rock you", "we", "will"));
        Assert.assertArrayEquals(new String[]{"we"}, findOcurrences("we will we will", "we", "will"));
        Assert.assertArrayEquals(new String[]{"we"}, findOcurrences(" w will we will", "w", "will"));
        Assert.assertArrayEquals(new String[]{"rock"}, findOcurrences("we we will rock you", "we", "will"));


        Assert.assertArrayEquals(new String[]{}, findOcurrences2("", "", ""));
        Assert.assertArrayEquals(new String[]{"girl", "student"}, findOcurrences2("alice is a good girl she is a good student", "a", "good"));
        Assert.assertArrayEquals(new String[]{"we", "rock"}, findOcurrences2("we will we will rock you", "we", "will"));
        Assert.assertArrayEquals(new String[]{"we"}, findOcurrences2("we will we will", "we", "will"));
        Assert.assertArrayEquals(new String[]{"we"}, findOcurrences2(" w will we will", "w", "will"));
        Assert.assertArrayEquals(new String[]{"rock"}, findOcurrences2("we we will rock you", "we", "will"));
    }
}
