package com.implict.liin.ui;

import com.implict.liin.ui.util.Position;

import java.awt.*;
import java.util.ArrayList;

public interface NodeInterface {

    int getWidth();

    int getHeight();

    int getInnerWidth();

    int getInnerHeight();

    void draw(Graphics2D graphics2D, Position position);

    void addChild(Node child);

    void setParent(CompositeNode parent);

    CompositeNode getParent();

    Node getChild(int x);

    Shape getShape();

    ArrayList<Node> getChildren();
}
