package com.jam.app.painter.core.action.converter;

import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.exception.ActionException;
import com.jam.app.painter.core.model.Canvas;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PointConverterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Painter mockPainter;

    @Mock
    private Canvas mockCanvas;

    @Before
    public void setUp() {
        when(mockPainter.getCanvas()).thenReturn(mockCanvas);
        when(mockCanvas.getCanvasSurfaceHeight()).thenReturn(20);
        when(mockCanvas.getCanvasSurfaceWidth()).thenReturn(20);
    }

    @Test
    public void convert() {
        Point actual = PointConverter.convert(mockPainter, 1, 1);
        assertEquals(new Point(1, 1), actual);
    }

    @Test
    public void convert_WhenXCoordinateExceedsCanvasWidth_ThenThrowError() {
        when(mockCanvas.getCanvasSurfaceHeight()).thenReturn(1);
        when(mockCanvas.getCanvasSurfaceWidth()).thenReturn(1);
        try {
            PointConverter.convert(mockPainter, 2, 1);
            fail("Expected error not thrown");
        } catch (ActionException e) {
            assertEquals("Given X coordinate exceeds canvas width.", e.getMessage());
        }
    }

    @Test
    public void convert_WhenYCoordinateExceedsCanvasHeight_ThenThrowError() {
        when(mockCanvas.getCanvasSurfaceHeight()).thenReturn(1);
        when(mockCanvas.getCanvasSurfaceWidth()).thenReturn(1);
        try {
            PointConverter.convert(mockPainter, 1, 2);
            fail("Expected error not thrown");
        } catch (ActionException e) {
            assertEquals("Given Y coordinate exceeds canvas height.", e.getMessage());
        }
    }

    @Test
    public void convert_WhenXCoordinateIsZero_ThenThrowError() {
        try {
            PointConverter.convert(mockPainter, 0, 1);
            fail("Expected error not thrown");
        } catch (ActionException e) {
            assertEquals("Coordinates cannot be zero.", e.getMessage());
        }
    }

    @Test
    public void convert_WhenYCoordinateIsZero_ThenThrowError() {
        try {
            PointConverter.convert(mockPainter, 1, 0);
            fail("Expected error not thrown");
        } catch (ActionException e) {
            assertEquals("Coordinates cannot be zero.", e.getMessage());
        }
    }

    @Test
    public void convert_WhenPainterHasNotCreateCanvas_ThenProceed() {
        when(mockPainter.getCanvas()).thenReturn(null);

        Point actual = PointConverter.convert(mockPainter, 1, 1);
        assertEquals(new Point(1, 1), actual);
    }

}