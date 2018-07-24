package com.alkhawarizms.Search;

/**
 * Created by msoliman on 1/21/17.
 */
public class Linear {
    boolean search(int[] arr, int term){
        //best case: O(1)]
        //worst case: O(n)

        for(int i: arr){
            if(i == term)
                return  true;
        }

        return  false;//O(n)
    }
}
