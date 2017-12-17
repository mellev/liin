package com.implict.liin.ui.blocks.linearLayoutOrientation;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;
import java.util.ArrayList;

public interface LinearLayoutOrientationInterface {

    void draw(Node node, Graphics2D g);

    int getHeight(ArrayList<Node> childs, Node parent, SizeInterface height);

    int getWidth(ArrayList<Node> childs, Node parent, SizeInterface width);

    int getOffsetX(ArrayList<Node> children, Node item);

    int getOffsetY(ArrayList<Node> children, Node item);
}
