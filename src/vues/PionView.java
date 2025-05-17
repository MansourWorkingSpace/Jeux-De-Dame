package vues;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PionView extends PieceView {
    public PionView(String color) {
        super(color);
    }

    public void addPionMouseListener(MouseListener listener) {
        this.addMouseListener(listener);
    }

    @Override
    protected void drawPiece(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // CSS-like shadow (offset and blurred look)
        g2d.setColor(new Color(0, 0, 0, 50)); // semi-transparent black
        g2d.fillOval(5, 5, getWidth() - 4, getHeight() - 4);

        // Main piece
        g2d.setColor(color.equals("black") ? Color.BLACK : Color.WHITE);
        g2d.fillOval(2, 2, getWidth() - 4, getHeight() - 4);

        // Outline
        g2d.setColor(color.equals("black") ? Color.WHITE : Color.BLACK);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.drawOval(2, 2, getWidth() - 4, getHeight() - 4);

        // Inner ring (not filled)
        int ringDiameter = getWidth() / 2;
        int ringOffset = (getWidth() - ringDiameter) / 2;
        g2d.setColor(color.equals("black") ? Color.WHITE : Color.BLACK);
        g2d.setStroke(new BasicStroke(1.2f));
        g2d.drawOval(ringOffset, ringOffset, ringDiameter, ringDiameter);
    }

}
