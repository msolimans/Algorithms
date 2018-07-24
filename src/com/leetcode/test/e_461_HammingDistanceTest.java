package com.leetcode.test;

import com.leetcode.e_461_HammingDistance;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by msoliman on 1/18/18.
 */
public class e_461_HammingDistanceTest {

    //2st solution test
    @Test
    public void hammingDistance(){
        e_461_HammingDistance solution = new e_461_HammingDistance();
        Assert.assertEquals(2,solution.hammingDistance(1,4));
        Assert.assertEquals(1,solution.hammingDistance(2,6));
        Assert.assertEquals(5,solution.hammingDistance(15,16));
    }

    //2nd solution test
    @Test
    public void hammingDistance2(){
        e_461_HammingDistance solution = new e_461_HammingDistance();
        Assert.assertEquals(2,solution.hammingDistance2(1,4));
        Assert.assertEquals(1,solution.hammingDistance2(2,6));
        Assert.assertEquals(5,solution.hammingDistance2(15,16));
    }
}
