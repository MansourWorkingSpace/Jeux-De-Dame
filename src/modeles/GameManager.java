package modeles;

import modeles.*;
import modeles.Square;

public class GameManager {
    private Square[][] board;
    private String currentPlayer;

    public GameManager(Square[][] initialBoard, String startingPlayer) {
        this.board = initialBoard;
        this.currentPlayer = startingPlayer;
    }

    public Square[][] getBoard() {
        return board;
    }


    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Square start = board[startRow][startCol];
        Square end = board[endRow][endCol];
        Piece piece = start.getPiece();

        if (piece == null || !piece.getColor().equals(currentPlayer)) return false;
        if (!piece.isValidMove(startRow, startCol, endRow, endCol, board)) return false;

        if (Math.abs(endRow - startRow) == 2 && Math.abs(endCol - startCol) == 2) {
            int capturedRow = (startRow + endRow) / 2;
            int capturedCol = (startCol + endCol) / 2;
            board[capturedRow][capturedCol].removePiece(); // Remove captured piece
        }

        end.setPiece(piece);
        start.removePiece();

        piece.promote(endRow);

        if (!canCaptureAgain(endRow, endCol)) {
            switchTurn();
        }

        return true;
    }

    private boolean canCaptureAgain(int row, int col) {
        Piece piece = board[row][col].getPiece();
        if (piece != null) {
            return piece.canCapture(board, row, col);
        }
        return false;
    }

    public void switchTurn() {
        currentPlayer = currentPlayer.equals("white") ? "black" : "white";
    }

    public boolean hasMandatoryCapture(String playerColor) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                Piece p = board[row][col].getPiece();
                if (p != null && p.getColor().equals(playerColor) && p.canCapture(board, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
