package com.jam.app.command;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    private CommandFactory testSubject;

    @Before
    public void setUp() {
        testSubject = new CommandFactory();
    }

    @Test
    public void convert_WhenCreateCanvas() {
        Command command = testSubject.getCommand(Lists.newArrayList("C", "20", "20"));
        assertEquals(CommandType.CREATE_CANVAS, command.getType());
        assertEquals(3, command.getInputs().size());
    }

    @Test
    public void convert_WhenDrawStraightLine() {
        Command command = testSubject.getCommand(Lists.newArrayList("L", "1", "1", "2", "2"));
        assertEquals(CommandType.DRAW_STRAIGHT_LINE, command.getType());
        assertEquals(5, command.getInputs().size());
    }

    @Test
    public void convert_WhenDrawRectangle() {
        Command command = testSubject.getCommand(Lists.newArrayList("R", "1", "1", "2", "2"));
        assertEquals(CommandType.DRAW_RECTANGLE, command.getType());
        assertEquals(5, command.getInputs().size());
    }

    @Test
    public void convert_WhenBucketFill() {
        Command command = testSubject.getCommand(Lists.newArrayList("B", "1", "2", "o"));
        assertEquals(CommandType.BUCKET_FILL, command.getType());
        assertEquals(4, command.getInputs().size());
    }

    @Test
    public void convert_WhenQuit() {
        Command command = testSubject.getCommand(Lists.newArrayList("Q"));
        assertEquals(CommandType.QUIT, command.getType());
        assertEquals(1, command.getInputs().size());
    }

    @Test
    public void convert_WhenUnknown() {
        Command command = testSubject.getCommand(Lists.newArrayList("UNKNOWN", "COMMAND", "1", "2", "3"));
        assertEquals(CommandType.UNKNOWN, command.getType());
        assertEquals(5, command.getInputs().size());
    }
}