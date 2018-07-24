package com.leetcode.test;

import com.leetcode.e_728_SelfDividingNumbers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by msoliman on 1/16/18.
 */
public class e_728_SelfDividingNumbersTest {

    @Test
    public void selfDividingNumbers(){
        //add your test acses here
        Assert.assertArrayEquals(new Integer []{  1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22},
                new e_728_SelfDividingNumbers().selfDividingNumbers(1,22).toArray(new Integer[0])
        );
    }
}
