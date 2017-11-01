package com.g4g.Easy;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;


//Decimal Equivalent of Binary Linked List (Function Problem)
//Show Topic Tags

/**
 * LinkedList, Stack
 */

/*Description*/
//******************************************************************************************************************
//
//******************************************************************************************************************
//Companies: VMWare, Oracle
//******************************************************************************************************************
//Link: http://practice.geeksforgeeks.org/problems/decimal-equivalent-of-binary-linked-list/1/
//******************************************************************************************************************
/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
This is method only submission.  You only need to complete the method. */
public class DecimalEquivalentOfBinaryLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int d){ data = d; next = null;}
    }
    static class LinkedList{
        Node head;

        void add(int d){
            if(head == null)
                head = new Node(d);
            else {
                Node n = head;
                while (n.next != null)
                    n = n.next;

                n.next = new Node(d);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            //construct linked list
            int len = scan.nextInt();
            LinkedList lst = new LinkedList();
            for(int i=0;i<len;i++){
                    lst.add(scan.nextInt());
            }

            System.out.println(run1(lst));
        }
    }


    //simplest answer however g4g did not accept the answer as it doesn't know BigInteger, let's implement multiplication and additions for integers
    static long run(LinkedList lst) {
        if(lst.head == null)
            return  0;
        Stack<Integer> st = new Stack<>();
        Node n = lst.head;

        while(n != null){

            st.push(n.data);
            n = n.next;

        }

        int i = 0;
        //save the result into a big integer to avoid overflow
        BigInteger result1 = BigInteger.valueOf(0);

        while(!st.isEmpty()){
            if(st.pop() == 1) {
                result1 = result1.add(BigInteger.valueOf (2).pow(i));

            }

            i++;
        }

        return result1.remainder(BigInteger.valueOf(1000000007L)).longValue();
    }


    //simplest answer however g4g did not accept the answer as it doesn't know BigInteger, let's implement multiplication and additions for integers
    static long run1(LinkedList lst) {
        if(lst.head == null)
            return  0;
        Stack<Integer> st = new Stack<>();
        Node n = lst.head;

        while(n != null){

            st.push(n.data);
            n = n.next;

        }

        int i = 0;
        int counter = 0;

        //save the result into a big integer to avoid overflow
        BigInteger result1 = BigInteger.valueOf(0);

        while(!st.isEmpty()){
            if(st.pop() == 1) {
                counter += i;
            }

            if(counter >= 29)
                counter -= 29;

            i++;
        }

        return (long)Math.pow(2,counter) % 1000000007L;
    }





}
