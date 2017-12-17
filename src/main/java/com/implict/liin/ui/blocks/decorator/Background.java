package com.implict.liin.ui.blocks.decorator;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.Position;

import java.awt.*;

public class Background extends AbstractDecorator {

    private Paint paint;

    public Background(Node node, Paint color) {
        super(node);
        this.paint = color;
    }

    @Override
    public void draw(Graphics2D graphics2D, Position position) {
        graphics2D.setPaint(paint);
        graphics2D.fill(node.getShape());
        super.draw(graphics2D, position);
    }
}
