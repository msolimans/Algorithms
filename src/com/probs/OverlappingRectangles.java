package com.probs;

import org.junit.Assert;
import org.junit.Test;

public class OverlappingRectangles {
    public static void main(String[] args) {

    }

    //calculate the area of overlapping rectangle
    //there's possibility of no overlap at all
    //can be in different quadrants
    public int calcOverlappingRectangle(int x1, int y1, int x11, int y11, int x2, int y2, int x22, int y22) {
        int width = calcDimension(x1, x11, x2, x22);

        if (width < 0)
            return -1;

        int height = calcDimension(y1, y11, y2, y22);

        if (height < 0)
            return -1;

        return width * height;
        //  x1          x11
        //  2            5
        //      x2              x22
        //      3               6
        //x2   x22
        // 1    4
        //------
    }

    private int calcDimension(int x1, int x11, int x2, int x22) {
        return Math.min(x11, x22) - Math.max(x1, x2);
    }

    @Test
    public void TestCalcOverlappingRectangles() {
        Assert.assertEquals(6, calcOverlappingRectangle(2, 1, 5, 5, 3, 2, 5, 7));
    }
}
