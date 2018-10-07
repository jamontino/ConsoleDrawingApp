package com.jam.app.command.rule;

import com.jam.app.command.CommandType;
import com.jam.app.exception.CommandException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SingleCharParameterRuleTest {

    private SingleCharParameterRule testSubject;

    @Test
    public void validate() {
        testSubject = new SingleCharParameterRule(CommandType.CREATE_CANVAS, "a");
        testSubject.validate();
    }

    @Test
    public void validate_WhenMultiCharInputPassed_ThenThrowError() {
        testSubject = new SingleCharParameterRule(CommandType.CREATE_CANVAS, "abc");
        try{
            testSubject.validate();
            fail("Expected exception not thrown");
        }catch (CommandException e){
            assertEquals("Command [CREATE_CANVAS]: single character input required but got [abc].",e.getMessage());
        }
    }
}