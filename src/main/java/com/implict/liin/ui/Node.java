package com.implict.liin.ui;

import com.implict.liin.ui.util.size.Pixel;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;
import java.util.ArrayList;

public abstract class Node implements NodeInterface {

    protected CompositeNode parent;

    protected SizeInterface width = new Pixel(0);

    protected SizeInterface height = new Pixel(0);

    @Override
    public int getInnerHeight() {
        return 0;
    }

    @Override
    public int getInnerWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public void addChild(Node child) {

    }

    @Override
    public Node getChild(int x) {
        return null;
    }

    @Override
    public CompositeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(CompositeNode parent) {
        this.parent = parent;
    }

    @Override
    public ArrayList<Node> getChildren() {
        return null;
    }

    @Override
    public Shape getShape() {
        return new Rectangle(getWidth(), getHeight());
    }
}
