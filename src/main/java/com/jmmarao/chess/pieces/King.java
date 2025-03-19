package com.jmmarao.chess.pieces;

import com.jmmarao.boardgame.Board;
import com.jmmarao.boardgame.Position;
import com.jmmarao.chess.ChessMatch;
import com.jmmarao.chess.ChessPiece;
import com.jmmarao.chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p))
            mat[p.getRow()][p.getColumn()] = true;

        // special move castling
        if (getMoveCount() == 0 && !chessMatch.isCheck()) {
            // special move castling king side rook
            Position positionT1 = new Position(position.getRow(), position.getColumn() + 3);

            if (testRookCastling(positionT1)) {
                Position position1 = new Position(position.getRow(), position.getColumn() + 1);
                Position position2 = new Position(position.getRow(), position.getColumn() + 2);

                if (getBoard().piece(position1) == null && getBoard().piece(position2) == null)
                    mat[position.getRow()][position.getColumn() + 2] = true;
            }

            // special move castling queen side rook
            Position positionT2 = new Position(position.getRow(), position.getColumn() - 4);

            if (testRookCastling(positionT2)) {
                Position position1 = new Position(position.getRow(), position.getColumn() - 1);
                Position position2 = new Position(position.getRow(), position.getColumn() - 2);
                Position position3 = new Position(position.getRow(), position.getColumn() - 3);

                if (getBoard().piece(position1) == null && getBoard().piece(position2) == null && getBoard().piece(position3) == null)
                    mat[position.getRow()][position.getColumn() - 2] = true;
            }
        }

        return mat;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
    }

    @Override
    public String toString() {
        return "K";
    }
}
