package com.implict.liin;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class Applet extends java.applet.Applet implements Runnable
{
    private Thread thread;

    private long delayBetweenTicksInMillis = 17;

    private Image imageBuffer;

    private Graphics graphics;

    private Frame frame;

    public final void init() {
        frame = new Frame();

        frame.add(this);
        frame.setMenuBar(null);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();

        onStart();

        thread = new Thread(this);
        thread.start();

        imageBuffer = createImage(getWidth(), getHeight());
    }

    public abstract void onStart();

    public abstract void onTick();

    public final void run() {
        try {
            do {
                tick();
                Thread.sleep(delayBetweenTicksInMillis);
            } while (true);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public Frame getFrame() {
        return frame;
    }

    public final void update(Graphics g) {
        paint(graphics);
    }

    public final void paint(Graphics g) {
        draw(g);
        super.getGraphics().drawImage(imageBuffer, 0, 0, null);
    }

    protected abstract void draw(Graphics g);

    protected Thread getThread() {
        return thread;
    }

    protected void setDelayBetweenTicksInMillis(long millis) {
        delayBetweenTicksInMillis = millis;
    }

    private void tick() {
        onTick();

        if (getWidth() <= 0 && getHeight() <= 0) {
            return;
        }

        imageBuffer = createImage(getWidth(), getHeight());
        graphics = imageBuffer.getGraphics();

        repaint();
    }
}
