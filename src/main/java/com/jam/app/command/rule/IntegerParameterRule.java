package com.jam.app.command.rule;

import com.jam.app.command.CommandType;
import com.jam.app.exception.CommandException;

public class IntegerParameterRule implements CommandRule {
    private final CommandType type;
    private final String rawInput;

    public IntegerParameterRule(CommandType type, String rawInput) {
        this.type = type;
        this.rawInput = rawInput;
    }

    @Override
    public void validate() {
        try {
            Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new CommandException("Command [" + type + "]: expected integer but got " + rawInput + ".");
        }
    }
}
