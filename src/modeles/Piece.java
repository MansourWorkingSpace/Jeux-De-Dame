package modeles;

public abstract class Piece {
    private String color;
    private boolean isDame;

    public Piece(int id, String color, boolean isDame) {
        this.color = color;
        this.isDame = isDame;
    }

    public String getColor() {
        return color;
    }
    public boolean isDame() {
        return isDame;
    }
    public void setDame(boolean dame) {
        isDame = dame;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void promote(int row) {
        if (this instanceof Pion) {
            if (getColor().equals("white") && row == 0) {
                setDame(true);
            } else if (getColor().equals("black") && row == 9) {
                setDame(true);
            }
        }
    }

    @Override
    public String toString() {
        return getColor() + " " + (isDame() ? "Dame" : "Pion");
    }

    public abstract boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Square[][] boardState);
    public abstract boolean canCapture(Square[][] board, int x, int y);
}
