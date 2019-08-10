package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by msoliman on 5/4/17.
 */
public class e_202_HappyNumber {

    public static void main(String[] args) {
        System.out.print(run(2));

    }

    static boolean run(int num) {
        int result = 0;
        Set<Integer> set = new HashSet<>();

        while (true) {
            result = 0;

            while (num % 10 != num) {
                result += (num % 10) * (num % 10);
                num /= 10;
            }

            result += (num % 10) * (num % 10);


            if (result == 1)
                return true;

            if(set.contains(result))
                return false;

            set.add(result);



            num = result;


        }



    }

}
