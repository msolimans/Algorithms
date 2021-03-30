package com.leetcode;


import org.junit.Assert;
import org.junit.Test;

//m_151_ReverseWordsInAString 
//Show Topic Tags

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an input string, reverse the string word by word.
//
//
//
//Example 1:
//
//Input: "the sky is blue"
//Output: "blue is sky the"
//Example 2:
//
//Input: "  hello world!  "
//Output: "world! hello"
//Explanation: Your reversed string should not contain leading or trailing spaces.
//Example 3:
//
//Input: "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
//
//
//Note:
//
//A word is defined as a sequence of non-space characters.
//Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
//You need to reduce multiple spaces between two words to a single space in the reversed string.
//
//
//Follow up:
//
//For C programmers, try to solve it in-place in O(1) extra space.

//******************************************************************************************************************
//Companies: Microsoft | 14  Amazon | 5  Facebook | 3
//******************************************************************************************************************
//Link: https://leetcode.com/problems/reverse-words-in-a-string/
//******************************************************************************************************************

public class m_151_ReverseWordsInAString {


    //In-place replacements
    //38% Faster than other solutions
    public String reverseWords1(String s) {

        String[] arr = s.split("\\s+");
        int start = 0, end = arr.length - 1;
        String temp;

        while (start < end) {
            //ignore empty entries [coming from whitespaces]
            if (arr[start].trim().equals("")) {
                start++;
                continue;
            }
            //ignore empty entries [coming from whitespaces]
            if (arr[end].trim().equals("")) {
                end--;
                continue;
            }

            //swap
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            //update indices
            start++;
            end--;
        }


        return String.join(" ", arr).trim();


    }

    //no extra space
    //75% Faster
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        //st is the start of our word
        int st = s.length() - 1;
        //end is the end of word
        int en = s.length();



        while (st >= 0) {
            if (s.charAt(st) == ' ') {
                //in case it whitespace char, move en with you to the left to avoid building up extra spaces
                en = st;
            } else if (st == 0) {
                //we're done, here we can't check previous elem as this is our first elem. substring from 0...en
                sb.append(s, 0, en);
                sb.append(" ");
            } else if (s.charAt(st - 1) == ' ') {//once we see a previous character is whitepsace it is time to combine our word and do substring
                //please note substring take the first index @st to @en (en is excluded)
                sb.append(s, st, en);
                sb.append(" ");
            }

            //we are building up our word, move st further more to the left
            st--;
        }


        //make sure you do trim to get rid of extra spaces
        return sb.toString().trim();
    }


    @Test
    public void Testm_151_ReverseWordsInAString() {

        Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));
        Assert.assertEquals("world! hello", reverseWords("  hello world!  "));
        Assert.assertEquals("example good a", reverseWords("a good   example "));
        Assert.assertEquals(".fumuhau ym. qjktum yqo! a,", reverseWords1("a, yqo! qjktum ym. .fumuhau"));

//
        Assert.assertEquals("blue is sky the", reverseWords1("the sky is blue"));
        Assert.assertEquals("world! hello", reverseWords1("  hello world!  "));
        Assert.assertEquals("example good a", reverseWords1("a good   example "));
        Assert.assertEquals("b example good a", reverseWords1("a good   example b"));
        Assert.assertEquals("b example good a", reverseWords1("    a good   example   b    "));
        Assert.assertEquals("b example good aa", reverseWords1("aa good   example   b    "));
        Assert.assertEquals("a a", reverseWords1("   a   a "));
        Assert.assertEquals("a a b a b a", reverseWords1("   a  b a b a  a "));
        Assert.assertEquals(".fumuhau ym. qjktum yqo! a,", reverseWords1("a, yqo! qjktum ym. .fumuhau"));


    }


}
