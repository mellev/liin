package com.implict.liin.ui.blocks;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.size.SizeInterface;

public class Frame extends Block {

    public Frame(Node child, SizeInterface width, SizeInterface height) {
        super(child, width, height);
    }

    public Frame(Node[] children, SizeInterface width, SizeInterface height) {
        super(children, width, height);
    }
}
