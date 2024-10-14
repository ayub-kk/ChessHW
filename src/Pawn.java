public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) {
            return false;
        }

        int direction = color.equals("White") ? 1 : -1;
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];

        if (column == toColumn) {
            if (toLine == line + direction) {
                return chessBoard.board[toLine][toColumn] == null;
            }
            if ((color.equals("White") && line == 1 && toLine == 3) ||
                    (color.equals("Black") && line == 6 && toLine == 4)) {
                return (chessBoard.board[line + direction][column] == null && chessBoard.board[toLine][toColumn] == null);
            }
        }

        if (Math.abs(toColumn - column) == 1 && toLine == line + direction) {
            return targetPiece != null && !targetPiece.getColor().equals(this.color);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
