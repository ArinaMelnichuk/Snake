package Snake.Engine;

import java.awt.*;

/**
 * Created by Arina Melnichuk on 12/18/2016.
 */
public class EmptyCell implements ICell {
    protected Point location;

    public EmptyCell(Point location) {
        this.location = location;
    }

    @Override
    public void applyEffect(Level level) {
        return;
    }

    @Override
    public void accept(Visitor visitor, Graphics g, int cellSize) {
        visitor.visit(this, location.x, location.y, cellSize);
    }
}
