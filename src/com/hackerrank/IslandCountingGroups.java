package com.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msoliman on 3/18/18.
 * Find groups of adjacent cells in a 2-d array determining how many groups of each specified sizes exist
 *
 * As part of input you will be provided with 2-d array where each cell has a value of either 0 or 1. cells are considered to be in the same group if they
 * both have a value of 1 and they are adjacent (an adjacent cell is directly to the left, ot the right, up or down, diagonal cells are not considered adjacent).
 * To define it strictly any 2 cells (x1, y1) and (x2, y2) fall into the same group if |x1 - x2| + |y1 - y2| = 1 and both cells have the value of 1
 *
 * Groups size of a group is the number of cells in that group
 *
 * Complete countGroups function, it has 2 params
 *
 * 1. An n X n two dimensional array of integers, m, where value of each elem m[ij] = is binary 0 or 1
 * 2. An array of q integers, t, where the value of each elem t[k] where 0 < k < q is a group size for which you must find the number of groups in m
 *
 * Your function should return an array of q integers, which we will call ret. Each element ret[i] in ret should be the number of groups in m which have a group size
 * equal to the corresponding value ti in the input array t
 *
 *  {1, 0, 1, 1, 0},
 {0, 1, 0, 0, 1},
 {1, 0, 1, 1, 0},
 {1, 0, 1, 1, 0},
 {0, 1, 0, 0, 1}
 }, new int[]{1, 2, 3, 4, 5})));

 should return

 [5, 2, 0, 1, 0]

 *
 */
public class IslandCountingGroups {

    public static  void main(String[] args){


        System.out.print(Arrays.toString(new IslandCountingGroups().countGroups(new int[][]{
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1}
        }, new int[]{1, 2, 3, 4, 5})));

    }

    int[] countGroups(int[][] m , int[] t){


        Map<Integer, Integer> ret = new HashMap<>();

        int rows = m.length;
        int cols = m[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(m[i][j] == 1){
                    int size = getSize(m, i, j);
                    ret.put(size, ret.getOrDefault(size,0) + 1);
                }

            }
        }

        for(int i=0;i<t.length;i++){
            t[i] = ret.getOrDefault(t[i],0);
        }

        return t;
    }

    int getSize(int[][] grid, int i, int j) {

        if (i < 0 || j < 0  || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0 )
            return 0;

        //reset its value here
        grid[i][j] = 0;


        int sum = 1
                + getSize(grid, i + 1, j)
                + getSize(grid, i, j+1)
                + getSize(grid, i,j-1)
                + getSize(grid, i-1, j);

        return sum;
    }




}
