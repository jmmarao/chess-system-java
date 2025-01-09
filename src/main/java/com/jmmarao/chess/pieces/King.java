package com.jmmarao.chess.pieces;

import com.jmmarao.boardgame.Board;
import com.jmmarao.chess.ChessPiece;
import com.jmmarao.chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
}
