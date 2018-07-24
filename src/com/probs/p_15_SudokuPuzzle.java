package com.probs;

/**
 * Created by msoliman on 5/3/17.
 */
public class p_15_SudokuPuzzle {
    public static void main(String[] args) {
        System.out.println(checkRepetition(new int[]{1, 2, 1, 4}));
        int[][] a = new int[][]{{1, 2, 3}, {4, 2, 6}, {7, 8, 9}};
        int[][] b = new int[][]{{1, 2, 3}, {4, 2, 6}, {7, 8, 9}};


        System.out.println(Run(a,3,3));
        System.out.println(Run(b,3,3));

    }



    //isValid ,, returns false in case there is repeition in row or col otherwise returns true
    static boolean Run(int[][] arr, int rows, int cols) {

        //any repition in row .. validates each row
        for (int i = 0; i < rows; i++) {
            int result = 0;

            for (int j = 0; j < cols; j++) {
                if ((result & (1 << arr[i][j])) > 1)
                    return false;
                result |= (1 << arr[i][j]);
            }

        }

        //any repition in cols .. validates each col
        for (int j = 0; j < cols; j++) {

            int result;
            result = 0;
            for (int i = 0; i < rows; i++) {
                if ((result & (1 << arr[i][j])) > 1)
                    return false;

                result |= (1 << arr[i][j]);
            }

        }

        return true;


    }

    //numbers from 1 .. 9
    static boolean checkRepetition(int[] arr) {
        int result = 0;

        for (int k :
                arr) {

            if ((result & (1 << k)) > 0)
                return true;
            result |= (1 << k);
        }

        return false;

    }
}
