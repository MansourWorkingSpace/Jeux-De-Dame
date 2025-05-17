package modeles;

public class Dame extends Piece {

    public Dame(int id, String color) {
        super(id, color, true); // A Dame is always promoted to Dame (isDame = true)
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Square[][] boardState) {
        int rowDiff = endRow - startRow;
        int colDiff = endCol - startCol;

        // Movement must be along a diagonal
        if (Math.abs(rowDiff) != Math.abs(colDiff)) {
            return false;
        }

        int rowDirection = rowDiff > 0 ? 1 : -1;
        int colDirection = colDiff > 0 ? 1 : -1;

        int currentRow = startRow + rowDirection;
        int currentCol = startCol + colDirection;
        boolean opponentFound = false;

        while (currentRow != endRow && currentCol != endCol) {
            Square currentSquare = boardState[currentRow][currentCol];

            if (!currentSquare.isEmpty()) {
                if (currentSquare.isOpponent(this.getColor())) {
                    if (opponentFound) {
                        return false;
                    }
                    opponentFound = true;
                } else {
                    return false;
                }
            }

            currentRow += rowDirection;
            currentCol += colDirection;
        }

        if (!boardState[endRow][endCol].isEmpty()) {
            return false;
        }

        if (opponentFound || Math.abs(rowDiff) == 1) {
            return true;
        }

        return false;
    }


    @Override
    public boolean canCapture(Square[][] board, int x, int y) {
        int[] directions = {-1, 1}; // For checking up and down diagonal directions

        // Check all 4 diagonal directions for potential capture
        for (int dx : directions) {
            for (int dy : directions) {
                int currentX = x + dx;
                int currentY = y + dy;

                // Check if we're within bounds and continue while we're not out of bounds
                while (currentX >= 0 && currentX < board.length && currentY >= 0 && currentY < board[0].length) {
                    Square middleSquare = board[currentX][currentY];
                    int targetX = currentX + dx;
                    int targetY = currentY + dy;

                    // Check if the target square is within bounds and empty
                    if (targetX >= 0 && targetX < board.length && targetY >= 0 && targetY < board[0].length) {
                        Square targetSquare = board[targetX][targetY];

                        // Check if the middle square contains an opponent's piece and target square is empty
                        if (!middleSquare.isEmpty() && middleSquare.isOpponent(this.getColor()) && targetSquare.isEmpty()) {
                            return true; // Valid capture
                        }
                    }

                    // Move to the next diagonal square
                    currentX += dx;
                    currentY += dy;
                }
            }
        }

        return false; // No valid capture found
    }
}
