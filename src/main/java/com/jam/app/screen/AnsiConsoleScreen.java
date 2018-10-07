package com.jam.app.screen;

import com.jam.app.ConsolePainter;
import com.jam.app.Painter;
import com.jam.app.model.Canvas;
import com.jam.app.model.CanvasReaderUtil;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class AnsiConsoleScreen {

    private static final String INPUT_PROMPT = "enter something: ";
    private Painter painter;

    public AnsiConsoleScreen() {
        AnsiConsole.systemInstall();
    }

    public void refresh() {
        clearScreen();
        printPrompt();
        print(painter.getCanvas());
        printPainterMessage();
        moveCursorToPrompt();
    }

    private void print(Canvas canvas) {
        System.out.println(CanvasReaderUtil.getCanvasAsString(canvas));
    }

    private void moveCursorToPrompt() {
        System.out.print(ansi().cursor(0, INPUT_PROMPT.length() + 1));
    }

    private void printPrompt() {
        System.out.println(INPUT_PROMPT);
    }

    private void printPainterMessage() {
        System.out.println(painter.getMessage());
    }

    public void clearScreen() {
        System.out.print(ansi().cursor(0, 0).eraseScreen());
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }
}
