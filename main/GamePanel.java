package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import piece.*;

public class GamePanel extends JPanel implements Runnable {
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();

    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> simpieces = new ArrayList<>();

    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        setPieces();
        copyPieces(pieces, simpieces);

    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setPieces() {
        pieces.add(new pawn(WHITE, 0, 6));
        pieces.add(new pawn(WHITE, 1, 6));
        pieces.add(new pawn(WHITE, 2, 6));
        pieces.add(new pawn(WHITE, 3, 6));
        pieces.add(new pawn(WHITE, 4, 6));
        pieces.add(new pawn(WHITE, 5, 6));
        pieces.add(new pawn(WHITE, 6, 6));
        pieces.add(new pawn(WHITE, 7, 6));
        pieces.add(new rook(WHITE, 0, 7));
        pieces.add(new rook(WHITE, 7, 7));
        pieces.add(new knight(WHITE, 1, 7));
        pieces.add(new knight(WHITE, 6, 7));
        pieces.add(new bishop(WHITE, 2, 7));
        pieces.add(new bishop(WHITE, 5, 7));
        pieces.add(new queen(WHITE, 3, 7));
        pieces.add(new king(WHITE, 4, 7));

        pieces.add(new pawn(BLACK, 0, 1));
        pieces.add(new pawn(BLACK, 1, 1));
        pieces.add(new pawn(BLACK, 2, 1));
        pieces.add(new pawn(BLACK, 3, 1));
        pieces.add(new pawn(BLACK, 4, 1));
        pieces.add(new pawn(BLACK, 5, 1));
        pieces.add(new pawn(BLACK, 6, 1));
        pieces.add(new pawn(BLACK, 7, 1));
        pieces.add(new rook(BLACK, 0, 0));
        pieces.add(new rook(BLACK, 7, 0));
        pieces.add(new knight(BLACK, 1, 0));
        pieces.add(new knight(BLACK, 6, 0));
        pieces.add(new bishop(BLACK, 2, 0));
        pieces.add(new bishop(BLACK, 5, 0));
        pieces.add(new queen(BLACK, 3, 0));
        pieces.add(new king(BLACK, 4, 0));
    }

    private void copyPieces(ArrayList<Piece> source, ArrayList<Piece> target) {
        target.clear();
        for (int i = 0; i < source.size(); i++) {
            target.add(source.get(i));
        }
    }

    @Override
    public void run() {
        double dInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / dInterval;
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

        for (Piece p : simpieces) {
            p.draw(g2);
        }
    }

}
