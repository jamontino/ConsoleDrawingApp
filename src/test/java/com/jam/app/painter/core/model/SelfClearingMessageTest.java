package com.jam.app.painter.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelfClearingMessageTest {

    private static final String ARBITRARY_MESSAGE = "arbitrary message";
    private SelfClearingMessage testSubject;

    @Before
    public void setUp() {
        testSubject = new SelfClearingMessage();
    }

    @Test
    public void getMessage_WhenNoMessageSet() {
        assertEquals("",testSubject.getMessage());
    }

    @Test
    public void getMessage_WhenMessageViewedTwice_ThenSecondGetReturnsEmptyString() {
        testSubject.setMessage(ARBITRARY_MESSAGE);
        assertEquals(ARBITRARY_MESSAGE,testSubject.getMessage());
        assertEquals("",testSubject.getMessage());
    }
}