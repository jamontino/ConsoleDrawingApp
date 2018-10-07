package com.jam.app.action.canvas;

import com.jam.app.Painter;
import com.jam.app.action.AbstractCanvasAction;
import com.jam.app.action.util.DrawLineUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawRectangleActionImpl extends AbstractCanvasAction {
    private final Point pointA;
    private final Point pointB;

    public DrawRectangleActionImpl(Painter painter, Point pointA, Point pointB) {
        super(painter);
        this.pointA = pointA;
        this.pointB = pointB;
    }

    @Override
    public void draw() {
        String[][] updatedCanvas = this.canvas.getCanvasSurface();

        List<Point> rectanglePoints = new ArrayList<>();
        rectanglePoints.addAll(getRectangleTopLine());
        rectanglePoints.addAll(getRectangleBottomLine());
        rectanglePoints.addAll(getRectangleLeftLine());
        rectanglePoints.addAll(getRectangleRightLine());

        for (Point point : rectanglePoints) {
            updatedCanvas[(int) point.getX()][(int) point.getY()] = BRUSH;
        }

        canvas.setCanvasSurface(updatedCanvas);
    }

    private List<Point> getRectangleTopLine() {
        return DrawLineUtil.getLinePoints(pointA, getUpperRightCornerPoint());
    }

    private Point getUpperRightCornerPoint() {
        return new Point((int) pointB.getX(), (int) pointA.getY());
    }

    private List<Point> getRectangleBottomLine() {
        return DrawLineUtil.getLinePoints(getLowerLeftCornerPoint(), pointB);
    }

    private Point getLowerLeftCornerPoint() {
        return new Point((int) pointA.getX(), (int) pointB.getY());
    }

    private List<Point> getRectangleLeftLine() {
        return DrawLineUtil.getLinePoints(pointA, getLowerLeftCornerPoint());
    }

    private List<Point> getRectangleRightLine() {
        return DrawLineUtil.getLinePoints(getUpperRightCornerPoint(), pointB);
    }


}
