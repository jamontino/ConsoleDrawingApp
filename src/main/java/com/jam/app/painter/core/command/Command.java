package com.jam.app.painter.core.command;

import java.util.List;

public class Command {
    private CommandType type;
    private List<String> inputs;

    public Command(CommandType type, List<String> inputs) {
        this.type = type;
        this.inputs = inputs;
    }

    public CommandType getType() {
        return type;
    }

    public List<String> getInputs() {
        return inputs;
    }
}
