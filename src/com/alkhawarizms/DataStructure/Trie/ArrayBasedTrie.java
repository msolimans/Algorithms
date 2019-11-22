package com.alkhawarizms.DataStructure.Trie;

import org.junit.Assert;
import org.junit.Test;

public class ArrayBasedTrie {

    ArrayBasedTrieNode root = null;

    public ArrayBasedTrie() {
        //instantiate root with TrieNode
        root = new ArrayBasedTrieNode();
    }

    public void insert(String word) {
        ArrayBasedTrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = addVal(current, word.charAt(i), i == word.length() - 1);
        }

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

    boolean hasPrefix(String p) {

        if (p.length() == 0)
            return true;

        if (root == null || root.vals == null || root.vals.length == 0)
            return false;

        ArrayBasedTrieNode current = root;

        for (char c : p.toCharArray()) {
            if (current == null || current.vals == null || current.vals.length == 0)
                return false;

            int i = c - 'a';
            if (current.vals[i] == null)
                return false;

            current = current.vals[i];
        }

        return true;
    }

    boolean hasWord(String p) {

        if (p.length() == 0)
            return true;

        if (root == null || root.vals == null || root.vals.length == 0)
            return false;

        ArrayBasedTrieNode current = root;

        for (int i = 0; i < p.length(); i++) {

            if (current == null || current.vals == null || current.vals.length == 0)
                return false;

            int indx = p.charAt(i) - 'a';
            if (current.vals[indx] == null)
                return false;

            if (i == p.length() - 1 && !current.vals[indx].endOfWord)
                return false;

            current = current.vals[indx];
        }

        return true;
    }

//    void delWord(String s) {
//        delWord(s, root);
//    }
//
//    ArrayBasedTrieNode delWord(String s, ArrayBasedTrieNode parent) {
//
//        if (s == null || s.length() == 0)
//            return null;
//
//
//        ArrayBasedTrieNode node = delWord(s.substring(1),  );
//
//
//
//    }


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

    @Test
    public void TestHasPrefix() {
        ArrayBasedTrie t = new ArrayBasedTrie();
        ArrayBasedTrieNode n = t.root;

        ArrayBasedTrieNode a = t.addVal(n, 'a', false);
        ArrayBasedTrieNode f = t.addVal(n, 'f', false);
        ArrayBasedTrieNode b = t.addVal(n, 'b', false);

        a = t.addVal(a, 'z', false);
        a = t.addVal(a, 'f', true);

        b = t.addVal(b, 'a', false);
        b = t.addVal(b, 'c', false);
        b = t.addVal(b, 'z', true);

        f = t.addVal(f, 'q', false);
        f = t.addVal(f, 'z', true);


        //a
        Assert.assertTrue(t.hasPrefix("a"));
        Assert.assertTrue(t.hasPrefix("azf"));
        Assert.assertFalse(t.hasPrefix("azfd"));
        Assert.assertTrue(t.hasWord("azf"));
        Assert.assertFalse(t.hasWord("az"));

        Assert.assertTrue(t.hasWord("azf"));
        Assert.assertFalse(t.hasWord("az"));


        //b
        Assert.assertFalse(t.hasPrefix("bds"));
        Assert.assertTrue(t.hasPrefix("bac"));

        Assert.assertFalse(t.hasWord("bac"));
        Assert.assertTrue(t.hasPrefix("bacz"));

        //f
        Assert.assertFalse(t.hasPrefix("fa"));
        Assert.assertTrue(t.hasPrefix("fqz"));

        Assert.assertTrue(t.hasWord("fqz"));
        Assert.assertFalse(t.hasWord("fa"));


        //o doesn't exist
        Assert.assertFalse(t.hasPrefix("o"));
        Assert.assertFalse(t.hasPrefix("os"));
    }

    @Test
    public void TestInsert() {
        ArrayBasedTrie t = new ArrayBasedTrie();
        t.insert("angela");
        t.insert("nick");
        t.insert("muhammad");
        Assert.assertEquals("angelamuhammadnick", t.toString());
    }
}


