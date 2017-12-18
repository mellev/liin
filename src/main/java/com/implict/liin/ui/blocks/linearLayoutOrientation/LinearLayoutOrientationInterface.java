package com.implict.liin.ui.blocks.linearLayoutOrientation;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;
import java.util.ArrayList;

public interface LinearLayoutOrientationInterface {

    void draw(Node node, Graphics2D graphics2D);

    int getHeight(ArrayList<Node> children, Node parent, SizeInterface height);

    int getWidth(ArrayList<Node> children, Node parent, SizeInterface width);

    int getOffsetX(ArrayList<Node> children, Node item);

    int getOffsetY(ArrayList<Node> children, Node item);
}
