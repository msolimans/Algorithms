package com.alkhawarizms.DataStructure.Hashing;

import com.alkhawarizms.DataStructure.Interfaces.IHashable;
import com.alkhawarizms.DataStructure.Lists.LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by msoliman on 1/31/17.
 */
public class Hashtable<K extends IHashable,V> implements IHashTable<K,V>, Iterator<K> {

    //the most important things in hashtable is hashCode() function
    float maxLoadFactor;
    int numOfElements, size;

    //array of linkedlist of hashelements
    LinkedList<HashElement<K,V>>[] harray;

    int position = 0;
    HashElement<K,V> current = null;


    @Override
    public boolean hasNext() {
        return position < size && harray[harray.length - 1].getLast() != current;
    }

    //traverse through the keys
    @Override
    public K next() {
        if(harray[position].getLast() == current)
            position++;

        if(harray[position].hasNext()){
            current = harray[position].next();
        }

        return  current.key;
    }


    class HashElement<K extends IHashable, V> implements Comparable<HashElement<K,V>>{
        K key;
        V value;

        public HashElement(K key, V value){
            this.key = key;
            this.value = value;
        }


        @Override
        public int compareTo(HashElement<K, V> o) {
            return ((Comparable<K>)this.key).compareTo(o.key);
        }
    }



    public Hashtable(int size){

        this.size = size;
        numOfElements = 0;
        maxLoadFactor = 0.75f;

        harray = (LinkedList<HashElement<K,V>>[]) new LinkedList[size];

        for(int i=0;i<size;i++)
            harray[i] = new LinkedList();
    }


//    So why don't expats think to get out of this shit !!!
//    I have no idea why we usually think its the only country that has a lot of money in the world ..
//    I still do wonder "does it worth to have money without dignity or humanity !!! or may be we shouldn't think we are humans anymore to
//    live that gorgeous and splendid lifestyle"


    @Override
    public boolean add(K key, V value) {
        //hashCode
        //make it positive
        //mod tableSize
        //add
        int hashValue = key.hashCode() & 0x7FFFFFFF % size;

        if(loadFactor() > maxLoadFactor)
            resize(size*2);
        harray[hashValue].add(new HashElement(key, value));
        numOfElements++;
        return true;
    }

    private void resize(int newSize) {

        LinkedList<HashElement<K,V>>[] narray = new LinkedList[newSize];
        for(int i=0;i<newSize;i++)
            narray[i] = (LinkedList<HashElement<K,V>>) new LinkedList();

        //rehashing
        for (Hashtable<K, V> it = this; it.hasNext(); ) {
            K key = it.next();
            V value = get(key);
            HashElement<K,V> elem = new HashElement(key,value);

            int hashValue = key.hashCode() &0x7FFFFFFF % newSize;

            narray[hashValue].add(elem);
        }

        harray = narray;
        size = newSize;

    }

    @Override
    public V get(K key) {
        int hashValue = key.hashCode() & 0x7FFFFFFF % size;
        LinkedList<HashElement<K, V>> it = harray[hashValue];

        while(it.hasNext()) {
            HashElement<K, V> elem = it.next();
            if(((Comparable<K>)elem.key).compareTo(key) > 0) return elem.value;
        }

        return null;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public K[] keys() {
        List<K> keys = new ArrayList<K>();
        while(this.hasNext())
            keys.add(this.next());

        return (K[]) keys.toArray();
    }


    @Override
    public V[] values() {
        List<V> values = new ArrayList();
        while(this.hasNext())
            values.add(get(this.next()));

        return (V[]) values.toArray();

    }

    @Override
    public boolean isEmpty() {
        return numOfElements == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public float loadFactor() {
        return (float)numOfElements/size;
    }
}
