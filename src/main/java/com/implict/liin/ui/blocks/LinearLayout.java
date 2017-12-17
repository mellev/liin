package com.implict.liin.ui.blocks;

import com.implict.liin.ui.CompositeNode;
import com.implict.liin.ui.Node;
import com.implict.liin.ui.blocks.linearLayoutOrientation.LinearLayoutOrientationInterface;
import com.implict.liin.ui.util.Position;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;

public class LinearLayout extends CompositeNode {
    private LinearLayoutOrientationInterface strategy;

    public LinearLayout(LinearLayoutOrientationInterface strategy, SizeInterface width, SizeInterface height) {
        this.strategy = strategy;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g, Position position) {
        Graphics2D inner = (Graphics2D) g.create(position.getX(), position.getY(), getWidth(), getHeight());

        for (Node child : children) {
            this.strategy.draw(child, inner);
        }
    }

    @Override
    public int getWidth() {
        return this.strategy.getWidth(children, getParent(), width);
    }

    @Override
    public int getHeight() {
        return this.strategy.getHeight(children, getParent(), height);
    }

}
