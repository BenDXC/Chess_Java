package com.piece;

import com.chess.gamePanel;

public class Pawn extends Piece {

    public Pawn(int colour, int col, int row) {
        super(colour, col, row);

        if (colour == gamePanel.WHITE) {
            image = getImage("/piece/w-pawn");
        } else {
            image = getImage("/piece/b-pawn");
        }
    }

}
