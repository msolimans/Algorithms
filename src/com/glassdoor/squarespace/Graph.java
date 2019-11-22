package com.glassdoor.squarespace;

//Deep clone graph
//Company: SquareSpace

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class Vertex {
    String label;
    LinkedList<Vertex> adjacent;

    public Vertex(String l) {
        label = l;
    }
}

public class Graph {
    Map<String, Vertex> map;

    public Graph() {
        map = new HashMap<>();
    }

    Vertex getNode(String label) {
        return map.get(label);
    }

    Vertex addVertex(String label) {
        Vertex v = new Vertex(label);
        map.putIfAbsent(label, v);
        return v;
    }

    void addEdge(String sourceId, String destId) {

        Vertex source = getNode(sourceId);
        if (source == null) {
            source = addVertex(sourceId);
        }

        Vertex dest = getNode(destId);
        if (dest == null) {
            dest = addVertex(destId);
        }

        if (source.adjacent == null)
            source.adjacent = new LinkedList<>();


        source.adjacent.add(dest);

    }

    //for simplifying unit test cases
    @Override
    public String toString() {
        if (map == null || map.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();

        Set<String> visited = new HashSet<>();

        for (Map.Entry<String, Vertex> m : map.entrySet()) {
            dfs(sb, m.getKey(), m.getValue(), visited);
        }

        return sb.toString();
    }

    void dfs(StringBuilder sb, String l, Vertex v, Set<String> visited) {
        if (visited.contains(l))
            return;

        if (v == null)
            return;

        visited.add(l);


        sb.append(l);

        if (v.adjacent == null)
            return;

        for (Vertex child : v.adjacent) {
            dfs(sb, child.label, child, visited);
        }
    }


    public Graph clone() {
        Set<String> visited = new HashSet<>();
        Graph res = new Graph();

        for (Map.Entry<String, Vertex> srcEntry : map.entrySet()) {

            if (visited.contains(srcEntry.getKey()))
                continue;

            visited.add(srcEntry.getKey());

            res.addVertex(srcEntry.getKey());

            if (srcEntry.getValue() != null && srcEntry.getValue().adjacent != null) {
                for (Vertex v : srcEntry.getValue().adjacent) {
                    res.addEdge(srcEntry.getKey(), v.label);
                }
            }

        }

        return res;
    }


    @Test
    public void TestToString() {
        Graph g = new Graph();
        g.addVertex("a");
        g.addVertex("d");
        g.addEdge("a", "b");
        g.addEdge("a", "d");
        g.addEdge("a", "f");
        g.addEdge("f", "z");
        g.addEdge("f", "e");

        g.addVertex("w");
        g.addVertex("x");
        g.addEdge("w", "x");

        Assert.assertEquals("abdfzewx", g.toString());
    }


    @Test
    public void TestClone() {
        Graph g = new Graph();
        Graph res = g.clone();

        Assert.assertNotNull(res);
        Assert.assertNotSame(g, res);
        Assert.assertFalse(g.equals(res));
        Assert.assertEquals(g.toString(), res.toString());
    }

}



