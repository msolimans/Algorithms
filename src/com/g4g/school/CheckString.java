package com.g4g.school;

import java.util.Scanner;

/**
 * Created by msoliman on 10/15/17.
 */
public class CheckString {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(--t > 0){
            String s = scan.next();
            if(null == s && s.length() == 1) {
                System.out.println("YES");
                continue;
            }

            for(int i=1;i<s.length();i++){
                System.out.println("NO");

            }
        }
    }
}
