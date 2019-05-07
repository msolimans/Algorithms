package com.ocw.c6006.lect1;

import org.junit.Assert;
import org.junit.Test;

//Find Peak Element in a 2D array, where arr[i,j] is a peak when
// arr[i,j] > arr[i,j-1]
// arr[i,j] > arr[i,j+1]
// arr[i,j] > arr[i-1,j]
// arr[i,j] > arr[i+1,j]
//Link: https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/lecture-1-algorithmic-thinking-peak-finding/
public class FindPeakIn2DArray {
    public static void main(String[] args) {
        System.out.println(GreedyAscentAlgorithm(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    static int GreedyAscentAlgorithm(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int midi = rows / 2;
        int midj = cols / 2;
        return GreeAscentAlgorithm(arr, midi, midj);
    }


    static int GreeAscentAlgorithm(int[][] arr, int midi, int midj) {


        boolean pass = true;

        if (midi - 1 >= 0 && arr[midi - 1][midj] > arr[midi][midj])
            pass = false;
        if (midi + 1 <= arr.length - 1 && arr[midi + 1][midj] > arr[midi][midj])
            pass = false;
        if (midj - 1 >= 0 && arr[midi][midj - 1] > arr[midi][midj])
            pass = false;
        if (midj + 1 <= arr[0].length - 1&& arr[midi][midj + 1] > arr[midi][midj])
            pass = false;

        if (pass)
            return arr[midi][midj];

        //not pass, check max around

        int max = arr[midi][midj];
        int nmidj = midj;
        int nmidi = midi;

        if (midj - 1 >= 0 && arr[midi][midj - 1] > max) {
            nmidj = midj - 1;
            max = arr[midi][midj - 1];
        }

        if (midj + 1 <= arr.length - 1 && arr[midi][midj + 1] > max) {
            nmidj = midj + 1;
            max = arr[midi][midj + 1];
        }

        if (midi - 1 >= 0 && arr[midi - 1][midj] > max) {
            nmidi = midi - 1;
            nmidj = midj;
            max = arr[midi - 1][midj];
        }

        if (midi + 1 <= arr.length - 1 && arr[midi + 1][midj] > max) {
            nmidi = midi + 1;
            nmidj = midj;
        }

        return GreeAscentAlgorithm(arr, nmidi, nmidj);
    }

    @Test
    public void TestGreedyAscentedAlgorithm(){
        Assert.assertEquals(9, GreedyAscentAlgorithm(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Assert.assertEquals(20, GreedyAscentAlgorithm(new int[][]{{0, 0, 10, 15}, {14, 13, 12, 0}, {15, 0, 11, 17}, {17, 18, 19, 20}}));
    }

}
