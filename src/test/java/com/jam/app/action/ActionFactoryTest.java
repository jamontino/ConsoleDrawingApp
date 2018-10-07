package com.jam.app.action;

import com.google.common.collect.Lists;
import com.jam.app.Painter;
import com.jam.app.action.canvas.BucketFillActionImpl;
import com.jam.app.action.canvas.DrawLineActionImpl;
import com.jam.app.action.canvas.DrawRectangleActionImpl;
import com.jam.app.action.canvas.UnknownActionImpl;
import com.jam.app.action.painter.CreateCanvasActionImpl;
import com.jam.app.action.painter.QuitPainterActionImpl;
import com.jam.app.command.Command;
import com.jam.app.command.CommandType;
import com.jam.app.testutil.FakePainter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ActionFactoryTest {

    Painter painter;
    private ActionFactory testSubject;

    @Before
    public void setUp(){
        painter = new FakePainter();
        testSubject = new ActionFactory();
    }

    @Test
    public void getAction_WhenCreateCanvasCommand() {
        Action actual = testSubject.getAction(painter, new Command(CommandType.CREATE_CANVAS, Lists.newArrayList("C", "2", "2")));
        assertTrue(actual instanceof CreateCanvasActionImpl);
    }

    @Test
    public void getAction_WhenDrawLineCommand() {
        Action actual = testSubject.getAction(painter, new Command(CommandType.DRAW_STRAIGHT_LINE, Lists.newArrayList("L", "1", "1","1","1")));
        assertTrue(actual instanceof DrawLineActionImpl);
    }

    @Test
    public void getAction_WhenDrawRectangleCommand() {
        Action actual = testSubject.getAction(painter, new Command(CommandType.DRAW_RECTANGLE, Lists.newArrayList("R", "1", "1","1","1")));
        assertTrue(actual instanceof DrawRectangleActionImpl);
    }

    @Test
    public void getAction_WhenBucketFillCommand() {
        Action actual = testSubject.getAction(painter, new Command(CommandType.BUCKET_FILL, Lists.newArrayList("B", "1", "1","o")));
        assertTrue(actual instanceof BucketFillActionImpl);
    }

    @Test
    public void getAction_WhenQuitCommand() {
        Action actual = testSubject.getAction(painter, new Command(CommandType.QUIT, Lists.newArrayList("Q")));
        assertTrue(actual instanceof QuitPainterActionImpl);
    }

    @Test
    public void getAction_WhenUnknownCommand() {
        Action actual = testSubject.getAction(painter, new Command(CommandType.UNKNOWN, Lists.newArrayList("SOME", "random", "command")));
        assertTrue(actual instanceof UnknownActionImpl);
    }
}