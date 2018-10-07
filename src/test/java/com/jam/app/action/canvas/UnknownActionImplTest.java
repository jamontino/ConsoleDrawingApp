package com.jam.app.action.canvas;

import com.google.common.collect.Lists;
import com.jam.app.Painter;
import com.jam.app.action.painter.CreateCanvasActionImpl;
import com.jam.app.exception.ActionException;
import com.jam.app.testutil.FakePainter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
        try {
            testSubject.perform();
            fail("Expected exception not thrown");
        } catch (ActionException e) {
            assertEquals("Unknown input [a, b, c].", e.getMessage());
        }
    }

}