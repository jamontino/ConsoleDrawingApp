package com.jam.app.painter.core;

import com.jam.app.painter.core.model.Canvas;

public interface Painter {
    void paint();

    void stopPainting();

    void setCanvas(Canvas canvas);

    Canvas getCanvas();
}
