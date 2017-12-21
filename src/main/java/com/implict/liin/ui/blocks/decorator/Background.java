package com.implict.liin.ui.blocks.decorator;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.Position;

import java.awt.*;

public class Background extends AbstractDecorator {

    private Paint paint;

    public Background(Node node, Paint paint) {
        super(node);
        this.paint = paint;
    }

    @Override
    public void draw(Graphics2D graphics2D, Position position) {
        Graphics2D inner = (Graphics2D) graphics2D.create(position.getX(), position.getY(), getWidth(), getHeight());
        inner.setPaint(paint);
        inner.fill(node.getShape());
        super.draw(inner, position);
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
