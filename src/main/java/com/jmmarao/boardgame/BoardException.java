package com.jmmarao.boardgame;

import java.io.Serial;

public class BoardException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -7470208709094820447L;

    public BoardException(String message) {
        super(message);
    }
}
