package com.jam.app.input;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class InputScannerTest {

    private InputScanner testSubject;

    @Before
    public void setUp() {
        testSubject = new InputScanner();

    }

    @Test
    public void getInput_WithNewLineCharOnly() {
        sendSimulatedKeyboardInput("\n");
        List<String> input = testSubject.getInput();
        assertEquals(1, input.size());
        assertEquals("", input.get(0));
    }

    @Test
    public void getInput_WithSingleInput() {
        sendSimulatedKeyboardInput("someValue");
        List<String> input = testSubject.getInput();
        assertEquals(1, input.size());
        assertEquals("someValue", input.get(0));
    }

    @Test
    public void getInput_WithMultipleInputs() {
        sendSimulatedKeyboardInput("someValue anotherValue finalValue");
        List<String> input = testSubject.getInput();
        assertEquals(3, input.size());
        assertEquals("someValue", input.get(0));
        assertEquals("anotherValue", input.get(1));
        assertEquals("finalValue", input.get(2));
    }

    private void sendSimulatedKeyboardInput(String val) {
        testSubject.setScannerForTesting(new Scanner(new ByteArrayInputStream(val.getBytes())));
    }
}