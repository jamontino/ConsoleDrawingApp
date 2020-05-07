package com.jam.app.painter.core.command.rule;

import com.jam.app.painter.core.command.CommandType;
import com.jam.app.painter.core.exception.CommandException;

public class SingleCharParameterRule implements CommandRule {
    private final CommandType type;
    private final String rawInput;

    public SingleCharParameterRule(CommandType type, String rawInput) {
        this.type = type;
        this.rawInput = rawInput;
    }

    @Override
    public void validate() {
        if (rawInput.length() != 1){
            throw new CommandException("Command [" + type + "]: single character input required but got [" + rawInput + "].");
        }

    }
}
