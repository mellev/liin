package com.implict.liin.ui.util.size;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.size.strategy.StrategyInterface;

public class Percent implements SizeInterface {
    private float value;

    private StrategyInterface strategy;

    public Percent(StrategyInterface strategy, float value) {
        this.strategy = strategy;
        this.value = value;
    }

    @Override
    public int getValue(Node parent, SizeInterface child) {
        return (int)(strategy.getValue(parent) * value);
    }
}
