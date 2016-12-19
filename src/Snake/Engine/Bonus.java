package Snake.Engine;

import java.awt.Point;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public abstract class Bonus implements ICell {
    protected Point location;
    protected boolean isCatched;

    public Bonus(Point location) {
        this.location = location;
        this.isCatched = false;
    }

    @Override
    public void applyEffect(Level level) {
        isCatched = true;
        level.snake.snakeParts.addFirst(new SnakePart(location));
    }
}
