package com.leetcode.test;

import com.leetcode.e_557_ReverseWordsInString3;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by msoliman on 1/16/18.
 */
public class e_557ReverseWordInString3Test {


    @Test
    public void reverseWords(){

        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", new e_557_ReverseWordsInString3().reverseWords("Let's take LeetCode contest"));
    }

    @Test
    public void reverseWord(){

        Assert.assertEquals("s'teL", new e_557_ReverseWordsInString3().reverseWords("Let's"));
        Assert.assertEquals("ekat", new e_557_ReverseWordsInString3().reverseWords("take"));
        Assert.assertEquals("edoCteeL", new e_557_ReverseWordsInString3().reverseWords("LeetCode"));
        Assert.assertEquals("tsetnoc", new e_557_ReverseWordsInString3().reverseWords("contest"));
    }
}
