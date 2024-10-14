public class Bishop extends ChessPiece{
    public Bishop(String color) {
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

        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false;
        }

        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) {
            return false;
        }

        int stepLine = (toLine - line) > 0 ? 1 : -1;
        int stepColumn = (toColumn - column) > 0 ? 1 : -1;

        for (int i = line + stepLine, j = column + stepColumn; i != toLine && j != toColumn; i += stepLine, j += stepColumn) {
            if (chessBoard.board[i][j] != null) {
                return false;
            }
        }

        if (chessBoard.board[toLine][toColumn] != null) {
            return !chessBoard.board[toLine][toColumn].getColor().equals(this.color); // Можно съесть, если фигура противника
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
