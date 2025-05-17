package vues;

import modeles.Dame;
import modeles.GameManager;
import modeles.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardView extends JFrame {
    private JPanel contentPane;
    private GameManager gameManager;
    private int cellSize;
    private Point initialClick;

    public BoardView(GameManager gameManager) {
        this.gameManager = gameManager;
        setUndecorated(true); // Remove OS title bar
        initializeUI();
        setVisible(true);
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sidebarWidth = 40;
        int minSize = Math.min(screenSize.width, screenSize.height) - 50;
        int boardSize = minSize - sidebarWidth;

        setSize(minSize, minSize);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Right-side title bar
        JPanel rightBar = new JPanel();
        rightBar.setLayout(new BoxLayout(rightBar, BoxLayout.Y_AXIS));
        rightBar.setBackground(new Color(40, 40, 40));
        rightBar.setPreferredSize(new Dimension(sidebarWidth, minSize));

        // Dragging functionality
        rightBar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }
        });

        rightBar.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                setLocation(thisX + xMoved, thisY + yMoved);
            }
        });

        // Buttons
        JButton minimizeButton = new JButton("—");
        JButton closeButton = new JButton("X");

        styleVerticalButton(minimizeButton);
        styleVerticalButton(closeButton);

        minimizeButton.addActionListener(e -> setState(Frame.ICONIFIED));
        closeButton.addActionListener(e -> System.exit(0));

        rightBar.add(Box.createVerticalGlue());
        rightBar.add(minimizeButton);
        rightBar.add(Box.createVerticalStrut(5));
        rightBar.add(closeButton);
        rightBar.add(Box.createVerticalStrut(10));

        add(rightBar, BorderLayout.EAST);

        // Main board panel
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(255, 236, 206));
        contentPane.setPreferredSize(new Dimension(boardSize, minSize));
        add(contentPane, BorderLayout.CENTER);

        cellSize = boardSize / 10;
        int startX = (boardSize - (cellSize * 10)) / 2;
        int startY = (minSize - (cellSize * 10)) / 2;

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Square square = gameManager.getBoard()[y][x];
                SquareView squareView = new SquareView(square.getColor());
                squareView.setBounds(startX + x * cellSize, startY + y * cellSize, cellSize, cellSize);
                contentPane.add(squareView);

                if (square.getPiece() != null) {
                    if (square.getPiece() instanceof Dame) {
                        DameView piece = new DameView(square.getPiece().getColor());
                        squareView.addPiece(piece);
                    } else {
                        PionView piece = new PionView(square.getPiece().getColor());
                        squareView.addPiece(piece);
                    }
                }
            }
        }
    }

    private void styleVerticalButton(JButton button) {
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(new Color(60, 60, 60));
        button.setForeground(Color.WHITE);
        button.setMaximumSize(new Dimension(40, 30));
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void updateBoard() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Square square = gameManager.getBoard()[y][x];
                Component comp = contentPane.getComponentAt(x * cellSize, y * cellSize);
                if (comp instanceof SquareView squareView) {
                    squareView.removePiece();
                    if (square.getPiece() != null) {
                        if (square.getPiece() instanceof Dame) {
                            DameView piece = new DameView(square.getPiece().getColor());
                            squareView.addPiece(piece);
                        } else {
                            PionView piece = new PionView(square.getPiece().getColor());
                            squareView.addPiece(piece);
                        }
                    }
                }
            }
        }
        contentPane.repaint();
    }
}
