package com.implict.liin.ui.blocks.linearLayoutOrientation;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.Position;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;
import java.util.ArrayList;

public class Horizontal implements LinearLayoutOrientationInterface {

    private int offsetX = 0;

    @Override
    public void draw(Node node, Graphics2D graphics2D) {
        Graphics2D inner = (Graphics2D) graphics2D.create(offsetX, 0, node.getWidth(), node.getHeight());
        node.draw(inner, new Position(0, 0));
        offsetX += node.getWidth();
    }

    @Override
    public int getHeight(ArrayList<Node> children, Node parent, SizeInterface height) {
        return height.getValue(parent, new SizeInterface() {

            @Override
            public int getValue(Node parent, SizeInterface child) {
                int maxSize = 0;

                for(Node item: children) {
                    if (item.getHeight() > maxSize) {
                        maxSize = item.getHeight();
                    }
                }

                return maxSize;
            }
        });
    }

    @Override
    public int getWidth(ArrayList<Node> children, Node parent, SizeInterface width) {

        return width.getValue(parent, new SizeInterface() {

            @Override
            public int getValue(Node parent, SizeInterface child) {
                int childrenSize = 0;

                for (Node item: children) {
                    childrenSize += item.getWidth();
                }

                return childrenSize;
            }
        });
    }

    @Override
    public int getOffsetX(ArrayList<Node> children, Node item) {
        int offset = 0;

        for (Node child: children) {
            if (child == item) {
                break;
            }

            offset += child.getWidth();
        }

        return offset;
    }

    @Override
    public int getOffsetY(ArrayList<Node> children, Node item) {
        return 0;
    }

    @Override
    public void reset() {
        offsetX = 0;
    }
}
