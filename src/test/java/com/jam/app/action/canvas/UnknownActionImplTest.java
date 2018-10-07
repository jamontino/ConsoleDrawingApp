package com.jam.app.action.canvas;

import com.google.common.collect.Lists;
import com.jam.app.Painter;
import com.jam.app.action.canvas.UnknownActionImpl;
import com.jam.app.action.painter.CreateCanvasActionImpl;
import com.jam.app.model.Canvas;
import com.jam.app.testutil.FakePainter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnknownActionImplTest {

    private Painter painter;
    private UnknownActionImpl testSubject;

    @Before
    public void setUp() {
        painter = new FakePainter();
        CreateCanvasActionImpl createCanvas = new CreateCanvasActionImpl(painter, 11, 11);
        createCanvas.perform();
    }

    @Test
    public void perform() {
        testSubject = new UnknownActionImpl(painter, Lists.newArrayList("a", "b", "c"));
        testSubject.perform();
        assertEquals("Unknown input [a, b, c].", painter.getMessage());
    }

}