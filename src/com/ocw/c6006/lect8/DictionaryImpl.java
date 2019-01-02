package com.ocw.c6006.lect8;

import java.util.Random;

public class DictionaryImpl {


    public static void main(String[] args){

    }

    //size of arr initialized to be one
    private int[] arr;

    private int m;

    DictionaryImpl(){
        arr = new int[8];
        m = new Random().nextInt();
    }


    //pre-hashing function should eleminate or decrease the space hog that maps the universe to an integer value
    //By default if we did not implement this function Java will be use the memory address location where the key is already stored into memory
    //hashCode should be consistent and also it should not be changed
    //If we changed the implementation of the hashCode we have to rebuild the dictionary again as the translation from key-to-value is changed so we have to make sure it is returning correctly where the item is stored
    int simpleHash(int key) {
        //default implementation uses memory address locations to represent keys
        //return super.hashCode();

        return key % m;
    }

    int multiplicationHash(int key){
         return  1;

    }

    int get(int key){


        return  0;

    }

    void insert(int key){

    }

    void delete(int key){

    }
}
