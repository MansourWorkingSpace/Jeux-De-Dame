package modeles;

public class Pion extends Piece {

    public Pion(int id, String color, boolean isDame) {
        super(id, color, isDame);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Square[][] boardState) {
        int direction = getColor().equals("white") ? -1 : 1; // White moves up, Black moves down

        if (Math.abs(endRow - startRow) == 1 && Math.abs(endCol - startCol) == 1 && boardState[endRow][endCol].isEmpty()) {
            return true;
        }

        if (Math.abs(endRow - startRow) == 2 && Math.abs(endCol - startCol) == 2) {
            int middleRow = (startRow + endRow) / 2;
            int middleCol = (startCol + endCol) / 2;
            Square middleSquare = boardState[middleRow][middleCol];

            // The middle square must contain an opponent's piece
            if (middleSquare.isOpponent(getColor())) {
                return true;  // Valid capture
            }
        }

        // Backward movement or capture (only allowed if jumping over an opponent's piece)
        if (Math.abs(endRow - startRow) == 2 && Math.abs(endCol - startCol) == 2) {
            int middleRow = (startRow + endRow) / 2;
            int middleCol = (startCol + endCol) / 2;
            Square middleSquare = boardState[middleRow][middleCol];

            if (getColor().equals("white") && endRow > startRow || getColor().equals("black") && endRow < startRow) {
                // Only allow backward jump if the middle square contains an opponent's piece
                if (middleSquare.isOpponent(getColor()) && boardState[endRow][endCol].isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean canCapture(Square[][] board, int x, int y) {
        int[] dx = {-2, 2}; // 2 steps diagonally (jumping over opponent)
        int[] dy = {-2, 2};

        for (int deltaX : dx) {
            for (int deltaY : dy) {
                int targetX = x + deltaX;
                int targetY = y + deltaY;

                // Check board boundaries
                if (targetX >= 0 && targetX < board.length && targetY >= 0 && targetY < board[0].length) {
                    Square targetSquare = board[targetX][targetY];
                    int middleX = (x + targetX) / 2;
                    int middleY = (y + targetY) / 2;
                    Square middleSquare = board[middleX][middleY];

                    // Can capture if middle square has opponent and target square is empty
                    if (middleSquare != null && !middleSquare.isEmpty() &&
                            middleSquare.isOpponent(this.getColor()) &&
                            targetSquare.isEmpty()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}