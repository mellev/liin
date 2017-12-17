package com.implict.liin.ui.util.size;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.size.strategy.StrategyInterface;

public class Parent implements SizeInterface {

    private StrategyInterface strategy;

    public Parent(StrategyInterface strategy) {
        this.strategy = strategy;
    }

    @Override
    public int getValue(Node parent, SizeInterface child) {
        return strategy.getValue(parent);
    }
}
