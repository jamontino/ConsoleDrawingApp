package com.jam.app.painter;

import com.google.common.collect.Lists;
import com.jam.app.painter.core.action.ActionFactory;
import com.jam.app.painter.core.command.CommandFactory;
import com.jam.app.painter.json.JSONPainter;
import com.jam.app.painter.json.VirtualScreen;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class JSONPainterTest {

    private JSONPainter testSubject;

    @Before
    public void setUp() {
        testSubject = new JSONPainter(new VirtualScreen(), new CommandFactory(), new ActionFactory());
    }

    @Test
    public void name() {
        paint(Lists.newArrayList("C", "10", "10"));
        paint(Lists.newArrayList("L", "2", "2", "2", "5"));
//        paint(Lists.newArrayList("C", "10", "10"));

    }

    private void paint(ArrayList<String> input) {
        testSubject.setInput(input);
        testSubject.paint();
        String content = testSubject.getContent();
        System.out.println(content);
    }

}