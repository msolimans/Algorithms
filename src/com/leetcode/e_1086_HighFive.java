package com.leetcode;

//e_1086_HighFive 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 */

/*Description*/
//******************************************************************************************************************
//Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
//
//Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
//
//
//
//Example 1:
//100 87 65 91 92
//93 97 77 100 76
//
//Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
//Output: [[1,87],[2,88]]
//Explanation:
//The average of the student with id = 1 is 87.
//The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
//
//
//Note:
//
//1 <= items.length <= 1000
//items[i].length == 2
//The IDs of the students is between 1 to 1000
//The score of the students is between 1 to 100
//For each student, there are at least 5 scores

//******************************************************************************************************************
//Companies: Goldman Sachs, Amazon
//******************************************************************************************************************
//Link: https://leetcode.com/problems/high-five/
//******************************************************************************************************************

public class e_1086_HighFive {


    public static void main(String[] args) {

        int[][] res = new e_1086_HighFive().highFive(new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}});
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }

    }

    //store top 5 scores in priorty queue
    void storeTo5(PriorityQueue<Integer> pq, int score) {
        if (pq.size() < 5) {
            pq.add(score);
            return;
        }

        if (pq.peek() < score) {
            pq.poll();
            pq.add(score);
        }
    }

    //calc average for all vals in priority queue
    int calcAverage(PriorityQueue<Integer> pq) {
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        //why 5, bcs at least we will have 5 items based on the notes section in question
        return sum / 5;
    }

    //
    public int[][] highFive(int[][] items) {

        //loop thru and classify scores by student id and every time re-index to priorty queue the highest scores
        Map<Integer, PriorityQueue<Integer>> students = new HashMap<>();
        for (int[] i : items) {
            PriorityQueue<Integer> pq = students.getOrDefault(i[0], new PriorityQueue<Integer>());
            storeTo5(pq, i[1]);
            students.put(i[0], pq);
        }



        int[][] result = new int[students.keySet().size()][2];
        int i = 0;

        //loop through map and calc average based on the top 5 scores stored/collected in priority queue
        for (Integer k : students.keySet()) {
            result[i++] = new int[]{k, calcAverage(students.get(k))};
        }

        return result;
    }

    @Test
    public void TestHighFive() {
        Assert.assertArrayEquals(new int[][]{{1, 87}, {2, 88}},
                highFive(new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}}));

        Assert.assertArrayEquals(new int[][]{{1, 87}, {2, 88}, {3, 9}},
                highFive(new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}, {3, 9}, {3, 9}, {3, 9}, {3, 9}, {3, 9}}));

    }

}
