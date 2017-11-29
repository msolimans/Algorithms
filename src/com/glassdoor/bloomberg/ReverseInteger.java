package com.glassdoor.bloomberg;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


//Reverse Integer

/*Description*/
//******************************************************************************************************************
// Reverse Integer '
//1234 => 4321
//******************************************************************************************************************
//Companies: Bloomberg
//******************************************************************************************************************

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
           int n = scan.nextInt();
            System.out.println(run(n));
        }
    }

    static int run(int n) {

        //build a queue
        LinkedList<Integer> queue = new LinkedList<>();

        //loop through the number and extract the right most part of the number each time and enqueue
        while(n > 0){
            queue.addFirst(n % 10);
            n = n / 10;
        }

        int result = 0;
        int c = 1;

        //loop through the queue and times the extracted number by multiples of 10s and add to the result
        while(!queue.isEmpty()){
            result += queue.pollFirst() * c;
            c *= 10;
        }

        return  result;
    }
}
