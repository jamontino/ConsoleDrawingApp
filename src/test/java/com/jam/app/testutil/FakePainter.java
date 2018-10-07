package com.jam.app.testutil;

import com.jam.app.Painter;
import com.jam.app.model.Canvas;

public class FakePainter implements Painter {
    private Canvas canvas;
    private String message;

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

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;

    }
}
