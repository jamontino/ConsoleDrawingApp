package com.jam.app.painter.json;

import com.fasterxml.jackson.core.JsonProcessingException;

public class GenericJsonPainterException extends RuntimeException {


    public GenericJsonPainterException(Exception e) {
        super(e);
    }
}
