package GUI;

import Engine.Engine;
import Engine.ICell;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Arina Melnichuk on 12/17/2016.
 */
public class Game extends JFrame {
    private Engine engine;
    private int mapSizeX, mapSizeY;
    private static final int CELL_SIZE = 10;

    public Game() {
        mapSizeX = 50;
        mapSizeY = 40;
        this.setBounds(200, 150, mapSizeX * CELL_SIZE, mapSizeY * CELL_SIZE);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Pane panel = new Pane();
        this.setContentPane(panel);
        engine = new Engine(mapSizeX, mapSizeY);
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
                engine.keyPressed(e);
            }
        });
        this.setVisible(true);
    }

    private void keyPressed(KeyEvent e) {
        engine.keyPressed(e);
    }

    class Pane extends JPanel {
        public void paintComponent(Graphics g) {
            for (int x = 0; x < mapSizeX + 1; ++x)
                g.drawLine(CELL_SIZE * x, 0, CELL_SIZE * x, CELL_SIZE * mapSizeY);
            for (int y = 0; y < mapSizeY + 1; ++y)
                g.drawLine(0, CELL_SIZE * y, CELL_SIZE * mapSizeX, CELL_SIZE * y);
            ICell[][] field = engine.level.field.objects;
            for (int y = 0; y < mapSizeY; ++y)
                for (int x = 0; x < mapSizeX; ++x)
                    if (field[y][x] != null)
                        g.fillRect(CELL_SIZE * x, CELL_SIZE * y,
                                CELL_SIZE, CELL_SIZE);
        }
    }

    public static void main(String[] args) {
        Game app = new Game();
    }
}
