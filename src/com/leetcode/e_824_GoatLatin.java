package com.leetcode;


//824. Goat Latin
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import javax.print.attribute.HashAttributeSet;
import java.util.HashSet;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
//
//        We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
//
//        The rules of Goat Latin are as follows:
//
//        If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
//        For example, the word 'apple' becomes 'applema'.
//
//        If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
//        For example, the word "goat" becomes "oatgma".
//
//        Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
//        For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
//        Return the final sentence representing the conversion from S to Goat Latin.
//
//
//Example 1:
//
//        Input: "I speak Goat Latin"
//        Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
//Example 2:
//
//        Input: "The quick brown fox jumped over the lazy dog"
//        Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/goat-latin/
//******************************************************************************************************************


public class e_824_GoatLatin {
    public static void main(String[] args) {

    }

    public String toGoatLatin(String S) {
        HashSet<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('A');
        vowel.add('e');
        vowel.add('E');
        vowel.add('i');
        vowel.add('I');
        vowel.add('o');
        vowel.add('O');
        vowel.add('u');
        vowel.add('U');

        StringBuilder sb = new StringBuilder();

        String[] strs = S.split(" ");
        int count = 1;
        for (String str :
                strs) {
            if (vowel.contains(str.charAt(0))) {
                sb.append(str).append("ma");
            } else {
                sb.append(str.substring(1)).append(str.charAt(0)).append("ma");
            }

            for (int i = 0; i < count; i++) {
                sb.append("a");
            }
            sb.append(" ");

            count++;

        }

        return sb.toString().trim();

    }

    @Test
    public void TesttoGoatLatin() {

        Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", toGoatLatin("I speak Goat Latin"));
        Assert.assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa", toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

}
