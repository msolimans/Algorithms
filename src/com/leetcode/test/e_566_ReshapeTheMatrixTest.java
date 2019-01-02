package com.leetcode.test;

import com.leetcode.e_566_ReshapeTheMatrix;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by msoliman on 1/29/18.
 */
public class e_566_ReshapeTheMatrixTest {

    @Test
    public void matrixReshape(){

        //////////////
        //Test 1
        int[][] result = new e_566_ReshapeTheMatrix().matrixReshape(new int[][]{
                {1,2},
                {3,4}
        }, 1, 4);



        Assert.assertArrayEquals(result[0], new int[]{1,2,3,4});

        //////////////
        //Test 2
        result = new e_566_ReshapeTheMatrix().matrixReshape(new int[][]{
                {1,2},
                {3,4}
        }, 4, 1);

        Assert.assertArrayEquals(result[0], new int[]{1});
        Assert.assertArrayEquals(result[1], new int[]{2});
        Assert.assertArrayEquals(result[2], new int[]{3});
        Assert.assertArrayEquals(result[3], new int[]{4});


        /////////////
        //Test 3
        result = new e_566_ReshapeTheMatrix().matrixReshape(new int[][]{
                {1,2},
                {3,4}
        }, 4, 3);

        Assert.assertArrayEquals(result[0], new int[]{1,2});
        Assert.assertArrayEquals(result[1], new int[]{3,4});




    }
}
