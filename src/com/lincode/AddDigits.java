package com.lincode;

/**
 * Created by msoliman on 2/16/17.
 */
public class AddDigits {
    public static void main(String[] a) {

        System.out.println(addDigits_recursive(654309234));
    }


    static int addDigits_recursive(int num) {
        //125/10 = 125 - 100 = 25
        //25/10 = 25 - 20
        //5/10 = 5

        if (num % 10 == num)
            return  num;

        return (num % 10) + addDigits_recursive(num / 10);
    }


}
