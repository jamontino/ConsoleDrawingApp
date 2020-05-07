package com.jam.app.painter.core.action.canvas;

import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.action.painter.CreateCanvasActionImpl;
import com.jam.app.painter.core.model.Canvas;
import com.jam.app.painter.core.model.CanvasReaderUtil;
import com.jam.app.painter.console.FakePainter;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class DrawRectangleActionImplTest {

    private DrawRectangleActionImpl testSubject;
    private Painter painter;

    @Before
    public void setUp() {
        painter = new FakePainter();
        CreateCanvasActionImpl createCanvas = new CreateCanvasActionImpl(painter, 11, 11);
        createCanvas.perform();
    }

    @Test
    public void perform() {
        testSubject = new DrawRectangleActionImpl(painter, new Point(2, 2), new Point(8, 8));
        testSubject.perform();
        testSubject = new DrawRectangleActionImpl(painter, new Point(4, 4), new Point(10, 10));
        testSubject.perform();
        testSubject = new DrawRectangleActionImpl(painter, new Point(6, 6), new Point(6, 6));
        testSubject.perform();
        testSubject = new DrawRectangleActionImpl(painter, new Point(9, 1), new Point(10, 3));
        testSubject.perform();
        testSubject = new DrawRectangleActionImpl(painter, new Point(1, 9), new Point(3, 10));
        testSubject.perform();

        String expected =
            "-------------\n" +
            "|        xx |\n" +
            "| xxxxxxxxx |\n" +
            "| x     xxx |\n" +
            "| x xxxxxxx |\n" +
            "| x x   x x |\n" +
            "| x x x x x |\n" +
            "| x x   x x |\n" +
            "| xxxxxxx x |\n" +
            "|xxxx     x |\n" +
            "|xxxxxxxxxx |\n" +
            "|           |\n" +
            "-------------\n";
        assertEquals(expected, CanvasReaderUtil.getCanvasAsString(getCanvas()));
    }

    private Canvas getCanvas() {
        return painter.getCanvas();
    }

}