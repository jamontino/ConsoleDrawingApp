package com.jam.app.action;

import com.jam.app.Painter;
import com.jam.app.exception.ActionException;
import com.jam.app.model.Canvas;

public abstract class AbstractCanvasAction extends AbstractPainterAction {

    public static final String BRUSH = "x";
    protected final Canvas canvas;

    protected AbstractCanvasAction(Painter painter) {
        super(painter);
        this.canvas = painter.getCanvas();
    }

    public void perform() {
        validate();
        draw();
    }

    protected void validate() {
        if (canvas == null) {
            throw new ActionException("There is no canvas! Create one first.");
        }
    }

    protected abstract void draw();
}
