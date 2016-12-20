package Snake.Engine;

import java.awt.*;

/**
 * Created by Arina Melnichuk on 12/19/2016.
 */
public interface Visitor {
    void visit(ScoreBonus bonus, int x, int y, int cellSize);
    void visit(Wall wall, int x, int y, int cellSize);
    void visit(SnakePart snakePart, int x, int y, int cellSize);
    void visit(EmptyCell cell, int x, int y, int cellSize);
}
