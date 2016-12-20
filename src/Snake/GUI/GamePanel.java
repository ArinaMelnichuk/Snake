package Snake.GUI;

import Snake.Engine.Engine;
import Snake.Engine.ICell;
import Snake.Engine.Visitor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arina Melnichuk on 12/18/2016.
 */
public class GamePanel extends JPanel {
    private int mapWidth, mapHeight, cellSize;
    private Engine engine;
    private Visitor visitor;

    public GamePanel(int mapWidth, int mapHeight, int cellSize, Engine engine) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.cellSize = cellSize;
        this.engine = engine;
        this.visitor = new Visitor();
    }

    public void paintComponent(Graphics g) {
        for (int x = 0; x < this.mapWidth + 1; ++x)
            g.drawLine(this.cellSize * x, 0, this.cellSize * x, this.cellSize * this.mapHeight);
        for (int y = 0; y < this.mapHeight + 1; ++y)
            g.drawLine(0, this.cellSize * y, this.cellSize * this.mapWidth, this.cellSize * y);
        ICell[][] field = this.engine.level.field.objects;
        for (int y = 0; y < this.mapHeight; ++y)
            for (int x = 0; x < this.mapWidth; ++x)
                field[y][x].accept(visitor, g, cellSize);
    }
}
