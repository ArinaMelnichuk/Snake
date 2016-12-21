package Snake.Engine;


import java.awt.*;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class SnakePart implements ICell {
    public Point location;

    public SnakePart(Point location) {
        this.location = location;
    }

    @Override
    public void applyEffect(Level level) {
        if (level.snake.snakeParts.getFirst() != this) {
            level.snake.isAlive = false;
        }
    }

    @Override
    public void accept(Visitor visitor, Graphics g, int cellSize) {
        visitor.visit(this, location.x, location.y, cellSize);
    }
}
