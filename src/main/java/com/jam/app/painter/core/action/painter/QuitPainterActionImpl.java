package com.jam.app.painter.core.action.painter;

import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.action.AbstractPainterAction;

public class QuitPainterActionImpl extends AbstractPainterAction {

    public QuitPainterActionImpl(Painter painter) {
        super(painter);
    }

    @Override
    public void perform() {
        painter.stopPainting();
    }
}
