package vues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SquareView extends JPanel {
    private String color;
    private PieceView pieceView;

    public SquareView(String color) {
        this.color = color;
        setBackground(color.equals("dark") ? new Color(159, 78, 15) : new Color(255, 228, 137));
        setLayout(new BorderLayout());
        setOpaque(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle square click, triggering piece selection or movement
                System.out.println("Square clicked: " + color);
            }
        });
    }

    public void addPiece(PieceView piece) {
        this.pieceView = piece;
        add(piece, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void removePiece() {
        if (pieceView != null) {
            remove(pieceView);
            pieceView = null;
            revalidate();
            repaint();
        }
    }

    public PieceView getPieceView() {
        return pieceView;
    }
}
