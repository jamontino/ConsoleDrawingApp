package com.jam.app.action;

import com.jam.app.Painter;
import com.jam.app.action.Action;

public abstract class AbstractPainterAction implements Action {
    protected final Painter painter;

    public AbstractPainterAction(Painter painter) {
        this.painter = painter;
    }
}
