package com.jam.app.painter.core.command;

import com.jam.app.painter.core.command.rule.CommandRule;
import com.jam.app.painter.core.command.rule.IntegerParameterRule;
import com.jam.app.painter.core.command.rule.NumberOfParamsRule;
import com.jam.app.painter.core.command.rule.SingleCharParameterRule;

import java.util.ArrayList;
import java.util.List;

import static com.jam.app.painter.core.command.CommandType.*;

public class CommandFactory {

    public Command getCommand(List<String> inputs) {
        List<CommandRule> rules = new ArrayList<>();
        Command command = createCommand(inputs, rules);
        for (CommandRule rule : rules) {
            rule.validate();
        }
        return command;
    }

    private Command createCommand(List<String> inputs, List<CommandRule> rules) {
        switch (inputs.get(0)){
            case "C":
                return createCreateCommand(inputs, rules);
            case "L":
                return createDrawLineCommand(inputs, rules);
            case "R":
                return createDrawRectangleCommand(inputs, rules);
            case "B":
                return createBucketFillCommand(inputs, rules);
            case "Q":
                return createQuitCommand(inputs, rules);
            default:
                return createUnknownCommand(inputs);
        }
    }

    private static Command createUnknownCommand(List<String> inputs) {
        return new Command(UNKNOWN, inputs);
    }

    private static Command createQuitCommand(List<String> inputs, List<CommandRule> rules) {
        rules.add(new NumberOfParamsRule(QUIT, inputs, 1));
        return new Command(QUIT, inputs);
    }

    private static Command createBucketFillCommand(List<String> inputs, List<CommandRule> rules) {
        rules.add(new NumberOfParamsRule(BUCKET_FILL, inputs, 4));
        rules.add(new IntegerParameterRule(BUCKET_FILL, inputs.get(1)));
        rules.add(new IntegerParameterRule(BUCKET_FILL, inputs.get(2)));
        rules.add(new SingleCharParameterRule(BUCKET_FILL, inputs.get(3)));
        return new Command(BUCKET_FILL, inputs);
    }

    private static Command createDrawRectangleCommand(List<String> inputs, List<CommandRule> rules) {
        rules.add(new NumberOfParamsRule(DRAW_RECTANGLE, inputs, 5));
        rules.add(new IntegerParameterRule(DRAW_RECTANGLE, inputs.get(1)));
        rules.add(new IntegerParameterRule(DRAW_RECTANGLE, inputs.get(2)));
        rules.add(new IntegerParameterRule(DRAW_RECTANGLE, inputs.get(3)));
        rules.add(new IntegerParameterRule(DRAW_RECTANGLE, inputs.get(4)));
        return new Command(DRAW_RECTANGLE, inputs);
    }

    private static Command createDrawLineCommand(List<String> inputs, List<CommandRule> rules) {
        rules.add(new NumberOfParamsRule(DRAW_STRAIGHT_LINE, inputs, 5));
        rules.add(new IntegerParameterRule(DRAW_STRAIGHT_LINE, inputs.get(1)));
        rules.add(new IntegerParameterRule(DRAW_STRAIGHT_LINE, inputs.get(2)));
        rules.add(new IntegerParameterRule(DRAW_STRAIGHT_LINE, inputs.get(3)));
        rules.add(new IntegerParameterRule(DRAW_STRAIGHT_LINE, inputs.get(4)));
        return new Command(DRAW_STRAIGHT_LINE, inputs);
    }

    private static Command createCreateCommand(List<String> inputs, List<CommandRule> rules) {
        rules.add(new NumberOfParamsRule(CREATE_CANVAS, inputs, 3));
        rules.add(new IntegerParameterRule(CREATE_CANVAS, inputs.get(1)));
        rules.add(new IntegerParameterRule(CREATE_CANVAS, inputs.get(2)));

        return new Command(CREATE_CANVAS, inputs);
    }
}
