package com.ocw.c6006.lect10;


/***
 * Open Addressing Definition:
 * ------------------------------------------------
 *  In Open Address we don't have chaining at all to solve collisions however we have different methodology to address that problem.
 *  Cheaper in space as it is not using pointers
 *  n is the number of elements, where m is the number of slots in the hash table, always m >= n
 *
 * Linear Probing:
 * ------------------------------------------------
 *  Continuously find an empty slot to insert into new items in case of collisions. Prob for all operations like insert, search, and delete
 *  So, we need to design a function to calc hash and offset location or index in case of collision e.g. hash(item,index) where index = 0,1,2,3,4,5....m
 *  In case we need to insert an item and we found and item already exist there in its target slot to be inserted into, we should go linearly after this slot until we find an empty slot for it.
 *  In case of search, hash the key and find its slot id or index then go and compare if it is the same key, if not continue after this slot until you find your item or an empty slot (NULL) (means item is not there)
 *  In case of delete however we need to mark or flag that item to be deleted (DELETED) instead of assigning a NULL value to it as it will make a problem in probing in case we need to search for an item located after this deleted item
 *  However there's a problem cause you're already reserving DELETED slots which affects on search later as you're continuing probing for flagged items until you find a match or empty slot.
 *  If you have a lot of deletions that might make cluster of flagged items to say for example probing from (42) ...D.D.D.D.D... (57) keep going and try until you reach 57
 *  In case 0.01 < (Load factor) Alpha (n/m) <= 0.99 => in case we have alpha = 0.99, we will see clusters of size log(n) =>  in case of using really a good hashing function.
 *  As alpha grows, probability of probes will also grow.
 *  Extend the table and rehash all keys again (which means getting rid of painful DEL flags too) in case of alpha getting greater than 0.5 or 0.6 at most as it is not based on chaining.
 *  Cost of insert operation => probability of insertion equals (#empty slots / #all slots) => m-n (empty_slots) / m = m/m - n/m = 1 - alpha
 *  If it will take log(n) for searches it will not be constant time any more, Solution => Double Hashing
 *
 * Double Hashing:
 * ------------------------------------------------
 *  where we should have a 2nd hashing function in probing to distribute items instead of linearly trying to find items making probability of collisions getting smaller
 *  h(k,i) = (h1(k) + i h2(k)) mod m  => h2(k) for all k is odd
 *
 * Cryptographic Hashing (FYI, For Your Info Only)
 * ------------------------------------------------
 *  Password Storage: Store password not in plain text but in hashes to avoid even sysadmin not to know anybody's else password.
 *  User type password
 *  System hash it
 *  Store it (hashed) => in case sysadmin open db he will not be able to know users' passwords
 *  Validating password, user type password and system will hash it and validate it with the hashed one in the database.
 *  Cryptographic Hashing is ONE WAY which means you cannot revert it back to its plain or original text => given h(x) really hard to get x back.
 *  Check online and read more about the properties of this hashing function
 *
 *   Linear and Doubly Prob classes having => main operations: insert, search, delete
 *   Supporting functions for object to be hashed correctly: hashCode(), hashCode2() in case of doubly hashing probing only
 *   Driver class for testing
 * */


class LinearProb<V> {


    V[] arr;
    public LinearProb(){
        arr = (V[])new Object[8];
    }

    public void insert(String  key, V value){

    }
    public  V search(String key){
        return arr[0];
    }

    public void delete(String  key){

    }
}

class DoubleProb<V> {

    V[] arr;
    public DoubleProb(){
        arr = (V[])new Object[8];
    }

    public void insert(String key, V value){

    }
    public  V search(String key){
        return arr[0];
    }

    public void delete(String  key){

    }
}


public class OpenAddress {

    public static void main(String[] args){
        LinearProb<String> linearProb = new LinearProb<>();
        linearProb.insert("key", "test");


        DoubleProb<String> doubleProb = new DoubleProb<>();
        doubleProb.insert("key", "test");
    }

}
