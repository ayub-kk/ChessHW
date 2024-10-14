public class King extends ChessPiece{
    public King(String color) {
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

        return (Math.abs(Line - toLine) <= 1 && Math.abs(column - toColumn) <= 1);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int Line, int column){
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int targetLine = Line + i;
                int targetColumn = column + j;

                if (targetLine >= 0 && targetLine < 8 && targetColumn >= 0 && targetColumn < 8) {
                    if (board.isUnderAttackByAnyPiece(targetLine, targetColumn, this.color)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
