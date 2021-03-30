package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

//m_186_ReverseWordsInAStringII 
//Show Topic Tags

/**
 * Tag: String
 */

/*Description*/
//******************************************************************************************************************
//Given an input string , reverse the string word by word.
//
//Example:
//
//Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
//Note:
//
//A word is defined as a sequence of non-space characters.
//The input string does not contain leading or trailing spaces.
//The words are always separated by a single space.
//Follow up: Could you do it in-place without allocating extra space?
//******************************************************************************************************************
//Companies: Microsoft | 3
//******************************************************************************************************************
//Link: https://leetcode.com/problems/reverse-words-in-a-string-ii/
//******************************************************************************************************************

public class m_186_ReverseWordsInAStringII {

    //make 2 reverses of char array will result in correct answer
    public void reverseWords(char[] s) {

        //first reverse is to reverse all array for example "My Name is Muhammad" will be "dammahuM si emaN yM"
        reverse(s, 0, s.length - 1);

        //then reverse each word separately  "dammahuM si emaN yM" will result in "Muhammad is Name My"
        int start = s.length - 2;
        int end = s.length - 1;
        while (start >= 0) {
            //at index 0, reverse it as we are completely done otherwise the first word will not be reversed correctly
            if (start == 0) {
                reverse(s, 0, end);
            } else if (s[start] == ' ') {
                //when we reach whitespace, reverse should start from next index to the end
                reverse(s, start + 1, end);
                //update the end index for next reverses to be the previous index to the whitespace
                end = start - 1;
            }
            start--;
        }

    }


    //2 pointers to take care of reverse from start to end
    void reverse(char[] arr, int s, int e) {

        //swap between s and e
        while (s < e) {
            char t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++;
            e--;
        }


    }


    @Test
    public void TestReverse() {
        char[] arr = new char[]{'M', 'y', ' ', 'N', 'a', 'm', 'e', ' ', 'i', 's', ' ', 'M', 'u', 'h', 'a', 'm', 'm', 'a', 'd'};
        reverse(arr, 0, arr.length - 1);
        Assert.assertArrayEquals(new char[]{'d', 'a', 'm', 'm', 'a', 'h', 'u', 'M', ' ', 's', 'i', ' ', 'e', 'm', 'a', 'N', ' ', 'y', 'M'},
                arr);
    }

    @Test
    public void Testm_186_ReverseWordsInAStringII() {
        char[] arr = new char[]{'M', 'y', ' ', 'N', 'a', 'm', 'e', ' ', 'i', 's', ' ', 'M', 'u', 'h', 'a', 'm', 'm', 'a', 'd'};
        reverseWords(arr);


        Assert.assertArrayEquals(new char[]{'M', 'u', 'h', 'a', 'm', 'm', 'a', 'd', ' ', 'i', 's', ' ', 'N', 'a', 'm', 'e', ' ', 'M', 'y'},
                arr);

        ///
        char[] arr1 = new char[]{'W', 'o', 'r', 'l', 'd'};
        reverseWords(arr1);

        Assert.assertArrayEquals(new char[]{'W', 'o', 'r', 'l', 'd'},
                arr1);


    }
}
