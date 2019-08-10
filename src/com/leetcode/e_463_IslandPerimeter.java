package com.leetcode;

/**
 * Created by msoliman on 5/4/17.
 */
public class e_463_IslandPerimeter {
    public static void main(String[] args) {



        int[][] a = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(run(a));


    }

    static int run(int[][] grid) {

        int r = 0;
        int rows = grid.length;
        int cols = grid[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 0)
                    continue;

                //top
                if(i == 0 )
                    r++;
                else if(grid[i-1][j] == 0)
                    r++;

                //bottom
                if(i == rows - 1)
                    r++;
                else if(grid[i+1][j] == 0)
                    r++;


                //left
                if(j == 0 )
                    r++;
                else if(grid[i][j-1] == 0)
                    r++;

                //right
                if(j == cols - 1)
                    r++;
                else if(grid[i][j+1] == 0)
                    r++;

            }



        }

        return r;

    }
}
