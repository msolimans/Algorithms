package com.probs;

//const keys  = [
//        'content.landingpages.podcasts',
//        'content.landingpages.podcasts.android',
//        'content.landingpages.podcasts.android.code',
//        'content.landingpages.podcasts.android.offer',
//        'content.landingpages.music',
//        'content.landingpages.music.jazz',
//        'content.landingpages.music.pop',
//        'content.landingpages.music.metal'
//        ]

/*
Expected Output:
- content
-- landingpages
---- podcasts
------ android
-------- code
-------- offer
---- music
------ jazz
------ pop
------ metal
*/

import java.util.HashMap;
import java.util.Stack;

//tree node with multi nodes as children
class TreeNode {
    String value;
    //map for nodes for better performance - O(1) for get and O(n) for traverse
    HashMap<String, TreeNode> Nodes;

    TreeNode(String v) {
        value = v;
    }
}

//Tree with one root field
class Tree {

    TreeNode root;

    //add values and follow paths all way down to leaf (leaf is a node that doesn;t have children)
    void AddValues(String[] vals) {
        if (root == null) {
            root = new TreeNode(vals[0]);
        }

        AddValues(root, vals,  1);
    }

    //node is the current node in the tree where we can add new strings
    //vals is an array of strings that represent each line
    //i is the current index of vals array
    void AddValues(TreeNode node, String[] vals, int i) {
        //stop in case we exhausted all strings passed in the array
        if (i > vals.length - 1)
            return;

        //3 cases
        //no children of current node => initiate hashmap and add string inside it (key as string and value as TreeNode)
        //there are children but the new string being added doesn't exist in hashmap => add it
        //there are children and the new string being added exists in hashmap => pass through to the next level
        if (node.Nodes == null || node.Nodes.size() == 0) {
            node.Nodes = new HashMap<>();
            TreeNode inserted = new TreeNode(vals[i]);
            node.Nodes.put(vals[i], inserted);
            AddValues(inserted, vals, i + 1);
        } else if (!node.Nodes.containsKey(vals[i])) {
            TreeNode inserted = new TreeNode(vals[i]);
            node.Nodes.put(vals[i], inserted);
            AddValues(inserted, vals, i + 1);
        } else {
            AddValues(node.Nodes.get(vals[i]), vals, i + 1);
        }
    }

}


public class PrintTree {


    Tree tr = null;


    public static void printTree(String[] arr) {
        Tree t = new Tree();


        for (String s :
                arr) {
            String[] ss = s.split("\\.");
            t.AddValues(ss);
        }

        printTree(t.root, 1);


    }

    public static void printTree(TreeNode node, int level) {
        if(node == null)
            return;

        System.out.println(printDashes(level) + node.value);
        if(node.Nodes != null){
            for(String k: node.Nodes.keySet()){
                printTree(node.Nodes.get(k), level + 1);
            }
        }
    }

    static String printDashes(int level) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<level;i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] keys = new String[]{
                "content.landingpages.podcasts",
                "content.landingpages.podcasts.android",
                "content.landingpages.podcasts.android.code",
                "content.landingpages.podcasts.android.offer",
                "content.landingpages.music",
                "content.landingpages.music.jazz",
                "content.landingpages.music.pop",
                "content.landingpages.music.metal"
        };
        printTree(keys);
    }
}
