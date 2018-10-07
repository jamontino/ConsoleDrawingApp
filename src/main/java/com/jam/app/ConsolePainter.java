package com.jam.app;

import com.jam.app.action.Action;
import com.jam.app.action.ActionFactory;
import com.jam.app.command.Command;
import com.jam.app.command.CommandFactory;
import com.jam.app.input.InputScanner;
import com.jam.app.model.Canvas;
import com.jam.app.model.SelfClearingMessage;
import com.jam.app.screen.AnsiConsoleScreen;

import java.util.List;

public class ConsolePainter implements Painter {

    private final InputScanner inputScanner;
    private final AnsiConsoleScreen screen;
    private final ActionFactory actionFactory;
    private final CommandFactory commandFactory;

    private boolean isPainting;
    private Canvas canvas;
    private SelfClearingMessage message = new SelfClearingMessage();

    public ConsolePainter(InputScanner inputScanner, AnsiConsoleScreen screen, CommandFactory commandFactory, ActionFactory actionFactory) {
        this.inputScanner = inputScanner;
        this.screen = screen;
        this.screen.setPainter(this);
        this.commandFactory = commandFactory ;
        this.actionFactory = actionFactory ;

        isPainting = true;
    }

    public void paint() {
        do {
            screen.refresh();
            List<String> input = inputScanner.getInput();
            try {
                Command command = commandFactory.getCommand(input);
                Action canvasAction = actionFactory.getAction(this, command);
                canvasAction.perform();
            } catch (RuntimeException e) {
                setMessage(e.getMessage());
            }
        } while (isPainting);
        System.out.println("Quitting");
    }

    public void stopPainting() {
        isPainting = false;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public String getMessage() {
        return message.getMessage();
    }

    public void setMessage(String message) {
        this.message.setMessage(message);
    }
}
