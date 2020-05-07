package com.jam.app.painter.core.action;

import com.jam.app.painter.core.Painter;

public abstract class AbstractPainterAction implements Action {
    protected final Painter painter;

    public AbstractPainterAction(Painter painter) {
        this.painter = painter;
    }
}
