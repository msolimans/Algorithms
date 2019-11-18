package com.alkhawarizms.DataStructure.Heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinHeap {

    int capacity = 10;
    int size = 0;

    int[] items = new int[capacity];

    int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    boolean hasLeftChild(int index) {
        return index * 2 + 1 < size;
    }

    int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    boolean hasRightChild(int index) {
        return index * 2 + 2 < size;
    }

    int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    boolean hasParent(int index) {
        int parent = getParentIndex(index);
        if (parent < 0)
            return false;
        return true;
    }

    int getParent(int index) {
        return items[getParentIndex(index)];
    }

    void swap(int index, int index2) {
        int temp = items[index];
        items[index] = items[index2];
        items[index2] = temp;
    }

    void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }


    int peek() {
        if (size == 0)
            return -1;
        return items[0];
    }

    int poll() {
        int temp = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return temp;
    }

    void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerIndex = getLeftChildIndex(index);
            if (rightChild(index) < leftChild(index)) {
                smallerIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerIndex])
                break;

            swap(index, smallerIndex);
            index = smallerIndex;
        }

    }

    void add(int val) {
        ensureCapacity();
        items[size++] = val;
        heapifyUp();
    }

    void heapifyUp() {
        int index = size - 1;//last elem
        while (hasParent(index) && getParent(index) > items[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    @Test
    public void TestHeapOps() {
        MinHeap heap = new MinHeap();
        heap.add(10);
        heap.add(2);
        heap.add(1);
        Assert.assertEquals(1, heap.peek());
        Assert.assertEquals(1, heap.poll());
        Assert.assertEquals(2, heap.size);
        Assert.assertEquals(2, heap.poll());
        heap.add(-1);
        heap.add(20);
        Assert.assertEquals(-1, heap.poll());

    }
}