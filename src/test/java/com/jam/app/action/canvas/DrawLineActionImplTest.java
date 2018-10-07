package com.jam.app.action.canvas;

import com.jam.app.Painter;
import com.jam.app.action.painter.CreateCanvasActionImpl;
import com.jam.app.exception.ActionException;
import com.jam.app.model.Canvas;
import com.jam.app.model.CanvasReaderUtil;
import com.jam.app.testutil.FakePainter;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DrawLineActionImplTest {
    private DrawLineActionImpl testSubject;
    private Painter painter;


    @Before
    public void setUp() {
        painter = new FakePainter();
        CreateCanvasActionImpl createCanvas = new CreateCanvasActionImpl(painter, 11, 11);
        createCanvas.perform();
    }

    @Test
    public void perform() {
        testSubject = new DrawLineActionImpl(painter, new Point(4, 5), new Point(8, 5));
        testSubject.perform();
        testSubject = new DrawLineActionImpl(painter, new Point(9, 7), new Point(3, 7));
        testSubject.perform();
        testSubject = new DrawLineActionImpl(painter, new Point(5, 3), new Point(5, 9));
        testSubject.perform();
        testSubject = new DrawLineActionImpl(painter, new Point(7, 10), new Point(7, 3));
        testSubject.perform();
        testSubject = new DrawLineActionImpl(painter, new Point(6, 1), new Point(6, 1));
        testSubject.perform();

        String expected =
                "-------------\n" +
                "|     x     |\n" +
                "|           |\n" +
                "|    x x    |\n" +
                "|    x x    |\n" +
                "|   xxxxx   |\n" +
                "|    x x    |\n" +
                "|  xxxxxxx  |\n" +
                "|    x x    |\n" +
                "|    x x    |\n" +
                "|      x    |\n" +
                "|           |\n" +
                "-------------\n";
        assertEquals(expected, CanvasReaderUtil.getCanvasAsString(getCanvas()));
    }

    @Test
    public void validate_WhenDiagonalLine_ThenThrowError() {
        assertValidate(new Point(1,1),new Point(3,3),"Draw Line cannot do diagonal lines.");
        assertValidate(new Point(3,3),new Point(1,1),"Draw Line cannot do diagonal lines.");
    }

    private void assertValidate(Point pointA, Point pointB, String expectedMessage) {
        try{
            testSubject = new DrawLineActionImpl(painter, pointA, pointB);
            testSubject.validate();
            failAssert();
        }catch (ActionException e){
            assertEquals(expectedMessage,e.getMessage());
        }
    }

    private void failAssert() {
        fail("Expected exception not thrown");
    }

    private Canvas getCanvas() {
        return painter.getCanvas();
    }
}