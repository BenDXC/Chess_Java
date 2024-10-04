package com.piece;

import com.chess.gamePanel;

public class King extends Piece {

    public King(int colour, int col, int row) {
        super(colour, col, row);
        if (colour == gamePanel.WHITE) {
            image = getImage("/piece/w-king");
        } else {
            image = getImage("/piece/b-king");
        }
    }

}
