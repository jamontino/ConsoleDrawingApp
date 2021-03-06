package com.jam.app.painter.core.action;

import com.jam.app.painter.core.Painter;
import com.jam.app.painter.core.action.canvas.BucketFillActionImpl;
import com.jam.app.painter.core.action.canvas.DrawLineActionImpl;
import com.jam.app.painter.core.action.canvas.DrawRectangleActionImpl;
import com.jam.app.painter.core.action.canvas.UnknownActionImpl;
import com.jam.app.painter.core.action.painter.CreateCanvasActionImpl;
import com.jam.app.painter.core.action.painter.QuitPainterActionImpl;
import com.jam.app.painter.core.command.Command;

import java.util.List;

import static com.jam.app.painter.core.action.converter.PointConverter.convert;
import static java.lang.Integer.parseInt;

public class ActionFactory {

    public Action getAction(Painter painter, Command command) {
        List<String> inputs = command.getInputs();
        switch (command.getType()) {
            case CREATE_CANVAS:
                return new CreateCanvasActionImpl(painter, parseInt(inputs.get(1)), parseInt(inputs.get(2)));
            case DRAW_STRAIGHT_LINE:
                return new DrawLineActionImpl(painter, convert(painter, parseInt(inputs.get(1)), parseInt(inputs.get(2))), convert(painter, parseInt(inputs.get(3)), parseInt(inputs.get(4))));
            case DRAW_RECTANGLE:
                return new DrawRectangleActionImpl(painter, convert(painter, parseInt(inputs.get(1)), parseInt(inputs.get(2))), convert(painter, parseInt(inputs.get(3)), parseInt(inputs.get(4))));
            case BUCKET_FILL:
                return new BucketFillActionImpl(painter, convert(painter, parseInt(inputs.get(1)), parseInt(inputs.get(2))), inputs.get(3));
            case QUIT:
                return new QuitPainterActionImpl(painter);
            case UNKNOWN:
            default:
                return new UnknownActionImpl(painter, inputs);
        }
    }
}
