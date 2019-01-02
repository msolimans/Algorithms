package com.leetcode;

//657. Judge Route Circle
//Show Topic Tags

/**
 * Searching, Maths
 */

/*Description*/
//******************************************************************************************************************
//Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
//
//        The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
//
//        Example 1:
//        Input: "UD"
//        Output: true
//        Example 2:
//        Input: "LL"
//        Output: false
//******************************************************************************************************************
//Companies: N/A
//******************************************************************************************************************
//Link: https://leetcode.com/problems/judge-route-circle/description/
//******************************************************************************************************************

public class e_657_JudgeRouteCircle {

    //O(n)
    public boolean judgeCircle(String moves) {
        //simple, keep track of x and y coordinates, moving up add 1 and moving down subtract 1, same in y coordinate moving right adds 1 and left subtracts 1
        int x = 0;
        int y = 0;

        for(int i =0;i<moves.length();i++){
            if(moves.charAt(i) == 'U')
                x++;
            else if(moves.charAt(i) == 'D')
                x--;
            else if (moves.charAt(i) == 'R')
                y++;
            else if(moves.charAt(i) == 'L')
                y--;
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args){

        System.out.println(new e_657_JudgeRouteCircle().judgeCircle("UD"));
        System.out.println(new e_657_JudgeRouteCircle().judgeCircle("UU"));
        System.out.println(new e_657_JudgeRouteCircle().judgeCircle("LL"));
        System.out.println(new e_657_JudgeRouteCircle().judgeCircle("URDL"));

    }
}
