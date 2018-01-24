package com.leetcode;

public class e_766_ToeplitzMatrix {


    boolean isValidDiagonal(int[][] matrix, int rows, int cols, int i, int j){

        int current = matrix[i][j];
        int ci=i;
        int cj = j;

        while(++ci <= rows-1  && ++cj <= cols-1 ){
            current ^= matrix[ci][cj];
        }

        return current == 0 || current == matrix[i][j];
    }

    boolean isToeplitzMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i =0;

        //cols
        for(int j=0;j<cols;j++){
          if(!isValidDiagonal(matrix, rows, cols, i, j))
              return false;
        }

        int j = 0;

        for(i = 1;i<rows;i++){
            if(!isValidDiagonal(matrix, rows, cols, i, j))
                return false;
        }

        return  true;
    }

    public static void main(String[] args){


       System.out.println(new e_766_ToeplitzMatrix().isToeplitzMatrix(new int[][]{
                {1,2,5},
                {7,1,2},
                {3,7,1}
        }));

    }


}
