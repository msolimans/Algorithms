package com.leetcode;

import com.leetcode.test.e_557ReverseWordInString3Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by msoliman on 10/23/17.
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.


 */
public class e_557_ReverseWordsInString3 {
    public static void main(String[] args){

        System.out.println(new e_557_ReverseWordsInString3().reverseWords("Let's take LeetCode contest"));
    }

    public  String reverseWords(String s) {

        String[] arr = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(String str: arr) {

            reverseWord(result, str);
            result.append(" ");

        }

        return  result.toString().trim();
    }

     public  String reverseWord(StringBuilder result, String word){


        for(int i = word.length() - 1; i>= 0;i--){
            result.append(word.charAt(i));
        }


        return result.toString();
    }


}
