package com.probs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by msoliman on 5/13/17.
 */
public class p_12_PermutationGenerationOptimized {
    public static void main(String[] args){

        List<String> lst = new ArrayList<>();
        run("", "abc", lst);
        System.out.print(Arrays.toString(lst.toArray()));


    }

    static void run(String prefix, String str, List<String> lst){
        if(str.isEmpty())
            lst.add(prefix);

        for(int i=0;i<str.length();i++){
            run(prefix+str.charAt(i), str.substring(0, i) +str.substring(i+1) , lst);
        }


    }
}
