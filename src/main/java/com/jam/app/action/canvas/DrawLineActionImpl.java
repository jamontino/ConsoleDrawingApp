package com.jam.app.action.canvas;

import com.jam.app.Painter;
import com.jam.app.action.AbstractCanvasAction;
import com.jam.app.action.util.DrawLineUtil;
import com.jam.app.exception.ActionException;

import java.awt.*;
import java.util.List;

public class DrawLineActionImpl extends AbstractCanvasAction {

    final Point pointA;
    final Point pointB;


    public DrawLineActionImpl(Painter painter, Point pointA, Point pointB) {
        super(painter);
        this.pointA = pointA;
        this.pointB = pointB;
    }

    @Override
    public void validate() {
        super.validate();

        if (isSloped()){
            throw new ActionException("Draw Line cannot do diagonal lines.");
        }
    }

    @Override
    public void draw() {
        String[][] updatedCanvas = this.canvas.getCanvasSurface();
        List<Point> linePoints = DrawLineUtil.getLinePoints(pointA, pointB);
        for (Point linePoint : linePoints) {

            updatedCanvas[(int) linePoint.getX()][(int) linePoint.getY()] = BRUSH;
        }
        canvas.setCanvasSurface(updatedCanvas);
    }

    private boolean isSloped() {
        return (!(pointA.getX() == pointB.getX() || pointA.getY() == pointB.getY()));
    }


}
