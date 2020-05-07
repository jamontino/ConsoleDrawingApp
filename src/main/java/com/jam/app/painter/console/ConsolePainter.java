package com.jam.app.painter.console;

import com.jam.app.painter.core.AbstractPainter;
import com.jam.app.painter.core.action.ActionFactory;
import com.jam.app.painter.core.command.CommandFactory;
import com.jam.app.painter.core.input.InputScanner;
import com.jam.app.painter.core.model.SelfClearingMessage;

import java.util.List;

public class ConsolePainter extends AbstractPainter {
    private final InputScanner inputScanner;
    private SelfClearingMessage message = new SelfClearingMessage();

    public ConsolePainter(InputScanner inputScanner, ConsoleScreen screen, CommandFactory commandFactory, ActionFactory actionFactory) {
        super(screen, commandFactory, actionFactory);
        this.inputScanner = inputScanner;
    }

    @Override
    public void paint() {
        do {
            getScreen().refreshScreen();
            List<String> input = inputScanner.getInput();
            try {
                performAction(input);
            } catch (RuntimeException e) {
                setMessage(e.getMessage());
            }
        } while (isPainting());
    }

    public String getMessage() {
        return message.getMessage();
    }

    public void setMessage(String message) {
        this.message.setMessage(message);
    }

}
