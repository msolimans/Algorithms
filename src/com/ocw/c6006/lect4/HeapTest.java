package com.ocw.c6006.lect4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HeapTest {
    @Test
    public void TestMaxHeapify() throws Exception {
        Heap heap = new Heap(5);
        heap.insert(new int[]{0, 2, 3, 4});
        heap.maxHeapify(3);
        Assert.assertArrayEquals(new int[]{0, 4, 2, 3, 0, 0}, heap.getArr());
        Assert.assertEquals(4, heap.max());
        Assert.assertEquals(4, heap.extractMax());
        Assert.assertEquals(3, heap.extractMax());
        Assert.assertEquals(2, heap.extractMax());
    }

}
