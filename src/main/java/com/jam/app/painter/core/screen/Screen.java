package com.jam.app.painter.core.screen;

import com.jam.app.painter.core.Painter;

public interface Screen {

    void refreshScreen();

    String getScreenContent();

    void setPainter(Painter painter);
}
