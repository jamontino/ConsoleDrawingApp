package com.jam.app.model;

public class SelfClearingMessage {
    private String message = "";

    public String getMessage() {
        String message = this.message;
        resetMessage();
        return message;
    }

    private void resetMessage() {
        message = "";
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
