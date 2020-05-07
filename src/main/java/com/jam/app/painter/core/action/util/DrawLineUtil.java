package com.jam.app.painter.core.action.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawLineUtil {
    public static List<Point> getLinePoints(Point pointA, Point pointB) {
        List<Point> points = new ArrayList<>();
        int x1 = (int) pointA.getX();
        int y1 = (int) pointA.getY();
        int x2 = (int) pointB.getX();
        int y2 = (int) pointB.getY();
        int dx = x2 - x1;
        int dy = y2 - y1;

        if (isVertical(dx)) {
            if (dy < 0){
                getPointsOnVerticalLine(points, x1, y2, y1);
            } else{
                getPointsOnVerticalLine(points, x1, y1, y2);
            }
        } else if (dx < 0) {
            getPointsOnHorizontalLine(y1, points, dx, dy, x2, x1);
        } else {
            getPointsOnHorizontalLine(y1, points, dx, dy, x1, x2);
        }

        return points;
    }

    private static boolean isVertical(int dx) {
        return dx == 0;
    }

    private static void getPointsOnHorizontalLine(int y1, List<Point> points, int dx, int dy, int x1, int x2) {
        for (int x = x1; x <= x2; x++) {
            int y = y1 + dy * (x - x1) / dx;
            Point point = new Point(x, y);
            points.add(point);
        }
    }

    private static void getPointsOnVerticalLine(List<Point> points, int x, int y1, int y2) {
        for (int y = y1; y <= y2; y++) {
            Point point = new Point(x, y);
            points.add(point);
        }
    }
}
