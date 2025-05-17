package vues;

import javax.swing.*;
import java.awt.*;

public class DameView extends PieceView {
    private Image crownIcon;

    public DameView(String color) {
        super(color);
        if (color.equals("white"))
            crownIcon = new ImageIcon("images/crownWhite.jpg").getImage();
        else
            crownIcon = new ImageIcon("images/crownBlack.jpg").getImage();
    }

    @Override
    protected void drawPiece(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // CSS-like shadow
        g2d.setColor(new Color(0, 0, 0, 50));
        g2d.fillOval(5, 5, getWidth() - 4, getHeight() - 4);

        // Base piece
        g2d.setColor(color.equals("black") ? Color.BLACK : Color.WHITE);
        g2d.fillOval(2, 2, getWidth() - 4, getHeight() - 4);

        // Outline
        g2d.setColor(color.equals("black") ? Color.WHITE : Color.BLACK);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.drawOval(2, 2, getWidth() - 4, getHeight() - 4);

        // Crown icon
        int iconSize = getWidth() / 2;
        int x = (getWidth() - iconSize) / 2;
        int y = (getHeight() - iconSize) / 2;
        g2d.drawImage(crownIcon, x, y, iconSize, iconSize, this);

        // Inner ring
        int ringDiameter = getWidth() / 2;
        int ringOffset = (getWidth() - ringDiameter) / 2;
        g2d.setColor(color.equals("black") ? Color.WHITE : Color.BLACK);
        g2d.setStroke(new BasicStroke(1.2f));
        g2d.drawOval(ringOffset, ringOffset, ringDiameter, ringDiameter);


    }
}
