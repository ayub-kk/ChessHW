public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int Line, int column, int toLine, int toColumn) {
        if (Line == toLine && column == toColumn) {
            return false;
        }

        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        return (Line == toLine || column == toColumn);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
