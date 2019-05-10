package com.ocw.c6006.lect4;

import java.util.Arrays;

public class HeapSort {
    //take unordered array and convert it to max heap => for n/2 down to 1: max_heapify() [started by n/2 because leaves are good]
    //                                                   simple analysis: O (n log n) however it is O(n)
    //                                                     n/4 * (c) + n/8 * (2 c) + n/16 * (3 c) ..... 1 * (logn c)  suppose k = n/4
    //                                                    c 2 ^ k (1/2^0 + 2/2^1 + 3/2^3 ... k+1/2^k)
    //                                                    c 2 ^ k               CONSTANT
    //                                                    c * 2 ^ k = O(n)
    //extract elements will give us a sorted array    => (n steps/elems) * log n (for max heapify)
    //OR
    //swap elem[1] with elem[n] O(1) for all elems (n steps/elems) => discard last elem => heap size becomes from 0 to n-1 => max_heapify for arr [0...n-1] this is O(log n) for each step/elem
    //total: O(n log n)
    //naive example (just for simplicity to show how it works)
    public static int[] sort(int[] arr) throws Exception {
        Heap heap = new Heap(arr.length);


        for(int i = 1;i<arr.length;i++){
            heap.insert(arr[i]);
        }

        for(int i=arr.length - 1;i>=1;i--){
           arr[i] = heap.extractMax();
        }

        return arr;

    }


    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(sort(new int[]{0, 1, 3, 2, 9})));
    }

}
