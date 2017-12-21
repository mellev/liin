package com.implict.liin.ui.blocks.linearLayoutOrientation;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.Position;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;
import java.util.ArrayList;

public class Vertical implements LinearLayoutOrientationInterface {

    private int offsetY = 0;

    @Override
    public void draw(Node node, Graphics2D graphics2D) {
        Graphics2D inner = (Graphics2D) graphics2D.create(0, offsetY, node.getWidth(), node.getHeight());
        node.draw(inner, new Position(0, 0));
        offsetY += node.getHeight();
    }

    @Override
    public int getWidth(ArrayList<Node> children, Node parent, SizeInterface width) {

        return width.getValue(parent, new SizeInterface() {

            @Override
            public int getValue(Node parent, SizeInterface child) {
                int maxSize = 0;

                for(Node item: children) {
                    if (item.getWidth() > maxSize) {
                        maxSize = item.getWidth();
                    }
                }

                return maxSize;
            }
        });
    }

    @Override
    public int getOffsetX(ArrayList<Node> children, Node item) {
        return 0;
    }

    @Override
    public int getOffsetY(ArrayList<Node> children, Node item) {
        int offset = 0;

        for (Node child: children) {
            if (child == item) {
                break;
            }

            offset += child.getHeight();
        }

        return offset;
    }

    @Override
    public int getHeight(ArrayList<Node> children, Node parent, SizeInterface height) {

        return height.getValue(parent, new SizeInterface() {

            @Override
            public int getValue(Node parent, SizeInterface child) {
                int childrenSize = 0;

                for (Node item: children) {
                    childrenSize += item.getHeight();
                }

                return childrenSize;
            }
        });
    }

    @Override
    public void reset() {
        offsetY = 0;
    }
}
