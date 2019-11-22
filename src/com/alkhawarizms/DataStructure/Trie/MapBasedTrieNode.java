package com.alkhawarizms.DataStructure.Trie;

import java.util.HashMap;
import java.util.Map;

public class MapBasedTrieNode {
    Map<Character, MapBasedTrieNode> vals;
    boolean endOfWord;

    public MapBasedTrieNode(){
        vals = new HashMap<>();
        endOfWord = false;
    }
}
