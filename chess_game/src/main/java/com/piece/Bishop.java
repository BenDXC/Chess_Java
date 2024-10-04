package com.piece;

import com.chess.gamePanel;

public class Bishop extends Piece {

    public Bishop(int colour, int col, int row) {
        super(colour, col, row);
        if (colour == gamePanel.WHITE) {
            image = getImage("/piece/w-bishop");
        } else {
            image = getImage("/piece/b-bishop");
        }
    }

}
