package com.jam.app.painter.core.action.canvas;

import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.action.AbstractCanvasAction;
import com.jam.app.painter.core.model.Canvas;

import java.awt.*;

public class BucketFillActionImpl extends AbstractCanvasAction {

    private final int x;
    private final int y;
    private final String newColor;
    private String oldColor;

    public BucketFillActionImpl(Painter painter, Point point, String newColor) {
        super(painter);
        this.x = (int) point.getX();
        this.y = (int) point.getY();

        this.newColor = newColor;
    }

    @Override
    protected void draw() {
        this.oldColor = canvas.getCanvasSurface()[x][y];
        fill(x, y);
    }

    private void fill(int x, int y) {
        if (oldColor.equals(getColorOn(canvas, x, y))) {
            canvas.getCanvasSurface()[x][y] = newColor;
            fill(x, y - 1); //recurse north
            fill(x + 1, y); //recurse west
            fill(x, y + 1); //recurse south
            fill(x - 1, y); //recurse east
        }
    }

    private String getColorOn(Canvas canvas, int x, int y) {
        return canvas.getCanvasSurface()[x][y];
    }
}
