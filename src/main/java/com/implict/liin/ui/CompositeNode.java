package com.implict.liin.ui;

import com.implict.liin.ui.util.Position;
import com.implict.liin.ui.util.size.Pixel;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;
import java.util.ArrayList;

public abstract class CompositeNode extends Node {

    protected ArrayList<Node> children = new ArrayList<Node>();

    public CompositeNode(Node[] children, SizeInterface width, SizeInterface height) {
        for (Node child: children) {
            child.setParent(this);
            this.children.add(child);
        }

        this.width = width;
        this.height = height;
    }

    public CompositeNode(Node child, SizeInterface width, SizeInterface height) {
        child.setParent(this);
        children.add(child);

        this.width = width;
        this.height = height;
    }

    public CompositeNode(Node[] children) {
        for (Node child: children) {
            this.children.add(child);
            child.setParent(this);
        }
    }

    public CompositeNode(Node child) {
        children.add(child);
        child.setParent(this);
    }

    public CompositeNode() {

    }

    @Override
    public int getWidth() {
        return  width.getValue(getParent(), new SizeInterface() {
            @Override
            public int getValue(Node parent, SizeInterface child) {
                return getMaxWidthChild();
            }
        });
    }

    @Override
    public int getHeight() {
        return height.getValue(getParent(), new SizeInterface() {
            @Override
            public int getValue(Node parent, SizeInterface child) {
                return getMaxHeightChild();
            }
        });
    }

    @Override
    public void addChild(Node child) {
        children.add(child);
        child.setParent(this);
    }

    @Override
    public Node getChild(int index) {
        return children.get(index);
    }

    @Override
    public ArrayList<Node> getChildren() {
        return children;
    }

    @Override
    public int getInnerHeight() {
        return getHeight();
    }

    @Override
    public int getInnerWidth() {
        return getWidth();
    }

    @Override
    public void draw(Graphics2D graphics2D, Position position) {
        Graphics2D innerGraphics = (Graphics2D) graphics2D.create(position.getX(), position.getY(), getWidth(), getHeight());

        for (Node child: children) {
            child.draw(innerGraphics, new Position(0, 0));
        }
    }

    private int getMaxWidthChild() {
        int maxWidth = 0;

        for(Node child: children) {
            if (child.getWidth() > maxWidth) {
                maxWidth = child.getWidth();
            }
        }

        return maxWidth;
    }

    private int getMaxHeightChild() {
        int maxHeight = 0;

        for(Node child: children) {
            if (child.getHeight() > maxHeight) {
                maxHeight = child.getHeight();
            }
        }

        return maxHeight;
    }
}
