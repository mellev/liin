package com.implict.liin.ui.blocks.linearLayoutOrientation;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.Position;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;
import java.util.ArrayList;

public class Horizontal implements LinearLayoutOrientationInterface {

    private int offsetX = 0;

    @Override
    public void draw(Node node, Graphics2D g) {
        node.draw(g, new Position(offsetX, 0));
        offsetX += node.getWidth();
    }

    @Override
    public int getHeight(ArrayList<Node> childs, Node parent, SizeInterface height) {
        return height.getValue(parent, new SizeInterface() {

            @Override
            public int getValue(Node parent, SizeInterface child) {
                int maxSize = 0;

                for(Node item: childs) {
                    if (item.getHeight() > maxSize) {
                        maxSize = item.getHeight();
                    }
                }

                return maxSize;
            }
        });
    }

    @Override
    public int getWidth(ArrayList<Node> childs, Node parent, SizeInterface width) {

        return width.getValue(parent, new SizeInterface() {

            @Override
            public int getValue(Node parent, SizeInterface child) {
                int childsSize = 0;

                for (Node item: childs) {
                    childsSize += item.getWidth();
                }

                return childsSize;
            }
        });
    }

    @Override
    public int getOffsetX(ArrayList<Node> children, Node item) {
        int offset = 0;

        for (Node child: children) {


            offset += child.getWidth();

            if (child == item) {
                break;
            }
        }

        return offset;
    }

    @Override
    public int getOffsetY(ArrayList<Node> children, Node item) {
        return 0;
    }
}
