package com.leetcode;

//e_999_AvailableCapturesforRook 
//Show Topic Tags

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */

/*Description*/
//******************************************************************************************************************

//On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
//
//The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
//
//Return the number of pawns the rook can capture in one move.
//
//
//
//Example 1:
//
//
//
//Input: [['.','.','.','.','.','.','.','.'],['.','.','.','p','.','.','.','.'],['.','.','.','R','.','.','.','p'],['.','.','.','.','.','.','.','.'],['.','.','.','.','.','.','.','.'],['.','.','.','p','.','.','.','.'],['.','.','.','.','.','.','.','.'],['.','.','.','.','.','.','.','.']]
//Output: 3
//Explanation:
//In this example the rook is able to capture all the pawns.
//Example 2:
//
//
//
//Input: [['.','.','.','.','.','.','.','.'],['.','p','p','p','p','p','.','.'],['.','p','p','B','p','p','.','.'],['.','p','B','R','B','p','.','.'],['.','p','p','B','p','p','.','.'],['.','p','p','p','p','p','.','.'],['.','.','.','.','.','.','.','.'],['.','.','.','.','.','.','.','.']]
//Output: 0
//Explanation:
//Bishops are blocking the rook to capture any pawn.
//Example 3:
//
//
//
//Input: [['.','.','.','.','.','.','.','.'],['.','.','.','p','.','.','.','.'],['.','.','.','p','.','.','.','.'],['p','p','.','R','.','p','B','.'],['.','.','.','.','.','.','.','.'],['.','.','.','B','.','.','.','.'],['.','.','.','p','.','.','.','.'],['.','.','.','.','.','.','.','.']]
//Output: 3
//Explanation:
//The rook can capture the pawns at positions b5, d6 and f5.
//
//
//Note:
//
//board.length == board[i].length == 8
//board[i][j] is either 'R', '.', 'B', or 'p'
//There is exactly one cell with board[i][j] == 'R'
//******************************************************************************************************************
//Companies: Square | 2
//******************************************************************************************************************
//Link: https://leetcode.com/problems/available-captures-for-rook/
//******************************************************************************************************************

public class e_999_AvailableCapturesforRook {


    public static void main(String[] args) {


    }

    public int numRookCaptures(char[][] board) {

        //find the rook first .. which i and j
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    //once found, start counting in all directions
                    return countPawns(board, i, j);
                }

            }
        }


        return 0;

    }



    public int countPawns(char[][] board, int i, int j) {
        //4 different dirs
        int count = 0;
        for (int x = i - 1; x >= 0; x--) {
            if (board[x][j] == 'B')
                break;
            if (board[x][j] == 'p') {
                count++;
                break;
            }
        }

        for (int x = i + 1; x < board.length; x++) {
            if (board[x][j] == 'B')
                break;
            if (board[x][j] == 'p') {
                count++;
                break;
            }
        }

        for (int y = j - 1; y >= 0; y--) {
            if (board[i][y] == 'B')
                break;
            if (board[i][y] == 'p') {
                count++;
                break;
            }
        }

        for (int y = j + 1; y < board[i].length; y++) {
            if (board[i][y] == 'B')
                break;
            if (board[i][y] == 'p') {
                count++;
                break;
            }
        }

        return count;
    }

    @Test
    public void TestnumRookCaptures() {
        Assert.assertEquals(3, numRookCaptures(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}
        }));

        Assert.assertEquals(0, numRookCaptures(new char[][]{

                {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'}, {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}

        }));

        Assert.assertEquals(3, numRookCaptures(new char[][]{

                {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'p', 'p', '.', 'R', '.', 'p', 'B', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'B', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}

        }));


    }

}
