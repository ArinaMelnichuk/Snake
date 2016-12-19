package Engine;

import java.awt.Point;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
abstract public class Hedge implements ICell {
    private Point location;

    @Override
    public void applyEffect(Level level) {
        if (level.snake.snakeParts.getFirst().location == this.location)
            level.snake.isAlive = false;
    }
}
