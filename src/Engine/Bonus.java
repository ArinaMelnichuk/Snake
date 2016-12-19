package Engine;

import java.awt.Point;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public abstract class Bonus implements ICell {
    protected Point location;

    public Bonus(int x, int y) {
        location = new Point(x, y);
    }

    @Override
    public void applyEffect(Level level) {
        if (level.snake.snakeParts.getFirst().location == this.location)
            level.field.objects[this.location.y][this.location.x] = new Cell(this.location);
    }
}
