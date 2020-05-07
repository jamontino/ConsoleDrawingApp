package com.jam.app.webserver;

import com.google.common.collect.Lists;
import com.jam.app.painter.core.action.ActionFactory;
import com.jam.app.painter.core.command.CommandFactory;
import com.jam.app.painter.json.JSONPainter;
import com.jam.app.painter.json.VirtualScreen;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PainterController {

    private JSONPainter painter;

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(path = "/create/canvas")
    public String createCanvas(
            @RequestParam(value = "width") String width,
            @RequestParam(value = "height") String height
    ) {
        painter = new JSONPainter(new VirtualScreen(), new CommandFactory(), new ActionFactory());
        return painter.paint(Lists.newArrayList("C", width, height));
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(path = "/draw/line")
    public String drawLine(
            @RequestParam(value = "x1") String x1,
            @RequestParam(value = "y1") String y1,
            @RequestParam(value = "x2") String x2,
            @RequestParam(value = "y2") String y2
    ) {
        return painter.paint(Lists.newArrayList("L", x1,y1,x2,y2));
    }
}
