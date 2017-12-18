package com.implict.liin.composition;

import com.implict.liin.Applet;
import com.implict.liin.ui.blocks.Block;
import com.implict.liin.ui.blocks.LinearLayout;
import com.implict.liin.ui.blocks.Text;
import com.implict.liin.ui.blocks.decorator.Background;
import com.implict.liin.ui.blocks.linearLayoutOrientation.Horizontal;
import com.implict.liin.ui.blocks.linearLayoutOrientation.Vertical;
import com.implict.liin.ui.util.Position;
import com.implict.liin.ui.util.size.Parent;
import com.implict.liin.ui.util.size.Percent;
import com.implict.liin.ui.util.size.Pixel;
import com.implict.liin.ui.util.size.Wrap;
import com.implict.liin.ui.util.size.strategy.Height;
import com.implict.liin.ui.util.size.strategy.Width;

import java.awt.*;

public class Main extends Applet {

    public static void main(String args[]) {
        Applet applet = new Main();

        applet.init();
    }

    public void onStart() {
        Frame frame = getFrame();

        frame.setTitle("Composition");
        frame.pack();
    }

    public void onTick() {

    }

    public void draw(Graphics2D graphics) {
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 26);

        LinearLayout rootLayout = new LinearLayout(new Vertical(), new Parent(new Width()), new Parent(new Height()));

        LinearLayout childLayout1 = new LinearLayout(new Horizontal(), new Parent(new Width()), new Percent(new Height(), 0.5f));
        LinearLayout childLayout2 = new LinearLayout(new Horizontal(), new Parent(new Width()), new Percent(new Height(), 0.5f));

        childLayout1.addChild(
                new Background(
                        new Block(
                                new Text("Блок 2", font, getFontMetrics(font)),
                                new Percent(new Width(), 0.5f),
                                new Parent(new Height())
                        ),
                        Color.CYAN
                )
        );

        childLayout1.addChild(
                new Background(
                        new Block(
                                new Text("Блок 1", font, getFontMetrics(font)),
                                new Percent(new Width(), 0.5f),
                                new Parent(new Height())
                        ),
                        Color.MAGENTA
                )
        );

        childLayout2.addChild(
                new Background(
                        new Block(
                                new Text("Блок 3", font, getFontMetrics(font)),
                                new Percent(new Width(), (float) 1/3),
                                new Parent(new Height())
                        ),
                        Color.orange
                )
        );

        childLayout2.addChild(
                new Background(
                        new Block(
                                new Text("Блок 4", font, getFontMetrics(font)),
                                new Percent(new Width(), (float) 1/3),
                                new Wrap(new Height())
                        ),
                        Color.BLUE
                )
        );

        childLayout2.addChild(
                new Background(
                        new Block(
                                new Text("Блок 5", font, getFontMetrics(font)),
                                new Percent(new Width(), (float) 1/3),
                                new Parent(new Height())
                        ),
                        Color.YELLOW
                )
        );

        rootLayout.addChild(childLayout1);
        rootLayout.addChild(childLayout2);

        com.implict.liin.ui.blocks.Frame frame = new com.implict.liin.ui.blocks.Frame(
                rootLayout,
                new Pixel(getWidth()),
                new Pixel(getHeight())
        );

        frame.draw(graphics, new Position(0, 0));
    }
}
