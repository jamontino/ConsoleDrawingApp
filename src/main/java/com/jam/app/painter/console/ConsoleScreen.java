package com.jam.app.painter.console;

import com.jam.app.painter.core.model.CanvasReaderUtil;
import com.jam.app.painter.core.screen.AbstractScreen;
import com.jam.app.painter.core.screen.Screen;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleScreen extends AbstractScreen implements Screen {

    private static final String INPUT_PROMPT = "enter command: ";

    public ConsoleScreen() {
        AnsiConsole.systemInstall();
    }

    @Override
    public void refreshScreen() {
        clearScreen();
        print(this.getScreenContent());
        moveCursorToPrompt();
    }

    @Override
    public String getScreenContent() {
        String displayText;
        displayText = INPUT_PROMPT + "\n";
        displayText = displayText.concat(CanvasReaderUtil.getCanvasAsString(getPainter().getCanvas()));
        displayText = displayText.concat(((ConsolePainter)getPainter()).getMessage());

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
}
