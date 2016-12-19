package Snake.Engine;

import java.awt.Point;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
abstract public class Hedge implements ICell {
    protected Point location;

    public Hedge(Point location) {
        this.location = location;
    }

    @Override
    public void applyEffect(Level level) {
        level.snake.isAlive = false;
    }
}
