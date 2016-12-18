package GUI;

import Engine.Engine;
import Engine.ICell;

import javax.swing.*;
import java.awt.Graphics;

/**
 * Created by Arina Melnichuk on 12/18/2016.
 */
public class GamePanel extends JPanel {
    private int mapSizeX, mapSizeY, cellSize;
    private Engine engine;

    public GamePanel(int mapSizeX, int mapSizeY, int cellSize, Engine engine) {
        this.mapSizeX = mapSizeX;
        this.mapSizeY = mapSizeY;
        this.cellSize = cellSize;
        this.engine = engine;
    }

    public void paintComponent(Graphics g) {
        for (int x = 0; x < this.mapSizeX + 1; ++x)
            g.drawLine(this.cellSize * x, 0, this.cellSize * x, this.cellSize * this.mapSizeY);
        for (int y = 0; y < this.mapSizeY + 1; ++y)
            g.drawLine(0, this.cellSize * y, this.cellSize * this.mapSizeX, this.cellSize * y);
        ICell[][] field = this.engine.level.field.objects;
        for (int y = 0; y < this.mapSizeY; ++y)
            for (int x = 0; x < this.mapSizeX; ++x)
                if (field[y][x] != null)
                    g.fillRect(this.cellSize * x, this.cellSize * y,
                               this.cellSize, this.cellSize);
    }
}
