package com.probs;

import java.util.Stack;

/**
 * Created by msoliman on 6/16/17.
 */
public class p_20_ReverseString {
    public static void main(String[] args){
        System.out.println(run0("hel3lo"));
    }

    //using stack
    static String run0(String s){
        Stack<Character> st = new Stack<>();

        for(int i =0;i<s.length();i++){
            st.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return  sb.toString();

    }

    //O(n)
    private static String run(String s) {
        char[] cs = s.toCharArray();

        int indx1 = 0, indx2 = cs.length - 1;

        char temp = ' ';
        while (indx1 < indx2){
            temp = s.charAt(indx1);
            cs[indx1] = cs[indx2];
            cs[indx2] = temp;
            indx1++;
            indx2--;
        }

        return String.valueOf(cs);

    }

}
