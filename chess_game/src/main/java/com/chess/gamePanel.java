package com.chess;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.piece.Piece;

public class gamePanel extends JPanel implements Runnable {
    /* Board */
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();

    /* Pieces */
    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> simpieces = new ArrayList<>();

    /* Colour of Piece */
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColour = WHITE;

    public gamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void setPieces(){
        
    }

    @override
    public void run() {
        /* lOOP */
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }

        }

    }

    private void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        board.draw(g2);
    }
}
