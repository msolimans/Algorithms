package com.ocw.c6006.lect4;

import org.junit.Assert;
import org.junit.Test;

public class Heap {
    //heap is an impl of priority queue
    //based on array implementation
    //Structure of array as nearly complete binary tree
    //Heap Representation as an array
    //root of the tree is the element at index 1
    //parent(i) = i/2
    //left child(i) = i * 2
    //right child(i) = i * 2 + 1
    //Types of Heap:
    //1) Max Heap: Key of any node is GREATER THAN OR EQUAL TO its children
    //2) Min Heap: Key of any node is LESS THAN OR EQUAL TO its children
    //Complexity of Heapify: O(logn)
    //insert elem into priority queue

    private int[] arr;
    int size = 0, index = 1;


    public Heap(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        index = arr.length ;
        for (int i=arr.length/2;i > 0; i--){
            maxHeapify(i);
        }
    }

    public Heap(int size) {
        arr = new int[size + 1];
        this.size = size;

    }

    public int[] getArr() {
        return arr;
    }

    void insert(int x) {
        arr[index++] = x;
        maxHeapify(index - 1);
    }

    void insert(int[] xs) {
        for (int x : xs) {
            arr[index++] = x;
        }
    }

    //bottom to top
    void maxHeapify(int i) {
        if (i < 1 )
            return;
        if (i * 2 < index && arr[i] < arr[i * 2]) {
            //swap
            int temp = arr[i];
            arr[i] = arr[i * 2];
            arr[i * 2] = temp;

        }

        if (i * 2 + 1 < index && arr[i] < arr[i * 2 + 1]) {
            //swap
            int temp = arr[i];
            arr[i] = arr[i * 2 + 1];
            arr[i * 2 + 1] = temp;
        }

        maxHeapify(i / 2);
    }


    //return the max element in priority queue
    int max() throws Exception {
        if (index > 0) {
            return arr[1];
        }
        throw new Exception("Empty");
    }

    //finds and remove max from priority queue
    int extractMax() throws Exception {
        if (index > 0) {
            //swap, remove last element
            int temp = arr[1];
            arr[1] = arr[--index];
            maxHeapify(1);

            return temp;
        }

        throw new Exception("Empty");
    }

}
