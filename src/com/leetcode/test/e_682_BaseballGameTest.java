package com.leetcode.test;

import com.leetcode.e_682_BaseballGame;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by msoliman on 1/17/18.
 */
public class e_682_BaseballGameTest {
    @Test
    public void calPoints(){

        Assert.assertEquals(30, new e_682_BaseballGame().calPoints(new String[]{"5","2","C", "D", "+"}));
        Assert.assertEquals(27, new e_682_BaseballGame().calPoints(new String[]{"5","-2", "4", "C", "D", "9", "+", "+"}));
    }
}
