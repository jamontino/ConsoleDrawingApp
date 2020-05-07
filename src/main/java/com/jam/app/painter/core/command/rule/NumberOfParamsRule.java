package com.jam.app.painter.core.command.rule;

import com.jam.app.painter.core.command.CommandType;
import com.jam.app.painter.core.exception.CommandException;

import java.util.List;

public class NumberOfParamsRule implements CommandRule {
    private final CommandType type;
    private final List<String> input;
    private final int expectedNumberOfParams;

    public NumberOfParamsRule(CommandType type, List<String> input, int expectedNumberOfParams) {
        this.type = type;
        this.input = input;
        this.expectedNumberOfParams = expectedNumberOfParams;
    }

    @Override
    public void validate() {
        if (expectedNumberOfParams != input.size()){
            throw new CommandException("Command ["+type+"]: expects "+expectedNumberOfParams+" parameters.");
        }
    }
}
