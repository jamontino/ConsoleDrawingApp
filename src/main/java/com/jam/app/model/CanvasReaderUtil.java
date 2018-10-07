package com.jam.app.model;

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
}
