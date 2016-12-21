package Snake.Engine;

import java.awt.*;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Arina Melnichuk on 12/20/2016.
 */
public class VisitorImpl implements Visitor {
    private Graphics graphics;

    public VisitorImpl(Graphics graphics) {
        this.graphics = graphics;
    }

    public void visit(ScoreBonus bonus, int x, int y, int cellSize) {
        graphics.setColor(Color.RED);
        graphics.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }

    public void visit(Wall wall, int x, int y, int cellSize) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }

    public void visit(SnakePart snakePart, int x, int y, int cellSize) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }

    public void visit(EmptyCell cell, int x, int y, int cellSize) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }
}
