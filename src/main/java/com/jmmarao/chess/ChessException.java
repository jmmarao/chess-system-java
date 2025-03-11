package com.jmmarao.chess;

import java.io.Serial;

public class ChessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 7585961615394325596L;

    public ChessException(String message) {
        super(message);
    }
}
