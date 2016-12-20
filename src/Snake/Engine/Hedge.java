package Snake.Engine;

import java.awt.*;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
abstract public class Hedge implements ICell {
    protected Point location;
    private Color color;

    public Hedge(Point location) {
        this.location = location;
        color = Color.BLUE;
    }

    @Override
    public void applyEffect(Level level) {
        level.snake.isAlive = false;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
