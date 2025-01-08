package com.jmmarao.chess;

import com.jmmarao.boardgame.Board;
import com.jmmarao.boardgame.Piece;

public class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
