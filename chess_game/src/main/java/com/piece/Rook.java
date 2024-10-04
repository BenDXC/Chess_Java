package com.piece;

import com.chess.gamePanel;

public class Rook extends Piece {

    public Rook(int colour, int col, int row) {
        super(colour, col, row);
        if (colour == gamePanel.WHITE) {
            image = getImage("/piece/w-rook");
        } else {
            image = getImage("/piece/b-rook");
        }
    }

}
