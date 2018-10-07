package com.jam.app.action.converter;

import com.jam.app.Painter;
import com.jam.app.exception.ActionException;

import java.awt.*;

public class PointConverter {

    public static Point convert(Painter painter, int xCoor, int yCoor) {
        if (isZero(xCoor) || isZero(yCoor)){
            throw new ActionException("Coordinates cannot be zero.");
        }

        if (painter.getCanvas() != null){
            if (xCoor > painter.getCanvas().getCanvasSurfaceWidth()){
                throw new ActionException("Given X coordinate exceeds canvas width.");
            }

            if (yCoor > painter.getCanvas().getCanvasSurfaceHeight()){
                throw new ActionException("Given Y coordinate exceeds canvas height.");
            }
        }

        return new Point(xCoor, yCoor);
    }

    private static boolean isZero(int value) {
        return 0 == value;
    }
}
