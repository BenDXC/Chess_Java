package piece;

import main.GamePanel;

public class rook extends Piece {
    public rook(int color, int col, int row) {
        super(color, col, row);
        if (color == GamePanel.WHITE) {
            image = getImage("/piece/w-rook");
        } else {
            image = getImage("/piece/b-rook");
        }
    }

}
