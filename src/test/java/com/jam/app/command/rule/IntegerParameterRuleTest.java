package com.jam.app.command.rule;

import com.jam.app.command.CommandType;
import com.jam.app.exception.CommandException;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerParameterRuleTest {

    private IntegerParameterRule testSubject;

    @Test
    public void validate() {
        testSubject = new IntegerParameterRule(CommandType.CREATE_CANVAS, "1");
        testSubject.validate();
    }

    @Test
    public void validate_WhenAlaphabetic_ThenThrowError() {
        testSubject = new IntegerParameterRule(CommandType.CREATE_CANVAS, "a");
        try{
            testSubject.validate();
            fail("Expected exception not thrown");
        }catch (CommandException e){
            assertEquals("Command [CREATE_CANVAS]: expected integer but got a.",e.getMessage());
        }
    }
}