package com.jam.app.command;

import com.google.common.collect.Lists;
import com.jam.app.command.rule.NumberOfParamsRule;
import com.jam.app.exception.CommandException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NumberOfParamsRuleTest {

    private NumberOfParamsRule testSubject;

    @Test
    public void validate_WhenSuccess() {
        testSubject = new NumberOfParamsRule(CommandType.CREATE_CANVAS, Lists.newArrayList("a"), 1);
        testSubject.validate();
    }

    @Test
    public void validate_WhenParameterMismatch_ThenThrowError() {
        testSubject = new NumberOfParamsRule(CommandType.CREATE_CANVAS, Lists.newArrayList("a"), 3);
        try {
            testSubject.validate();
            fail("Expected exception not thrown");
        } catch (CommandException e) {
            assertEquals("Command [CREATE_CANVAS]: expects 3 parameters.", e.getMessage());
        }
    }
}