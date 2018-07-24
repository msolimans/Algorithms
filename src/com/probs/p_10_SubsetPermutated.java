package com.probs;

/**
 * Created by msoliman on 5/1/17.
 */
public class p_10_SubsetPermutated {
    public static void  main(String[] args){

       // System.out.println(isSubsetPermutated("abc", "aabc"));
        System.out.println(isSubsetPermutated("aab", "bAabc"));

    }

    static boolean isPermutation(String str1, String str2){
        int[] arr = new int[255];

        for(int i=0;i<str1.length();i++) {
            int indx = (int) str1.charAt(i) % 255;
            arr[indx] = arr[indx]+1;
        }

        for(int i=0;i<str2.length();i++) {
            int indx = (int) str1.charAt(i) % 255;

            if(arr[indx] <= 0)
                return false;

            arr[indx] = arr[indx] - 1;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0 || arr[i] < 0){
                return false;
            }
        }

        return true;
    }


    static boolean isSubsetPermutated(String str1, String str2){
        int h1= hash(str1, 0, str1.length());

        int h2 = hash(str2, 0, str1.length());

        int indx = 0;
        while(indx <= str2.length() - str1.length()){
            if(indx > 0)
                h2 = h2 + hash(str2, indx + str1.length() - 1, 1) - (int)str2.charAt(indx - 1);

            if(h1==h2 && isPermutation(str1, str2.substring(indx, indx + str1.length())))
                return true;

            indx++;
        }

        return false;
    }


    static int hash(String str, int start, int length){
        int hash = 0;

        while(--length >= 0)
            hash += (int) str.charAt(start++);

        return hash;
    }
}
