package com.leetcode.test;
import com.leetcode.e_760_FindAnagramMappings;
import org.junit.Assert;
import org.junit.Test;


public class e_760_FindAnagramMappingsTest {


    @Test
    public void  anagramMappingsTest0() {
        Assert.assertArrayEquals(new int[]{1, 4, 3, 2, 0},
                new e_760_FindAnagramMappings().anagramMappings0(new int[]{12, 28, 46, 32, 50},new int[]{50, 12, 32, 46, 28}));
    }


    @Test
    public void  anagramMappingsTest1() {
        Assert.assertArrayEquals(new int[]{1, 4, 3, 2, 0},
                new e_760_FindAnagramMappings().anagramMappings1(new int[]{12, 28, 46, 32, 50},new int[]{50, 12, 32, 46, 28}));
    }


}
