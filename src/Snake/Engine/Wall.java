package Snake.Engine;

import java.awt.*;

/**
 * Created by Arina Melnichuk on 11/26/2016.
 */
public class Wall extends Hedge {

    public Wall(Point location) {
        super(location);
    }

    @Override
    public void accept(Visitor visitor, Graphics g, int cellSize) {
        visitor.visit(this, location.x, location.y, cellSize);
    }
}
