package com.jam.app.screen;

import com.jam.app.Painter;
import com.jam.app.testutil.FakePainter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnsiConsoleScreenTest {
    private Painter painter;
    private AnsiConsoleScreen testSubject;

    @Before
    public void setUp() {
        painter = new FakePainter();
        testSubject = new AnsiConsoleScreen();
        testSubject.setPainter(painter);
    }

    @Test
    public void getDisplayText() {
        String actual = testSubject.getDisplayText();
        String expected = "enter something: \n";
        assertEquals(expected, actual);
    }
}