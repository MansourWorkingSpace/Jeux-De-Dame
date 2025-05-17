package vues;

import javax.swing.*;
import java.awt.*;

public abstract class PieceView extends JPanel {
    protected String color;
    protected static final int PIECE_DIAMETER = 40;

    public PieceView(String color) {
        this.color = color;
        setOpaque(false);
        setPreferredSize(new Dimension(PIECE_DIAMETER, PIECE_DIAMETER));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPiece((Graphics2D) g);
    }

    protected abstract void drawPiece(Graphics2D g2d);
}
