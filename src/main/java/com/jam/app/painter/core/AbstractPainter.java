package com.jam.app.painter.core;

import com.jam.app.painter.core.action.Action;
import com.jam.app.painter.core.action.ActionFactory;
import com.jam.app.painter.core.command.Command;
import com.jam.app.painter.core.command.CommandFactory;
import com.jam.app.painter.core.model.Canvas;
import com.jam.app.painter.core.screen.Screen;

import java.util.List;

public abstract class AbstractPainter implements Painter {

    final ActionFactory actionFactory;

    final CommandFactory commandFactory;

    private final Screen screen;

    private boolean isPainting;
    private Canvas canvas;


    public AbstractPainter(Screen screen, CommandFactory commandFactory, ActionFactory actionFactory) {
        this.commandFactory = commandFactory;
        this.actionFactory = actionFactory;
        isPainting = true;
        this.screen = screen;
        this.screen.setPainter(this);
    }

    public abstract void paint();

    protected Screen getScreen() {
        return screen;
    }

    private ActionFactory getActionFactory() {
        return actionFactory;
    }

    private CommandFactory getCommandFactory() {
        return commandFactory;
    }

    protected boolean isPainting() {
        return isPainting;
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


    public void performAction(List<String> input) {

        Command command = getCommandFactory().getCommand(input);
        Action canvasAction = getActionFactory().getAction(this, command);
        canvasAction.perform();

    }
}
