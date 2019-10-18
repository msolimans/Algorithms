package com.leetcode;

//e_1002_FindCommonCharacters 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
//
//You may return the answer in any order.
//
//
//
//Example 1:
//
//Input: ["bella","label","roller"]
//Output: ["e","l","l"]
//Example 2:
//
//Input: ["cool","lock","cook"]
//Output: ["c","o"]
//
//
//Note:
//
//1 <= A.length <= 100
//1 <= A[i].length <= 100
//A[i][j] is a lowercase letter

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/find-common-characters/
//******************************************************************************************************************

public class e_1002_FindCommonCharacters {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new e_1002_FindCommonCharacters().commonChars(new String[]{"bella", "blahblahblah", "label", "roller"}).toArray()));

    }

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if (A.length == 0)
            return result;
        else if (A.length == 1) {
            for (Character c : A[0].toCharArray()) {
                result.add(Character.toString(c));
            }
        } else {
            int[] resArr = new int[26];
            boolean firstRun = true;

            //loop through all strings array
            for (String s : A) {
                //initialize counter arr
                int[] current = new int[26];

                //count how many chars for each string
                for (int i : s.toCharArray()) {
                    current[i - 'a']++;
                }

                //merge here to final results array
                for (int i = 0; i < 26; i++) {
                    if (firstRun || current[i] < resArr[i])
                        resArr[i] = current[i];
                }

                firstRun = false;

            }

            //loop thru counter results array to add those characters to final results list
            for (int i = 0; i < 26; i++) {
                if (resArr[i] > 0) {
                    //dump chars to results [count for duplicates]
                    char c = (char) (i + 'a');
                    while (--resArr[i] >= 0) {
                        result.add(Character.toString(c));
                    }

                }

            }
        }


        return result;

    }


    @Test
    public void TestCommonChars() {
        Assert.assertArrayEquals(new String[]{"e", "l", "l"}, commonChars(new String[]{"bella", "label", "roller"}).toArray());
        Assert.assertArrayEquals(new String[]{"l", "l"}, commonChars(new String[]{"bella", "blahblahblah", "label", "roller"}).toArray());

    }
}
