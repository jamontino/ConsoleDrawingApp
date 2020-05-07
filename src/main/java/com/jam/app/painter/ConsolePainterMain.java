package com.jam.app.painter;

import com.jam.app.painter.core.AbstractPainter;
import com.jam.app.painter.console.ConsolePainter;
import com.jam.app.painter.core.action.ActionFactory;
import com.jam.app.painter.core.command.CommandFactory;
import com.jam.app.painter.core.input.InputScanner;
import com.jam.app.painter.console.ConsoleScreen;

public class ConsolePainterMain {

    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner();
        ConsoleScreen ConsoleScreen = new ConsoleScreen();
        CommandFactory commandFactory = new CommandFactory();
        ActionFactory actionFactory = new ActionFactory();
        AbstractPainter painter = new ConsolePainter(inputScanner, ConsoleScreen, commandFactory, actionFactory);
        painter.paint();
    }
}