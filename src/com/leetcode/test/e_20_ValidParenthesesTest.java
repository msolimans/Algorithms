package com.leetcode.test;

import com.leetcode.e_20_ValidParentheses;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by msoliman on 1/18/18.
 */
public class e_20_ValidParenthesesTest {
    @Test
    public void isValid(){

        e_20_ValidParentheses solution = new e_20_ValidParentheses();

        Assert.assertTrue(solution.isValid("()[]{}"));
        Assert.assertFalse(solution.isValid("()[]{"));
        Assert.assertFalse(solution.isValid("(]"));
        Assert.assertFalse(solution.isValid("([)]"));
        Assert.assertTrue(solution.isValid("()"));

    }
}

