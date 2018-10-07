package com.jam.app.action.util;

import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DrawLineUtilTest {

    @Test
    public void getSlope_WhenPositiveHorizontalLine() {
        List<Point> actual = DrawLineUtil.getLinePoints(new Point(1, 1), new Point(3, 1));
        assertEquals(new Point(1, 1), actual.get(0));
        assertEquals(new Point(2, 1), actual.get(1));
        assertEquals(new Point(3, 1), actual.get(2));
    }

    @Test
    public void getSlope_WhenPositiveVerticalLine() {
        List<Point> actual = DrawLineUtil.getLinePoints(new Point(1, 1), new Point(1, 3));
        assertEquals(new Point(1, 1), actual.get(0));
        assertEquals(new Point(1, 2), actual.get(1));
        assertEquals(new Point(1, 3), actual.get(2));
    }

    @Test
    public void getSlope_WhenNegativeHorizontalLine() {
        List<Point> actual = DrawLineUtil.getLinePoints(new Point(3, 1), new Point(1, 1));
        assertEquals(new Point(1, 1), actual.get(0));
        assertEquals(new Point(2, 1), actual.get(1));
        assertEquals(new Point(3, 1), actual.get(2));
    }

    @Test
    public void getSlope_WhenNegativeVerticalLine() {
        List<Point> actual = DrawLineUtil.getLinePoints(new Point(1, 3), new Point(1, 1));
        assertEquals(new Point(1, 1), actual.get(0));
        assertEquals(new Point(1, 2), actual.get(1));
        assertEquals(new Point(1, 3), actual.get(2));
    }

    @Test
    public void getSlope_WhenPerfectDiagonalLine() {
        List<Point> actual = DrawLineUtil.getLinePoints(new Point(1, 1), new Point(3, 3));
        assertEquals(new Point(1, 1), actual.get(0));
        assertEquals(new Point(2, 2), actual.get(1));
        assertEquals(new Point(3, 3), actual.get(2));
    }
}