package com.jam.app.painter.core.action.canvas;

import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.action.painter.CreateCanvasActionImpl;
import com.jam.app.painter.core.model.Canvas;
import com.jam.app.painter.core.model.CanvasReaderUtil;
import com.jam.app.painter.console.FakePainter;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class BucketFillActionImplTest {

    private Painter painter;

    @Test
    public void draw() {
        painter = new FakePainter();
        CreateCanvasActionImpl createCanvas = new CreateCanvasActionImpl(painter, 10, 10);
        createCanvas.perform();
        DrawRectangleActionImpl drawRectangle = new DrawRectangleActionImpl(painter, new Point(2, 2), new Point(9, 9));
        drawRectangle.perform();
        drawRectangle = new DrawRectangleActionImpl(painter, new Point(5, 5), new Point(6, 6));
        drawRectangle.perform();

        BucketFillActionImpl testSubject = new BucketFillActionImpl(painter, new Point(1, 1), ".");
        testSubject.draw();
        testSubject = new BucketFillActionImpl(painter, new Point(5, 6), "O");
        testSubject.draw();
        testSubject = new BucketFillActionImpl(painter, new Point(7, 9), "A");
        testSubject.draw();

        String expected =
                "------------\n" +
                "|..........|\n" +
                "|.AAAAAAAA.|\n" +
                "|.A      A.|\n" +
                "|.A      A.|\n" +
                "|.A  OO  A.|\n" +
                "|.A  OO  A.|\n" +
                "|.A      A.|\n" +
                "|.A      A.|\n" +
                "|.AAAAAAAA.|\n" +
                "|..........|\n" +
                "------------\n";
        assertEquals(expected, CanvasReaderUtil.getCanvasAsString(getCanvas()));
    }

    private Canvas getCanvas() {
        return painter.getCanvas();
    }
}