package com.jam.app.action.painter;

import com.jam.app.ConsolePainter;
import com.jam.app.action.painter.QuitPainterActionImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class QuitPainterActionImplTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private QuitPainterActionImpl testSubject;

    @Mock
    public ConsolePainter painter;

    @Before
    public void setUp() {
        testSubject = new QuitPainterActionImpl(painter);
    }

    @Test
    public void perform() {
        testSubject.perform();
        verify(painter).stopPainting();
        verifyNoMoreInteractions(painter);
    }
}