package com.jam.app.painter.json;

import com.jam.app.painter.core.model.CanvasReaderUtil;
import com.jam.app.painter.core.screen.AbstractScreen;

public class VirtualScreen extends AbstractScreen {
    @Override
    public void refreshScreen() {

    }

    @Override
    public String getScreenContent() {
        return CanvasReaderUtil.getCanvasAsString(getPainter().getCanvas());
    }
}
