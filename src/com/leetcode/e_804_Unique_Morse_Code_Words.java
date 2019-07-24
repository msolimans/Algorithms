package com.leetcode;

//e_804_Unique_Morse_Code_Words
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
//
//        For convenience, the full table for the 26 letters of the English alphabet is given below:
//
//        [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
//        Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
//
//        Return the number of different transformations among all words we have.
//
//        Example:
//        Input: words = ["gin", "zen", "gig", "msg"]
//        Output: 2
//        Explanation:
//        The transformation of each word is:
//        "gin" -> "--...-."
//        "zen" -> "--...-."
//        "gig" -> "--...--."
//        "msg" -> "--...--."
//
//        There are 2 different transformations, "--...-." and "--...--.".
//        Note:
//
//        The length of words will be at most 100.
//        Each words[i] will have length in range [1, 12].
//        words[i] will only consist of lowercase letters.


//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/unique-morse-code-words/
//******************************************************************************************************************

public class e_804_Unique_Morse_Code_Words {

    //all representation of morse codes in an array
    String[] mCodes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    //HashMap myMap = new HashMap<Character,String>() {{
    //  put('a', ".-");
    //  put('b', "-..");
    //}};


    public static void main(String[] args) {
        System.out.print(new e_804_Unique_Morse_Code_Words().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));


    }

    //returns the unique morse codes for the input words
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        int sum = 0;
        for (String str :
                words) {
            String code = getMorseCode(str);
            if (!set.contains(code)) {
                sum++;
                set.add(code);
            }
        }

        return sum;
    }


    //getMorseCode returns the morse code representation of the input string
    String getMorseCode(String str) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        //loop through all character of str
        for (char ch : str.toCharArray()) {

            //translates each character to correct index of the array, an alternative can still use hash map<character, string> instead of arrays
            // hashmap.get(ch), this needs initialization of all morse codes into that hash map
            //characters A ... Z represented in ascii range from 65 ... 90
            //characters a ... z represented in ascii range from 97 ... 122
            if (ch >= 65 && ch <= 90) {
                index = ch % 65;//to get zero based index
            } else {
                index = ch % 97;
            }


            builder.append(mCodes[index]);
        }


        return builder.toString();
    }


    //////////////////////////////////////////////////////////////////////////////////////////
    //Unit tests
    //////////////////////////////////////////////////////////////////////////////////////////
    //the following test case will cover unique morse representation
    @Test
    public void TestuniqueMorseRepresentations() {
        Assert.assertEquals(2, uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        Assert.assertEquals(1, uniqueMorseRepresentations(new String[]{"gin"}));
    }


    //the following test case will cover getMorseCode method
    @Test
    public void TestgetMorseCode() {
        Assert.assertEquals(".--...-.-.", getMorseCode("abc"));
        Assert.assertEquals("--...-.", getMorseCode("gin"));
        Assert.assertEquals("--...-.", getMorseCode("zen"));
        Assert.assertEquals("--...--.", getMorseCode("gig"));
        Assert.assertEquals("--...--.", getMorseCode("msg"));
    }


}
