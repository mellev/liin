package com.implict.liin.ui.blocks;

import com.implict.liin.ui.Node;
import com.implict.liin.ui.util.Position;

import java.awt.*;

public class Text extends Node {

    private String text;

    private Font font;

    private FontMetrics fontMetrics;

    public Text(String text, Font font, FontMetrics fontMetrics) {
        this.text = text;
        this.font = font;
        this.fontMetrics = fontMetrics;
    }

    @Override
    public void draw(Graphics2D graphics2D, Position position) {
        graphics2D.setFont(font);
        graphics2D.setColor(new Color(0,0,0));
        graphics2D.drawString(text, position.getX(), position.getY() + getHeight());
    }

    @Override
    public int getWidth() {
        return fontMetrics.stringWidth(text);
    }

    @Override
    public int getHeight() {
        return fontMetrics.getHeight();
    }

    public Font getFont() {
        return font;
    }

    public FontMetrics getFontMetrics() {
        return fontMetrics;
    }

    public String getText() {
        return text;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setFontMetrics(FontMetrics fontMetrics) {
        this.fontMetrics = fontMetrics;
    }

    public void setText(String text) {
        this.text = text;
    }
}
