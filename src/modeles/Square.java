package modeles;

public class Square {
    private String color;
    private Piece piece;

    public Square(String color, Piece piece) {
        this.color = color;
        this.piece = piece;
    }

    public String getColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public boolean isOpponent(String playerColor) {
        return piece != null && !piece.getColor().equals(playerColor);
    }

    public void removePiece() {
        this.piece = null;  // Removes the piece from this square
    }
}
