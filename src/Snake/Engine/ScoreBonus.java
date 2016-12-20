package Snake.Engine;

import java.awt.*;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class ScoreBonus extends Bonus {
    private int points;
    private Color color;

    public ScoreBonus(Point location) {
        super(location);
        points = 5;
        color = Color.RED;
    }

    @Override
    public void applyEffect(Level level) {
        super.applyEffect(level);
        level.score += points;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void accept(Visitor visitor, Graphics g, int cellSize) {
        visitor.visit(this, location.x, location.y, cellSize);
    }
}
