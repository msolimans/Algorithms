package com.crackbook.ch1;

/**
 * Created by msoliman on 5/12/17.
 */
public class p_1_8_ZeroMatrix {
    public static void main(String[] args) {


        System.out.print(run(new int[][]{{
                1, 0, 0
        }, {
                0, 1, 0
        }, {
                0, 0, 0
        }}));


        System.out.print(run(new int[][]{{
                1, 0, 0, 0
        }, {
                0, 1, 1, 0
        }, {
                0, 0, 0, 0
        }}));

    }

    static boolean run(int[][] arr) {

        if (arr.length == 0)
            return false;

        int i = 0;
        int j = 0;
        int rows = arr.length;
        int cols = arr[0].length;
        boolean isValidRow = false;
        boolean isValidCol = false;

        while (i < rows && j < cols) {

            if (arr[i][j] != 0) {
                if (!isValidRow)
                    i++;

                if (!isValidCol)
                    j++;

            } else {



                for (int r = 0; r < rows; r++) {
                    if (arr[r][j] != 0) {
                        isValidCol = false;
                        break;
                    }
                    isValidCol = true;
                }

                for (int c = 0; c < cols; c++) {
                    if (arr[i][c] != 0) {
                        isValidRow = false;
                        break;
                    }
                    isValidRow = true;

                }

                if (isValidCol && isValidRow)
                    return true;

                if (!isValidCol)
                    j++;
                if (!isValidRow)
                    i++;
            }


        }

        return false;

    }
}
