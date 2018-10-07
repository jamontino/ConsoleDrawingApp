package com.jam.app.action.painter;

import com.jam.app.Painter;
import com.jam.app.action.AbstractPainterAction;
import com.jam.app.exception.ActionException;
import com.jam.app.model.Canvas;

public class CreateCanvasActionImpl extends AbstractPainterAction{

    private static final int BORDER_ADJUSTMENT = 2;
    private final Canvas canvas;

    private int width;
    private int height;

    public CreateCanvasActionImpl(Painter painter, int width, int height) {
        super(painter);
        canvas = new Canvas();
        this.width = width + BORDER_ADJUSTMENT;
        this.height = height + BORDER_ADJUSTMENT;
    }

    public void perform() {
        try{
            validate();
            canvas.setCanvasSurface(getNewCanvas());
        } catch (ActionException e){
            painter.setMessage(e.getMessage());
        }
        painter.setCanvas(canvas);
    }

    public void validate() {
        if (width - BORDER_ADJUSTMENT == 0 || height - BORDER_ADJUSTMENT == 0) {
            throw new ActionException("Canvas cannot be created with ZERO Width/Height.");
        }
    }

    private String[][] getNewCanvas() {
        String[][] newCanvas = new String[width][height];

        initializeEmptyCanvas(newCanvas);
        setLeftBorder(newCanvas);
        setRightBorder(newCanvas);
        setTopBorder(newCanvas);
        setBottomBorder(newCanvas);

        return newCanvas;
    }

    private void setTopBorder(String[][] newCanvas) {
        for (int x = 0; x < width; x++) {
            newCanvas[x][0] = "-";
        }
    }

    private void setLeftBorder(String[][] newCanvas) {
        for (int y = 0; y < height - 1; y++) {
            newCanvas[0][y] = "|";
        }
    }

    private void setBottomBorder(String[][] newCanvas) {
        for (int x = 0; x < width; x++) {
            newCanvas[x][height - 1] = "-";
        }
    }

    private void setRightBorder(String[][] newCanvas) {
        for (int y = 0; y < height - 1; y++) {
            newCanvas[width - 1][y] = "|";
        }
    }

    private void initializeEmptyCanvas(String[][] newCanvas) {
        for (int x = 0; x < width - 1; x++) {
            for (int y = 0; y < height - 1; y++) {
                newCanvas[x][y] = " ";
            }
        }
    }
}
