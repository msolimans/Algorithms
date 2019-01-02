package com.probs;

/**
 * Created by msoliman on 5/1/17.
 */
public class p_11_ChkSubString {
    public static void main(String[] args){
        System.out.println(isSubstring("ab", "dddab"));
        System.out.println(isSubstring("ab", "ddsssasavaaassdaaabdsdsds"));

    }

    //is str1 is a substring from str2
    static boolean isSubstring(String str1, String str2){

        int indx = 0;
        while(indx <= str2.length() - str1.length()){
            int res = compare(str1, str2, indx, str1.length());
            if(res == 0) return true;
            indx = res;
        }

        return false;
    }

    static int compare(String str1, String str2, int start, int length){

        int i = 0;

        while(--length>=0){
            if(str1.charAt(i++) != str2.charAt(start++))
                return start;
        }

        return 0;
    }
}
