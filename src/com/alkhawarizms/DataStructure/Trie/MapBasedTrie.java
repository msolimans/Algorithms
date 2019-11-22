package com.alkhawarizms.DataStructure.Trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class MapBasedTrie {
    MapBasedTrieNode root;

    public MapBasedTrie() {
        root = new MapBasedTrieNode();
    }

    //recursive
    void insert(String word) {
        insert(word, root);
    }

    void insert(String word, MapBasedTrieNode node) {
        if (word == null || word.length() == 0)
            return;

        if (!node.vals.containsKey(word.charAt(0)))
            node.vals.put(word.charAt(0), new MapBasedTrieNode());

        if (word.length() == 1)
            node.endOfWord = true;

        insert(word.substring(1), node.vals.get(word.charAt(0)));
    }

    //recursive
    boolean hasPrefix(String p) {
        boolean t = hasPrefix(p, root);
        return t;

    }

    boolean hasPrefix(String p, MapBasedTrieNode node) {
        if (p == null || p.length() == 0)
            return true;
        if (node == null || node.vals == null)
            return false;

        boolean s = node.vals.containsKey(p.charAt(0)) && hasPrefix(p.substring(1), node.vals.get(p.charAt(0)));
        return s;

    }


    boolean hasWord(String word) {
        return hasWord(word, root);
    }

    boolean hasWord(String word, MapBasedTrieNode node) {
        if (word == null || word.length() == 0)
            return true;
        if (node == null || node.vals == null)
            return false;

        return ((word.length() == 1 && node.endOfWord) || word.length() > 1) &&
                node.vals.containsKey(word.charAt(0)) &&
                hasWord(word.substring(1), node.vals.get(word.charAt(0)));
    }

    //recursive
    @Override
    public String toString() {
        if (root == null)
            return "";
        return toString(root);
    }

    public String toString(MapBasedTrieNode node) {
        if (node == null || node.vals == null || node.vals.size() == 0)
            return "";
        StringBuilder s = new StringBuilder();
        for (Map.Entry<Character, MapBasedTrieNode> e : node.vals.entrySet()) {
            s.append(String.valueOf(e.getKey()) + toString(e.getValue()));
        }
        return s.toString();
    }

    @Test
    public void TestInsert() {
        MapBasedTrie t = new MapBasedTrie();
        t.insert("hello");
        System.out.println(t.toString());

    }

    @Test
    public void TestHasPrefix() {
        MapBasedTrie t = new MapBasedTrie();
        t.insert("ald");
        t.insert("alkhawarizms");
        t.insert("alkhawarizmy");
        Assert.assertTrue(t.hasPrefix("al"));
        Assert.assertTrue(t.hasPrefix("alkh"));
        Assert.assertTrue(t.hasPrefix("alkhawarizmy"));
        Assert.assertTrue(t.hasPrefix("alkhawarizm"));
        Assert.assertFalse(t.hasPrefix("muhammad"));
        Assert.assertFalse(t.hasPrefix("ag"));
        Assert.assertTrue(t.hasPrefix("ald"));
        Assert.assertTrue(t.hasWord("ald"));
        Assert.assertTrue(t.hasWord("alkhawarizms"));
        Assert.assertFalse(t.hasWord("al"));
    }

}
