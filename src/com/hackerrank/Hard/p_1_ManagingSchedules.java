package com.hackerrank.Hard;


//Rohit recently opened up a new website, which gives information about various flight timings and allows user to book flights online. He now wants to implement a new idea, where along with all the flight timings, he gives a list of the most efficient routes.
//
//Note that a user doesn’t always have to take a direct flight, he can switch flights in between. As long as the route is an optimal route, the information has to be displayed. Also, we only need information about travelling routes that start and end on the same day.
//
//A route will be labelled as optimal, if for a flight departing from city X at time p, and arriving at city Y at time q, there is no other flight that begins in X not sooner than p and no flight landing at Y not later than q
//
//Given that we need to find the set of optimal routes between city 1 and city n, write a program to help Rohit implement this new feature
//
//Input Format
//
//The first line contains the number of integers n (2 <= n <= 2X10^5). The following lines contain n schedules for cities 1,2,3,.....n respectively
//
//Each schedule of a particular city starts with a single integer m, which denotes the number of flights departing from the city on that particular date
//
//Each of the next m lines contain 3 inputs, p, q and Y (p is departing time from city X, q is arrival time, and Y is destination city). The time is given in the format hh:mm
//
//Positions in the schedule are given in increasing order
//
//Output Format
//
//The first line of the output contains an integer t, the number of optimal routes for the given set of data
//
//The next t lines contain the departure time from city 1 and arrival time at city n via an optimal routes. These have to be in increasing order of departure times. The times have to be outputted in the format hh:mm
//
//Sample Input
//
//4
//
//2
//
//08:00 16:00 4
//
//09:00 12:00 2
//
//2
//
//12:10 13:00 3
//
//13:00 15:00 4
//
//1
//
//13:15 14:30 4
//
//1
//
//16:00 18:00 3
//
//Sample Output
//
//2
//
//08:00 16:00
//
//09:00 14:30
//
//Explanation
//
//We can see that if a user wants to start travelling at 08:00, there is only one route available for him/her, the direct from from city 1 to city n
//
//If the user wants to travel at a later time, the only available option is the flight at 09:00, in which canse the optimal route
//Type: Contest

import org.junit.Test;

import java.util.*;


class ScheduleGraph {
    Map<Integer, Vertex> map = new HashMap<>();

    void addVertex(int v) {
        if (map.get(v) == null)
            map.put(v, new Vertex(v));
    }


    Vertex getVertex(int i) {
        return map.get(i);
    }

    boolean addEdge(int sourceId, int destId, String start, String end) {
        Vertex source = getVertex(sourceId);
        Vertex dest = getVertex(destId);

        if (dest == null) {
            dest = new Vertex(destId);
            map.put(destId, dest);
        }

        if (source == null)
            return false;

        source.adjacent.add(new Edge(dest, start, end));

        return true;
    }

}

class Vertex {
    int id;

    LinkedList<Edge> adjacent;

    public Vertex(int i) {
        this.id = i;
        adjacent = new LinkedList<>();
    }
}

class Interval {
    String startTime;
    String endTime;

    Interval(String start, String end) {
        this.startTime = start;
        this.endTime = end;
    }
}


class Edge {


    Interval interval;
    Vertex to;

    Edge(Vertex to, String start, String end) {
        this.to = to;
        this.interval = new Interval(start, end);

    }
}

public class p_1_ManagingSchedules {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        ScheduleGraph graph = new ScheduleGraph();

        for (int i = 1; i <= T; i++) {
            graph.addVertex(i);
            int N = scan.nextInt();
            while (--N >= 0) {
                String from = scan.next();
                String to = scan.next();
                Integer tov = scan.nextInt();
                graph.addEdge(i, tov, from, to);
            }
        }

        List<Interval> result = solve(graph, 1, T);

        System.out.println(result.size());
        for (Interval item : result) {
            System.out.println(item.startTime + " " + item.endTime);
        }
    }

    static List<Interval> solve(ScheduleGraph graph, int sourceId, int destId) {

        List<Interval> result = new ArrayList<>();


        Vertex source = graph.getVertex(sourceId);
        Vertex dest = graph.getVertex(destId);

        for (Edge child : source.adjacent) {
            Set<Integer> visited = new HashSet<>();

            solve(graph, child.interval.startTime, child.interval.endTime, child.to, dest, result, visited);
        }


        return result;

    }

    static void solve(ScheduleGraph graph, String pathStart, String endPath, Vertex source, Vertex dest, List<Interval> result, Set<Integer> visited) {
        if (visited.contains(source.id) && source != dest)
            return;

        visited.add(source.id);

        //at is the time to compare with


        if (source == dest) {
            result.add(new Interval(pathStart, endPath));
            return;
        }

        for (Edge child : source.adjacent) {
            Date stDt = new Date(2000, 1, 1, Integer.parseInt(endPath.split(":")[0]), Integer.parseInt(endPath.split(":")[1]));
            Date toDt = new Date(2000, 1, 1, Integer.parseInt(child.interval.startTime.split(":")[0]), Integer.parseInt(child.interval.startTime.split(":")[1]));

            long i = new Date(toDt.getTime() - stDt.getTime()).getTime() / 1000 / 60;
            if (i >= 15)
                solve(graph, pathStart, child.interval.endTime, child.to, dest, result, visited);
        }
    }

    @Test
    public void TestSolve() {
//
//        Date atDt = new Date(2000, 1, 1, Integer.parseInt("9:00".split(":")[0]), Integer.parseInt("9:00".split(":")[1]));
//        Date enDt = new Date(2000, 1, 1, Integer.parseInt("10:00".split(":")[0]), Integer.parseInt("10:0".split(":")[1]));
//
//        System.out.println();


        ScheduleGraph graph = new ScheduleGraph();
        graph.addVertex(1);
        graph.addEdge(1, 4, "8:00", "16:00");
        graph.addEdge(1, 2, "9:00", "12:00");
        graph.addEdge(2, 4, "13:00", "15:00");
        graph.addEdge(2, 3, "12:00", "13:00");
        graph.addEdge(3, 4, "13:15", "14:30");
        graph.addEdge(4, 3, "16:00", "18:00");

        List<Interval> result = solve(graph, 1, 4);

        for (Interval i : result)
            System.out.println(i.startTime + "-" + i.endTime);

    }


    @Test
    public void TestTt() {

        ScheduleGraph graph = new ScheduleGraph();
        graph.addVertex(1);
        graph.addEdge(1, 4, "8:00", "16:00");
        graph.addEdge(1, 2, "9:00", "12:00");
        graph.addEdge(2, 3, "12:00", "13:00");
        graph.addEdge(2, 4, "13:00", "15:00");
        graph.addEdge(3, 4, "13:15", "14:30");
        graph.addEdge(4, 3, "16:00", "18:00");

    }


}
