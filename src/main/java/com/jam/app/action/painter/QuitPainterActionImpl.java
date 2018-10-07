package com.jam.app.action.painter;

import com.jam.app.Painter;
import com.jam.app.action.AbstractPainterAction;

public class QuitPainterActionImpl extends AbstractPainterAction {

    public QuitPainterActionImpl(Painter painter) {
        super(painter);
    }

    @Override
    public void perform() {
        painter.stopPainting();
    }
}
