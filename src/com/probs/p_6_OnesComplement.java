package com.probs;

/**
 * Created by msoliman on 4/23/17.
 */
public class p_6_OnesComplement {
    public static void main(String[] args){

        System.out.println(String.format("%d: %s", 2, run(2)));
        System.out.println(String.format("%d: %s", 11, run(11)));
        System.out.println(String.format("%d: %s", 16, run(16)));

    }

    static int run(int num){

        //flipping or toggling formula: s ^= (1 << k) where k is the  index of the bit we want to toggle or flip

        for(short i=0;i<8;i++){
            num ^= (1 << i);
        }

        return num;
    }
}

