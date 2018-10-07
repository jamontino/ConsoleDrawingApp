package com.jam.app.input;

import com.google.common.annotations.VisibleForTesting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputScanner {

    private final static String WHITESPACE_REGEX = "\\s";
    private Scanner scanner;

    public InputScanner() {
        scanner = new Scanner(System.in);
    }

    public List<String> getInput() {
        String rawInput = scanner.nextLine();
        List<String> strings = Arrays.asList(rawInput.split(WHITESPACE_REGEX));

        return strings;
    }

    @VisibleForTesting
    void setScannerForTesting(Scanner scanner) {
        this.scanner = scanner;
    }
}
