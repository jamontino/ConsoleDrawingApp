package com.jam.app.painter.core.action.painter;

import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.exception.ActionException;
import com.jam.app.painter.core.model.CanvasReaderUtil;
import com.jam.app.painter.console.FakePainter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CreateCanvasActionImplTest {

    private Painter painter;

    private CreateCanvasActionImpl testSubject;

    @Before
    public void setUp() {
        painter = new FakePainter();
    }

    @Test
    public void perform() {
        testSubject = getTestSubject(20,4);
        testSubject.perform();

        String expected =
                "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n";
        assertEquals(expected, CanvasReaderUtil.getCanvasAsString(painter.getCanvas()));
    }

    @Test
    public void perform_WhenHeightAndWidthAre1() {
        testSubject = getTestSubject(1,1);
        testSubject.perform();

        String expected =
                "---\n" +
                "| |\n" +
                "---\n";
        assertEquals(expected, CanvasReaderUtil.getCanvasAsString(painter.getCanvas()));
    }

    @Test
    public void initialize_WhenZeroWidthAndWidth_ThenThrowError() {
        assertValidateThrowError(0,1, "Canvas cannot be created with ZERO Width/Height.");
        assertValidateThrowError(1,0, "Canvas cannot be created with ZERO Width/Height.");
    }

    private void assertValidateThrowError(int width, int height, String expected) {
        testSubject = getTestSubject(width, height);
        try {
            testSubject.validate();
            failAssert();
        } catch (ActionException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    private CreateCanvasActionImpl getTestSubject(int width, int height) {
        return new CreateCanvasActionImpl(painter, width,height);
    }

    private void failAssert() {
        fail("Expected exception not thrown");
    }


}