package com.jam.app.painter.core.action.canvas;

import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.action.AbstractCanvasAction;
import com.jam.app.painter.core.exception.ActionException;

import java.util.List;

public class UnknownActionImpl extends AbstractCanvasAction {

    private final List<String> input;

    public UnknownActionImpl(Painter painter, List<String> input) {
        super(painter);
        this.input = input;
    }

    @Override
    protected void draw() {
        throw new ActionException("Unknown input " + input + ".");
    }
}
