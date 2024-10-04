package com.piece;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.chess.Board;

public class Piece {
    public BufferedImage image;
    public int x, y, col, row, preCol, preRow, colour;

    public Piece(int colour, int col, int row) {
        this.colour = colour;
        this.col = col;
        this.row = row;
        x = getX(col);
        y = getY(row);
        preCol = col;
        preRow = row;
    }

    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + "png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    private int getY(int row) {
        return row * Board.SQUARE_SIZE;
    }

    private int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }

}
