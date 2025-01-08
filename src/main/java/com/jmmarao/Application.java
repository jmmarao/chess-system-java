package com.jmmarao;

import com.jmmarao.boardgame.Board;
import com.jmmarao.chess.ChessMatch;

public class Application {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}