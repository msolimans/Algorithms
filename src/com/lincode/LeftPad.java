package com.lincode;

/**
 * Created by msoliman on 2/17/17.
 */
public class LeftPad {
//    You know what, left pad is javascript package and referenced by React:
//    Github link
//
//    One day his author unpublished it, then a lot of javascript projects in the world broken.
//
//    You can see from github it's only 11 lines.
//
//    You job is to implement the left pad function. If you do not know what left pad does, see examples below and guess.
//
//    Have you met this question in a real interview? Yes
//
//            Example
//    leftpad("foo", 5)
//>> "  foo"
//
//    leftpad("foobar", 6)
//>> "foobar"
//
//    leftpad("1", 2, "0")
//>> "01"

    /*
     * @param originalStr the string we want to append to with spaces
     * @param size        the target length of the string
     * @return a string
     */
    public static void main(String[] s) {
        System.out.print(leftPad("foobar", 6, '0'));


    }

    /*
     * @param originalStr the string we want to append to
     * @param size        the target length of the string
     * @param padChar     the character to pad to the left side of the string
     * @return a string
     */

    static public String leftPad(String originalStr, int size) {
        // Write your code here
        return leftPad(originalStr, size, ' ');
    }

    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here
        int diff = size - originalStr.length();

        while (diff>0){
            originalStr = padChar + originalStr;
            diff--;
        }


        return originalStr;
    }

}
