package com.implict.liin.ui.util.size;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.size.strategy.StrategyInterface;

public class Wrap implements SizeInterface {
    private StrategyInterface strategy;

    public Wrap(StrategyInterface strategy) {
        this.strategy = strategy;
    }

    @Override
    public int getValue(Node parent, SizeInterface child) {
        return child.getValue(parent, child);
    }

}
