package com.implict.liin.ui.util.size.strategy;

import com.implict.liin.ui.Node;

public class Width implements StrategyInterface {

    @Override
    public int getValue(Node node) {
        return node.getWidth();
    }
}
