package Snake.Engine;

import java.awt.*;

/**
 * Created by Arina Melnichuk on 12/19/2016.
 */
public class Visitor {

    public void visit(Bonus bonus, int x, int y, int cellSize, Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }

    public void visit(Hedge wall, int x, int y, int cellSize, Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }

    public void visit(SnakePart snakePart, int x, int y, int cellSize, Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }

    public void visit(EmptyCell cell, int x, int y, int cellSize, Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
    }
}
