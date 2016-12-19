package Engine;

import java.awt.Point;


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
        if (level.snake.snakeParts.getFirst().location == this.location) {
            level.snake.isAlive = false;
        }
    }
}
