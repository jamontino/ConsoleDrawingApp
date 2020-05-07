package com.jam.app.painter.core.screen;

import com.jam.app.painter.console.ConsolePainter;
import com.jam.app.painter.console.ConsoleScreen;
import com.jam.app.painter.core.Painter;
import com.jam.app.painter.console.FakePainter;
import com.jam.app.painter.core.action.ActionFactory;
import com.jam.app.painter.core.command.CommandFactory;
import com.jam.app.painter.core.input.InputScanner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleScreenTest {
    private Painter painter;
    private ConsoleScreen testSubject;

    @Before
    public void setUp() {
        painter = new ConsolePainter(new InputScanner(), new ConsoleScreen(), new CommandFactory(), new ActionFactory());
        testSubject = new ConsoleScreen();
        testSubject.setPainter(painter);
    }

    @Test
    public void getDisplayText() {
        String actual = testSubject.getScreenContent();
        String expected = "enter command: \n";
        assertEquals(expected, actual);
    }
}