package com.leetcode;

//e_933_NumberofRecentCalls 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Write a class RecentCounter to count recent requests.
//
//It has only one method: ping(int t), where t represents some time in milliseconds.
//
//Return the number of pings that have been made from 3000 milliseconds ago until now.
//
//Any ping with time in [t - 3000, t] will count, including the current ping.
//
//It is guaranteed that every call to ping uses a strictly larger value of t than before.
//
//
//
//Example 1:
//
//Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
//Output: [null,1,2,3,3]
//
//
//Note:
//
//Each test case will have at most 10000 calls to ping.
//Each test case will call ping with strictly increasing values of t.
//Each call to ping will have 1 <= t <= 10^9.
//
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/number-of-recent-calls/
//******************************************************************************************************************

public class e_933_NumberofRecentCalls {


    public static void main(String[] args) {
        int t = (int) System.currentTimeMillis() + 3000;
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(t));
        System.out.println(counter.ping(t));
        System.out.println(counter.ping(t));
    }

    @Test
    public void TestPing() {
        int t = (int) System.currentTimeMillis() + 3000;
        RecentCounter counter = new RecentCounter();
        Assert.assertEquals(1, counter.ping(t));
        Assert.assertEquals(2, counter.ping(t));
        Assert.assertEquals(3, counter.ping(t));
    }

}


class RecentCounter {

    public RecentCounter() {

    }

    Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        //add current time to queue
        queue.add(t);
        //remove all time stamps that are not within range
        //in other words that occurred below/prev the range [t - 3000 to t]
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        //return queue's size that represent how many calls that were made within t-3000 to t
        return queue.size();
    }


}