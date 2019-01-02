package com.probs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by msoliman on 5/1/17.
 */
public class p_12_PermutationGeneration {




    public static void main(String[] args){

        String[] ss = perm("abcd");
        System.out.println(ss.length + "pairs");

        for(String s : ss)
            System.out.println(s);

    }


    static String[] perm(String str){

        if(str.length() == 2){
            String s = new StringBuilder(str).reverse().toString();

            return new String[]{str, s};
        }


        List<String> arr = new ArrayList<>();



        for(int i=0;i<str.length();i++) {


           String[] ress = perm((i>0?str.substring(0,i):"") + (i==str.length() - 1? "": str.substring(i+1)));

            for(int j = 0;j<ress.length;j++){
                ress[j] = str.charAt(i) + ress[j];
            }

            Collections.addAll(arr, ress);
        }

        return  arr.toArray(new String[0]);
    }




}
