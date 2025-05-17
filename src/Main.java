import controlleurs.UtilisateurControlleur;
import modeles.*;
import vues.*;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
       /* // Initialize an empty board (or a predefined starting board)
        Square[][] initialBoard = new Square[10][10];

        // Initialize the squares with empty or starting pieces
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                // You may want to use some method to initialize each square with a piece
                initialBoard[row][col] = new Square("white", null); // Example setup
            }
        }

        // Create the GameManager with the initial board and the starting player
        GameManager gameManager = new GameManager(initialBoard, "white");

        // Now, pass the gameManager to the BoardView for rendering
        BoardView boardView = new BoardView(gameManager);
        boardView.setVisible(true);

        // Optionally, you can keep the logic for login or registration
        InscriFrame inscription = new InscriFrame();
        AuthFrame login = new AuthFrame();
        new UtilisateurControlleur(inscription, login);
        login.setVisible(true);*/

                Square[][] board = new Square[10][10];

                // Initialize all squares with alternating colors
                for (int row = 0; row < 10; row++) {
                    for (int col = 0; col < 10; col++) {
                        String squareColor = (row + col) % 2 == 0 ? "light" : "dark";
                        board[row][col] = new Square(squareColor, null);
                    }
                }

                // Create and place 20 black pions on rows 0 to 3 (on black squares only)
                int blackId = 1;
                for (int row = 0; row < 4; row++) {
                    for (int col = 0; col < 10; col++) {
                        if ((row + col) % 2 != 0 && blackId <= 20) {
                            Pion blackPion = new Pion(blackId++, "black", false);
                            board[row][col].setPiece(blackPion);
                        }
                    }
                }

                // Create and place 20 white pions on rows 6 to 9 (on black squares only)
                int whiteId = 1;
                for (int row = 6; row < 10; row++) {
                    for (int col = 0; col < 10; col++) {
                        if ((row + col) % 2 != 0 && whiteId <= 20) {
                            Pion whitePion = new Pion(whiteId++, "white", false);
                            board[row][col].setPiece(whitePion);
                        }
                    }
                }

                // Optional: Print the board to verify
                for (int row = 0; row < 10; row++) {
                    for (int col = 0; col < 10; col++) {
                        Piece piece = board[row][col].getPiece();
                        System.out.print((piece != null ? piece.toString().charAt(0) : ".") + " ");
                    }
                    System.out.println();
                }
                GameManager gameManager = new GameManager(board,"black");
                BoardView boardView = new BoardView(gameManager);
            }
        }
