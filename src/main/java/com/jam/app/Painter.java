package com.jam.app;

import com.jam.app.model.Canvas;

public interface Painter {
    void paint();

    void stopPainting();

    void setCanvas(Canvas canvas);

    Canvas getCanvas();

    String getMessage();

    void setMessage(String message);
}
