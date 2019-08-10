package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 5/4/17.
 */
public class e_535_EncodeDecodeUrls {

    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args){
        String s = encode("http://leetcode.com/tiny");
        System.out.println(decode(s));

    }



    static String encode(String longUrl){
        //hash key and save to hashmap


        String k = ((Integer)longUrl.hashCode()).toString();
        map.put(k,longUrl);

        return k;


    }

    static String decode(String shortUrl){

        return map.getOrDefault(shortUrl, "");
    }
}
