package com.jam.app.screen;

import com.google.common.annotations.VisibleForTesting;
import com.jam.app.Painter;
import com.jam.app.model.CanvasReaderUtil;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class AnsiConsoleScreen {

    private static final String INPUT_PROMPT = "enter command: ";
    private Painter painter;

    public AnsiConsoleScreen() {
        AnsiConsole.systemInstall();
    }

    public void refresh() {
        clearScreen();
        print(getDisplayText());
        moveCursorToPrompt();
    }

    @VisibleForTesting
    String getDisplayText() {
        String displayText;
        displayText = INPUT_PROMPT + "\n";
        displayText = displayText.concat(CanvasReaderUtil.getCanvasAsString(painter.getCanvas()));
        displayText = displayText.concat(painter.getMessage());

        return displayText;
    }

    private void print(String displayText) {
        System.out.println(displayText);
    }

    private void moveCursorToPrompt() {
        System.out.print(ansi().cursor(0, INPUT_PROMPT.length() + 1));
    }

    private void clearScreen() {
        System.out.print(ansi().cursor(0, 0).eraseScreen());
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }
}
