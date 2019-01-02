package com.leetcode.test;

import com.leetcode.e_657_JudgeRouteCircle;
import org.junit.Assert;
import org.junit.Test;

public class e_657_JudgeRouteCircleTest {
    @Test
    public void judgeCircle() {
        //add more test cases here
        Assert.assertTrue(new e_657_JudgeRouteCircle().judgeCircle("UD"));
        Assert.assertFalse(new e_657_JudgeRouteCircle().judgeCircle("UU"));
        Assert.assertFalse(new e_657_JudgeRouteCircle().judgeCircle("LL"));
        Assert.assertTrue(new e_657_JudgeRouteCircle().judgeCircle("URDL"));


    }
}
