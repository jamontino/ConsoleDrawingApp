package com.jam.app.painter.core.model;

public class Canvas {

    private String[][] canvasSurface;

    public void setCanvasSurface(String[][] canvasSurface) {
        this.canvasSurface = canvasSurface;
    }

    public String[][] getCanvasSurface() {
        return canvasSurface;
    }

    public int getCanvasWidth() {
        return canvasSurface.length;
    }

    public int getCanvasHeight() {
        return canvasSurface[0].length;
    }

    public int getCanvasSurfaceWidth() {
        return canvasSurface.length - 2;
    }

    public int getCanvasSurfaceHeight() {
        return canvasSurface[0].length - 2;
    }
}
