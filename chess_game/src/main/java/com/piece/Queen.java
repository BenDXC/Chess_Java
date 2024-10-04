package com.piece;

import com.chess.gamePanel;

public class Queen extends Piece {

    public Queen(int colour, int col, int row) {
        super(colour, col, row);
        if (colour == gamePanel.WHITE) {
            image = getImage("/piece/w-queen");
        } else {
            image = getImage("/piece/b-queen");
        }
    }

}
