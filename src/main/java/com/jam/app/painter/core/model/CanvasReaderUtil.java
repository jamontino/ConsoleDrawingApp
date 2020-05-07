package com.jam.app.painter.core.model;

import com.google.common.collect.Lists;

import java.util.List;

public class CanvasReaderUtil {
    public static String getCanvasAsString(Canvas canvas) {
        String output = "";

        if (canvas != null){
            for (int y = 0; y < canvas.getCanvasHeight(); y++) {
                for (int x = 0; x < canvas.getCanvasWidth(); x++) {
                    output = output.concat(canvas.getCanvasSurface()[x][y]);
                }
                output = output.concat("\n");
            }
        }

        return output;
    }

    public static List<String> getCanvasAsStringArray(Canvas canvas) {
        List<String> output = Lists.newArrayList();

        if (canvas != null){
            for (int y = 0; y < canvas.getCanvasHeight(); y++) {
                String currentRow = "";
                for (int x = 0; x < canvas.getCanvasWidth(); x++) {
                    currentRow = currentRow.concat(canvas.getCanvasSurface()[x][y]);
                }
                output.add(currentRow);
            }
        }

        return output;
    }
}
