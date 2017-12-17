package com.implict.liin.ui.blocks.decorator;

import com.implict.liin.ui.CompositeNode;
import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.Position;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractDecorator extends Node {

    protected Node node;

    public AbstractDecorator(Node node) {
        this.node = node;
    }

    @Override
    public int getInnerWidth() {
        return node.getInnerWidth();
    }

    @Override
    public int getInnerHeight() {
        return node.getInnerHeight();
    }

    @Override
    public ArrayList<Node> getChildren() {
        return node.getChildren();
    }

    @Override
    public Shape getShape() {
        return node.getShape();
    }

    @Override
    public Node getChild(int x) {
        return node.getChild(x);
    }

    @Override
    public int getWidth() {
        return node.getWidth();
    }

    @Override
    public int getHeight() {
        return node.getHeight();
    }

    @Override
    public void addChild(Node child) {
        node.addChild(child);
    }

    @Override
    public CompositeNode getParent() {
        return node.getParent();
    }

    @Override
    public void setParent(CompositeNode parent) {
        node.setParent(parent);
    }

    @Override
    public void draw(Graphics2D graphics2D, Position position) {
        node.draw(graphics2D, position);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
