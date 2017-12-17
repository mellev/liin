package com.implict.liin.ui.blocks.linearLayoutOrientation;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.Position;
import com.implict.liin.ui.util.size.SizeInterface;

import java.awt.*;
import java.util.ArrayList;

public class Vertical implements LinearLayoutOrientationInterface {

    private int offsetY = 0;

    @Override
    public void draw(Node node, Graphics2D g) {
        node.draw(g, new Position(0, offsetY));
        offsetY += node.getHeight();
    }

    @Override
    public int getWidth(ArrayList<Node> childs, Node parent, SizeInterface width) {

        return width.getValue(parent, new SizeInterface() {

            @Override
            public int getValue(Node parent, SizeInterface child) {
                int maxSize = 0;

                for(Node item: childs) {
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


            offset += child.getHeight();

            if (child == item) {
                break;
            }
        }

        return offset;
    }

    @Override
    public int getHeight(ArrayList<Node> childs, Node parent, SizeInterface height) {

        return height.getValue(parent, new SizeInterface() {

            @Override
            public int getValue(Node parent, SizeInterface child) {
                int childsSize = 0;

                for (Node item: childs) {
                    childsSize += item.getHeight();
                }

                return childsSize;
            }
        });
    }
}
