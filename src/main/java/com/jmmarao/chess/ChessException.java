package com.jmmarao.chess;

import com.jmmarao.boardgame.BoardException;

import java.io.Serial;

public class ChessException extends BoardException {
    @Serial
    private static final long serialVersionUID = 7585961615394325596L;

    public ChessException(String message) {
        super(message);
    }
}
