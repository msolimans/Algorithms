package com.probs;

import java.util.HashSet;

/**
 * Created by msoliman on 4/21/17.
 */
public class p_1_SmallLetters {

    // Problem 1
    // Check if the string provided has all lower case characters

    //java -jar /Users/msoliman/.m2/repository/com/javarepl/javarepl/428/javarepl-428.jar

    public static boolean run(String str){
        HashSet set = new HashSet();
        int ch;

        for(int i=0;i<str.length();i++){
            ch = (int)str.charAt(i);

            if(ch >= 97 && ch <= 122){
                if(!set.contains(ch))
                    set.add(ch);
            }
        }

        if(set.size() < 26)
            return false;
        return true;
    }





}
