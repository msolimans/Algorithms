package com.educative.sliding;

//Fruits into Baskets (Medium)
//Given an array of characters where each character represents a fruit tree.
// you are given two baskets and your goal is to put maximum number of fruits in each basket.
// The only restriction is that each basket can have only one type of fruit.
//
//You can start with any tree, but once you have started you can’t skip a tree.
// You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
//
//Write a function to return the maximum number of fruits in both the baskets.
//
//Example 1:
//
//Input: Fruit=['A', 'B', 'C', 'A', 'C']
//Output: 3
//Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
//Example 2:
//
//Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
//Output: 5
//Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
//This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
//link:
//https://www.educative.io/courses/grokking-the-coding-interview/Bn2KLlOR0lQ

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class m_FruitsintoBaskets {

    public static void main(String[] args) {
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));

    }

    public static int findLength(char[] arr) {
        int s = 0, e = 0, len = 0, res = 0;
        Map<Character, Integer> inBasket = new HashMap<>();

        //can be achieved by queue and hashset => will double storage capacity thu

        while (s <= e && e < arr.length) {
            //if fruit doesn't exist in basket, remove the last one we put
            if (!inBasket.containsKey(arr[e]) && inBasket.size() == 2) {

                //time to record len since we will start removing items from left
                if (len > res)
                    res = len;

                //remove properly by item remove or decrease of occurence
                if (inBasket.get(arr[s]) == 1)
                    inBasket.remove(arr[s]);
                else
                    inBasket.put(arr[s], inBasket.get(arr[s]) - 1);

                //decrease len
                len--;
                //shift start pointer
                s++;
            }


            //put it in basket
            inBasket.putIfAbsent(arr[e], inBasket.getOrDefault(arr[e], 0) + 1);
            //increase len
            len++;
            //shift end pointer
            e++;
        }

        //handle cases like "aaaa" "aaaabbbbb"
        if (len > res)
            res = len;


        return res;
    }

    @Test
    public void TestFindLength() {
        Assert.assertEquals(3, findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        Assert.assertEquals(5, findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }

}
