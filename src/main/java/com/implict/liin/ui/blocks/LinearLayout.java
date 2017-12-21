package com.implict.liin.ui.blocks;

import com.implict.liin.ui.CompositeNode;
import com.implict.liin.ui.Node;
import com.implict.liin.ui.blocks.linearLayoutOrientation.LinearLayoutOrientationInterface;
import com.implict.liin.ui.util.Position;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;
import java.util.ArrayList;

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

        this.strategy.reset();
    }

    @Override
    public int getWidth() {
        return this.strategy.getWidth(children, getParent(), width);
    }

    @Override
    public int getHeight() {
        return this.strategy.getHeight(children, getParent(), height);
    }

    @Override
    public ArrayList<Node> getChain(Position position) {
        ArrayList<Node> chain = new ArrayList<>();

        if (pointOnElement(position)) {
            chain.add(this);

            for (Node node: children) {
                int localX = position.getX() - strategy.getOffsetX(children, node);
                int localY = position.getY() - strategy.getOffsetY(children, node);

                Position localPosition = new Position(localX, localY);
                ArrayList<Node> localChain = node.getChain(localPosition);

                if (localChain.size() > 0) {
                    chain.addAll(localChain);
                    break;
                }
            }
        }

        return chain;
    }
}
