package com.glassdoor.sonoma;


/**
 * Created by msoliman on 10/29/17.
 * Write a program that outputs the string representation of numbers from 1 to n.

 But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 For numbers which are multiples of both three and five output “FizzBuzz”.

 Example:

 n = 15,

 Return:
 [
 "1",
 "2",
 "Fizz",
 "4",
 "Buzz",
 "Fizz",
 "7",
 "8",
 "Fizz",
 "Buzz",
 "11",
 "Fizz",
 "13",
 "14",
 "FizzBuzz"
 ]
 * Link: https://leetcode.com/problems/array-partition-i/description/
 */
public class FizzBuzz {

   public static void main(String[] args){
       for(int i =1;i<=15;i++){
           if(i % 3 == 0 && i%5 == 0)
               System.out.println("FizzBuzz");
           else if(i % 3 == 0)
               System.out.println("Fizz");
           else if(i % 5 == 0)
               System.out.println("Buzz");
           else
               System.out.println(i);
       }

   }


   // //Fizz Buzz, recursion, object oriented programming basic questions
//The exam was ~25 questions and was time at 30 minutes. It covered a lot of technical details about C#, JS, and SQL.
    //The functions were checking overlapping times between two dates, finding a substring in a string, building a binary tree using recursion, and finding a prime number. You are given a week to complete this and send it back, and I don't think it looks better or worse if you take your time as they interview a lot of busy college kids.
    //a simple board game(I won't be any more specific) in which you show off your thinking/planning process rather than your coding.
    //find the nth prime number, find sequence of set in another set, other two were easy
    //how I would structure code for a board game
    /// What is the difference between an abstract class and an interface
    //The first problem he presented me with made use of the C# Tuple class which I had never seen before. He tried explaining it but eventually gave me another problem. Apparently I wasn't the first to complain about the tuple.
    //1) Find the Nth Prime 2) Make a method to return a boolean indicating if a set of input dates overlapped 3.) Find the needle in the haystack (an array of strings (haystack) an array of strings (needle)) 4) Build a tree view in code using a dataset that is set for you already. They gave me a week to do it but I turned it in three days later.
//creating the structure of a checkers game.

}
