package com.alkhawarizms.DataStructure.Arrays;

/**
 * Created by msoliman on 1/21/17.
 */

//Sometimes named List
public class Vector<E> extends ArrayBase<E> {
    //based on arrays
    //int[] store = new int[10];
    int top = -1;

    void insertAtRank(E elem, int indx){

        if(top++ > store.length - 1){
            store = expand();
        }

        if(indx < top && indx != -1){
            //shifting
            rshift(indx);
            store[indx] = elem;
        }
        else
            store[top] = elem;
    }

    boolean replaceAtRank(E elem, int indx){
        if(indx > top)
            return false;


        store[indx] = elem;
        return true;

    }
    void insert(E elem){
        insertAtRank(elem, -1);
    }


    E get(int indx){
        if(indx <= store.length - 1)
            return store[indx];

        return null;

    }

    E removeAtRank(int indx){
        top--;

        E i = store[indx];


        if(indx < store.length - 1)
            rshift(indx);



        return i;
    }

}
