package com.jam.app.action.canvas;

import com.jam.app.Painter;
import com.jam.app.action.AbstractCanvasAction;
import com.jam.app.exception.ActionException;

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
