package com.jam.app.painter.console;

import com.google.common.collect.Lists;
import com.jam.app.painter.core.AbstractPainter;
import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.action.ActionFactory;
import com.jam.app.painter.core.action.painter.QuitPainterActionImpl;
import com.jam.app.painter.core.command.Command;
import com.jam.app.painter.core.command.CommandFactory;
import com.jam.app.painter.core.command.CommandType;
import com.jam.app.painter.core.input.InputScanner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.*;

public class ConsolePainterTest {
    private static final ArrayList<String> ARBTRARY_INPUT = Lists.newArrayList("Q");
    private static final Command ARBTRARY_COMMAND = new Command(CommandType.QUIT, Collections.<String>emptyList());

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private InputScanner scanner;

    @Mock
    private ConsoleScreen screen;

    @Mock
    private CommandFactory commandFactory;

    @Mock
    private ActionFactory actionFactory;

    private AbstractPainter testSubject;

    @Before
    public void setUp() {
        testSubject = new ConsolePainter(scanner, screen, commandFactory, actionFactory);
    }

    @Test
    public void paint() {
        when(scanner.getInput()).thenReturn(ARBTRARY_INPUT);
        when(commandFactory.getCommand(ARBTRARY_INPUT)).thenReturn(ARBTRARY_COMMAND);
        when(actionFactory.getAction(testSubject, ARBTRARY_COMMAND)).thenReturn(new QuitPainterActionImpl(testSubject));

        testSubject.paint();

        verify(commandFactory, atLeastOnce()).getCommand(anyList());
        verify(actionFactory, atLeastOnce()).getAction(any(Painter.class), any(Command.class));
        verify(scanner, atLeastOnce()).getInput();
        verify(screen, atLeastOnce()).refreshScreen();
    }
}