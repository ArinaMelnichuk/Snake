package Engine;

import java.awt.Point;

/**
 * Created by Arina Melnichuk on 12/18/2016.
 */
public class Cell implements ICell {
    public Point location;

    public Cell(Point location) {
        this.location = location;
    }

    @Override
    public void applyEffect(Level level) {
        return;
    }
}
