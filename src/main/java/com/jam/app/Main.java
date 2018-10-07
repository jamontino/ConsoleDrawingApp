package com.jam.app;

import com.jam.app.action.ActionFactory;
import com.jam.app.command.CommandFactory;
import com.jam.app.input.InputScanner;
import com.jam.app.screen.AnsiConsoleScreen;

public class Main {

    public static void main(String[] args) {

        InputScanner inputScanner = new InputScanner();
        AnsiConsoleScreen ansiConsoleScreen = new AnsiConsoleScreen();
        CommandFactory commandFactory = new CommandFactory();
        ActionFactory actionFactory = new ActionFactory();
        ConsolePainter painter = new ConsolePainter(inputScanner,ansiConsoleScreen, commandFactory, actionFactory);
        painter.paint();
    }
}