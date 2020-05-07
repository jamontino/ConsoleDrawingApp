package com.jam.app.painter.console;

import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.model.Canvas;

public class FakePainter implements Painter {
    private Canvas canvas;
    private String message = "";

    @Override
    public void paint() {

    }

    @Override
    public void stopPainting() {

    }

    @Override
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Canvas getCanvas() {
        return canvas;
    }
}
