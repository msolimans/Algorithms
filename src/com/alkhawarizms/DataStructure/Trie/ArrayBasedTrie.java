package com.alkhawarizms.DataStructure.Trie;

import org.junit.Assert;
import org.junit.Test;

public class ArrayBasedTrie {

    ArrayBasedTrieNode root = null;

    public ArrayBasedTrie() {
        //instantiate root with TrieNode
        root = new ArrayBasedTrieNode();
    }

    //addVal add a new character to root, specific node and specifies if this is an end of a word
    ArrayBasedTrieNode addVal(ArrayBasedTrieNode node, char ch, boolean end) {
        int index = ch - 'a';

        //if passed node is nil, assign it to root
        if (node == null)
            node = root;

        //if node's val is null, instantiate it with 26 arr
        if (node.vals == null) {
            node.vals = new ArrayBasedTrieNode[26];
        }

        //if node's val at index [char] is nil, instantiate it
        //Only instantiate when it is nil
        if (node.vals[index] == null) {
            node.vals[index] = new ArrayBasedTrieNode();
        }

        //if this is the end of word, mark it
        if (end)
            node.vals[index].endOfWord = true;

        return node.vals[index];

    }

    //based on preorder traversal
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        toString(root, s);
        return s.toString();
    }

    void toString(ArrayBasedTrieNode node, StringBuilder s) {
        //base case
        if (node == null || node.vals == null)
            return;

        for (int i = 0; i < node.vals.length; i++) {
            if (node.vals[i] != null) {
                //visit node
                s.append((String.valueOf((char) (i + 'a'))));
                //traverse to children
                toString(node.vals[i], s);
            }
        }

    }

    @Test
    public void TestAddVal() {
        ArrayBasedTrie t = new ArrayBasedTrie();

        ArrayBasedTrieNode c = t.root;
        c = t.addVal(c, 'a', false);
        c = t.addVal(c, 'b', false);
        c = t.addVal(c, 'c', false);
        t.addVal(c, 'd', true);


        ArrayBasedTrieNode c1 = t.root;
        c1 = t.addVal(c1, 'f', false);
        c1 = t.addVal(c1, 'a', false);
        c1 = t.addVal(c1, 'w', false);
        t.addVal(c1, 'z', true);

        ArrayBasedTrieNode c2 = t.root;
        c2 = t.addVal(c2, 'a', false);
        c2 = t.addVal(c2, 'z', false);
        t.addVal(c2, 'z', false);

        System.out.println(t.toString());
        Assert.assertEquals("abcdzzfawz", t.toString());

    }
}


