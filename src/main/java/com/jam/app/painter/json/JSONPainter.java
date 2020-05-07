package com.jam.app.painter.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jam.app.painter.core.AbstractPainter;
import com.jam.app.painter.core.action.ActionFactory;
import com.jam.app.painter.core.command.CommandFactory;
import com.jam.app.painter.core.model.CanvasReaderUtil;

import java.util.ArrayList;
import java.util.List;

public class JSONPainter extends AbstractPainter {

    private List<String> input = new ArrayList<String>();
    private static final ObjectMapper mapper = new ObjectMapper();

    public JSONPainter(VirtualScreen screen, CommandFactory commandFactory, ActionFactory actionFactory) {
        super(screen, commandFactory, actionFactory);
    }

    public String paint(List<String> input) {
        setInput(input);
        paint();
        return getContent();
    }

    public void setInput(List<String> input) {
        this.input.clear();
        this.input = input;
    }

    @Override
    public void paint() {
        try {
            if (!input.isEmpty()) {
                performAction(input);
            }
            input.clear();
        } catch (Exception e) {
            throw new GenericJsonPainterException(e);
        }
    }

    public String getContent() {
        String output;
        try {
            output = mapper.writeValueAsString(CanvasReaderUtil.getCanvasAsStringArray(getCanvas()));
        } catch (JsonProcessingException e) {
            throw new GenericJsonPainterException(e);
        }
        return output;
    }

}
