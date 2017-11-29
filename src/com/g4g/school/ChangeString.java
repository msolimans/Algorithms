package com.g4g.school;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created by msoliman on 10/15/17.
 */
public class ChangeString {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();


        String[] str = new String[T];

        while(--T >= 0){
            String s = scan.next();
            int c = s.charAt(0);
            if(c >= 97 && c <= 122)
                str[T] = s.toLowerCase();
            else
                str[T] = s.toUpperCase();

        }

        for(int i=str.length-1;i>=0;i--){
            System.out.println(str[i]);
        }

    }
}
