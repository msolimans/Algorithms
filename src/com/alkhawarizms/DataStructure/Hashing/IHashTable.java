package com.alkhawarizms.DataStructure.Hashing;

/**
 * Created by msoliman on 2/14/17.
 */
public interface IHashTable<K,V> {
    boolean add(K key, V value);
    V get(K key);
    void remove(K key);

    K[] keys();
    V[] values();

    boolean isEmpty();
    int size();
    float loadFactor();
}
