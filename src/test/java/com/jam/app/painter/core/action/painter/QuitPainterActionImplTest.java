package com.jam.app.painter.core.action.painter;

import com.jam.app.painter.core.AbstractPainter;
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
    public AbstractPainter painter;

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