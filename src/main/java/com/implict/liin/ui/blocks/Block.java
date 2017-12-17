package com.implict.liin.ui.blocks;

import com.implict.liin.ui.CompositeNode;
import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.size.SizeInterface;

public class Block extends CompositeNode {
    public Block(Node child, SizeInterface width, SizeInterface height) {
        super(child, width, height);
    }

    public Block(Node[] children, SizeInterface width, SizeInterface height) {
        super(children, width, height);
    }

    public Block(Node[] children) {
        super(children);
    }

    public Block(Node child) {
        super(child);
    }
}
