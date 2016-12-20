package Snake.Engine;

import java.awt.*;
import java.util.Objects;

/**
 * Created by Arina Melnichuk on 12/20/2016.
 */
public class VisitorImpl implements Visitor {
    private Graphics graphics;

    public VisitorImpl(Graphics graphics) {
        this.graphics = graphics;
    }

    public void visit(ScoreBonus bonus, int x, int y, int cellSize) {
        Color c = bonus.getColor();
        graphics.setColor(c);
        graphics.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }

    public void visit(Wall wall, int x, int y, int cellSize) {
        Color c = wall.getColor();
        graphics.setColor(c);
        graphics.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }

    public void visit(SnakePart snakePart, int x, int y, int cellSize) {
        Color c = snakePart.getColor();
        graphics.setColor(c);
        graphics.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }

    public void visit(EmptyCell cell, int x, int y, int cellSize) {
        Color c = cell.getColor();
        graphics.setColor(c);
        graphics.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }
}
