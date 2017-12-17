package com.implict.liin.ui.util.size;

import com.implict.liin.ui.Node;

public class Pixel implements SizeInterface {
    private int value;

    public Pixel(int value) {
        this.value = value;
    }

    @Override
    public int getValue(Node parent, SizeInterface child) {
        return value;
    }
}
