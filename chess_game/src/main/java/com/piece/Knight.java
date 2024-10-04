package com.piece;

import com.chess.gamePanel;

public class Knight extends Piece {

    public Knight(int colour, int col, int row) {
        super(colour, col, row);
        if (colour == gamePanel.WHITE) {
            image = getImage("/piece/w-knight");
        } else {
            image = getImage("/piece/b-knight");
        }
    }

}
