package com.leetcode;

//e_566_ReshapeTheMatrix
//Show Topic Tags

//import com.leetcode.shared.Matrix;


import java.util.Arrays;

/**
 * Matrix, Math
 */

/*Description*/
//******************************************************************************************************************


//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: 
//******************************************************************************************************************

public class e_566_ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c){
        if(nums == null || nums.length == 0 || r * c > nums.length * nums[0].length)
            return nums;

        int[][] result = new int[r][c];

        int ir = 0;
        int jr = 0;


        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){

                result[ir][jr] = nums[i][j];

                //increasing indices and populate data to results matrix
                if(jr == c - 1){
                    ir++;
                    jr=0;
                }else{
                    jr++;
                }

            }

        }

        return result;

    }





    public static void main(String[] args) {

//
//        int[][] r = new e_566_ReshapeTheMatrix().matrixReshape(new int[][]{
//                {1,2},
//                {3,4}
//        }, 1, 4);
//
//
//        System.out.println(Matrix.toString(r));
//
//        r = new e_566_ReshapeTheMatrix().matrixReshape(new int[][]{
//                {1,2},
//                {3,4}
//        }, 4, 1);
//
//
//        System.out.println(Matrix.toString(r));
//
//        r = new e_566_ReshapeTheMatrix().matrixReshape(new int[][]{
//                {1,2},
//                {3,4}
//        }, 4, 3);
//
//
//        System.out.println(Matrix.toString(r));



    }
}
