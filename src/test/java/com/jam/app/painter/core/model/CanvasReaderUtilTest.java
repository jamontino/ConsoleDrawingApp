package com.jam.app.painter.core.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CanvasReaderUtilTest {


    private Canvas canvas;

    @Before
    public void setUp() throws Exception {
        canvas = getTestCanvas();
    }

    @Test
    public void name() {
        String actual = CanvasReaderUtil.getCanvasAsString(canvas);
        assertEquals(
                "0000000000"+"\n"+
                        "1111111111"+"\n"+
                        "2222222222"+"\n"+
                        "3333333333"+"\n"+
                        "4444444444"+"\n"+
                        "5555555555"+"\n"+
                        "6666666666"+"\n"+
                        "7777777777"+"\n"+
                        "8888888888"+"\n"+
                        "9999999999"+"\n",
                actual);
    }

    @Test
    public void getCanvasAsStringArray() {
        List<String> canvasAsStringArray = CanvasReaderUtil.getCanvasAsStringArray(canvas);
        for (int x = 0; x<10;x++) {
            assertEquals(getExpectedOutput(x), canvasAsStringArray.get(x));
        }
    }

    private Canvas getTestCanvas() {
        Canvas canvas = new Canvas();
        String[][] newCanvas = new String[10][10];
        for (int y = 0; y<10;y++) {
            for (int x = 0; x<10;x++) {
                newCanvas[y][x]= Integer.toString(x);
            }
        }

        canvas.setCanvasSurface(newCanvas);
        return canvas;
    }

    private String getExpectedOutput(int x) {
        String s = Integer.toString(x);
        return s+s+s+s+s+s+s+s+s+s;
    }
}