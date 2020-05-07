package com.jam.app.painter.core.screen;

import com.jam.app.painter.core.Painter;

public abstract class AbstractScreen implements Screen{
    Painter painter;

    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }

}
