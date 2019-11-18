package com.alkhawarizms.DataStructure.Graphs;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class GNode {
    public int Id;
    LinkedList<GNode> adjacent = new LinkedList<>();

    public GNode(int id) {
        this.Id = id;
    }

}

public class AdjacencyListGraph {
    //Adjacency List

    private Map<Integer, GNode> vertices;

    public AdjacencyListGraph() {
        vertices = new HashMap<>();
    }


    public boolean addVertex(int i) {
        if (vertices.get(i) != null)
            return false;

        vertices.put(i, new GNode(i));
        return true;
    }

    public GNode getNode(int i) {
        return vertices.get(i);
    }

    public void addEdge(int sourceId, int destId) {
        GNode source = getNode(sourceId);
        GNode dest = getNode(destId);
        if (source.adjacent == null)
            source.adjacent = new LinkedList<>();
        source.adjacent.add(dest);

    }

    public void addEdges(int[][] map) {

        for (int[] item : map) {
            addEdge(item[0], item[1]);
        }
    }


    public boolean hasPath(int sourceId, int desId) {
        Set<Integer> visited = new HashSet<>();
        GNode source = getNode(sourceId);
        GNode des = getNode(desId);

        return hasPath(source, des, visited);
    }

    private boolean hasPath(GNode source, GNode dest, Set<Integer> visited) {
        if (visited.contains(source.Id))
            return false;
        visited.add(source.Id);
        if (source == dest)
            return true;

        for (GNode child : source.adjacent) {
            if (hasPath(child, dest, visited))
                return true;
        }

        return false;
    }

    public boolean hasPathBFSRecursive(int sourceId, int destinationId) {
        LinkedList<GNode> nextToVisit = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        GNode source = getNode(sourceId);
        GNode dest = getNode(destinationId);

        nextToVisit.add(source);


        return hasPathBFSRecursive(dest, visited, nextToVisit);
    }

    public boolean hasPathBFS(int sourceId, int destinationId) {
        LinkedList<GNode> nextToVisit = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        GNode source = getNode(sourceId);
        GNode dest = getNode(destinationId);
        nextToVisit.add(source);

        while (!nextToVisit.isEmpty()) {
            GNode current = nextToVisit.pollFirst();

            if (current == dest) {
                return true;
            }

            if (visited.contains(current.Id))
                continue;

            visited.add(current.Id);

            for (GNode child : current.adjacent)
                nextToVisit.add(child);

        }

        return false;

    }

    public boolean hasPathBFSRecursive(GNode dest, Set<Integer> visited, LinkedList<GNode> nextToVisit) {
        if (nextToVisit.isEmpty())
            return false;

        GNode next = nextToVisit.pollFirst();


        System.out.println(next.Id);

        if (visited.contains(next.Id))
            return false;

        visited.add(next.Id);

        if (next == dest)
            return true;


        for (GNode child : next.adjacent) {
            if (!visited.contains(child.Id))
                nextToVisit.add(child);

        }

        return hasPathBFSRecursive(dest, visited, nextToVisit);

    }

    @Test
    public void TestHasPathBFS() {
        AdjacencyListGraph graph = new AdjacencyListGraph();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdges(new int[][]{
                {0, 2},
                {2, 0},
                {0, 1},
                {1, 3}
        });

        Assert.assertTrue(graph.hasPathBFS(0, 3));
        Assert.assertTrue(graph.hasPathBFS(2, 3));
        Assert.assertFalse(graph.hasPathBFS(1, 2));

        ///////

        Assert.assertTrue(graph.hasPathBFSRecursive(0, 3));
        Assert.assertTrue(graph.hasPathBFSRecursive(2, 3));
        Assert.assertFalse(graph.hasPathBFSRecursive(1, 2));

    }





    @Test
    public void TestHasPath() {
        AdjacencyListGraph graph = new AdjacencyListGraph();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdges(new int[][]{
                {0, 2},
                {2, 0},
                {0, 1},
                {1, 3}
        });

        Assert.assertTrue(graph.hasPath(0, 3));
//        Assert.assertTrue(graph.hasPath(2, 3));
//        Assert.assertFalse(graph.hasPath(1, 2));

    }
}
