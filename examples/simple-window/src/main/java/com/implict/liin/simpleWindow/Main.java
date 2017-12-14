package com.implict.liin.simpleWindow;

import com.implict.liin.Applet;

import java.awt.*;

public class Main extends Applet {

    public static void main(String args[]) {
        Applet applet = new Main();

        applet.init();
    }

    public void onStart() {
        Frame frame = getFrame();

        frame.setTitle("Simple Window");
        frame.pack();
    }

    public void onTick() {

    }

    public void draw(Graphics graphics) {
        graphics.fillOval(0,0, getWidth(), getHeight());
    }
}
