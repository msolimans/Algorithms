package com.leetcode;

//771. Jewels and Stones

//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
//
//The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
//
//Example 1:
//
//Input: J = "aA", S = "aAAbbbb"
//Output: 3
//Example 2:
//
//Input: J = "z", S = "ZZ"
//Output: 0
//Note:
//
//S and J will consist of letters and have length at most 50.
//The characters in J are distinct.
//******************************************************************************************************************
//Companies: NA
//******************************************************************************************************************
//Link: https://leetcode.com/problems/jewels-and-stones/
//******************************************************************************************************************


public class e_771_JewelsandStones {
    public static void main(String[] args) {
        System.out.println(new e_771_JewelsandStones().numJewelsInStones("aA", "aAAbbbb"));

    }

    //we save all Jewels into a hashset for quick retrieval O(1) then we loop through all characters inside Strones "S"
    //and for any of characters that exist in J increment counter
    //Also, we can use array of characters here instead of hashset and put/retrieve the character in specific index (based on its ascii representation)
    //Time Complexity: O(n)
    //Auxiliary Space: O(len(J)), maximum is the number of alphabets as we only store existence of character
    public int numJewelsInStones(String J, String S) {
        int count = 0;

        //we save (index) all jewels
        HashSet<Character> set = new HashSet<>();
        for (Character ch :
                J.toCharArray()) {
            set.add(ch);
        }

        //loop through all strones and if any of them exists in `set` increment count by 1
        for (Character ch : S.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            }
        }

        return count;


    }


    @Test
    public void TestnumJewelsInStones() {
        Assert.assertEquals(3, numJewelsInStones("aA", "aAAbbbb"));
        Assert.assertEquals(0, numJewelsInStones("", ""));
        Assert.assertEquals(2, numJewelsInStones("Z", "ZzZ"));
        Assert.assertEquals(1, numJewelsInStones("z", "ZzZ"));
        Assert.assertEquals(0, numJewelsInStones("z", "ZZ"));

    }
}
