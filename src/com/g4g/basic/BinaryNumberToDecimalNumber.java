package com.g4g.basic;

import java.util.Scanner;

import static com.oracle.jrockit.jfr.ContentType.Bytes;

public class BinaryNumberToDecimalNumber {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            int input = scan.nextInt();
            System.out.println(toDecimal(input));
        }

    }

    static int toDecimal(int input){
        int sum = 0;
        for(short i = 0;i<8;i++){
            sum += input & (1 << i);
        }
        return sum;
    }
}
