package Snake.Engine;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;


/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Snake {
    public boolean isAlive;
    public LinkedList<SnakePart> snakeParts;
    private Point direction;

    // TODO on future: different snake colors, spelling word clouds according snake actions
    // TODO create a new class generating objects positions
    // TODO invisible super-bonus

    public Snake(Point location) {
        this.isAlive = true;
        SnakePart head = new SnakePart(location);
        SnakePart part = new SnakePart(new Point(location.x - 1, location.y));
        SnakePart tail = new SnakePart(new Point(location.x - 1, location.y - 1));
        this.snakeParts = new LinkedList<>(Arrays.asList(head, part, tail));
    }

    public void move(int mapWidth, int mapHeight) {
        for (int i = snakeParts.size() - 1; i > 0; --i)
            snakeParts.get(i).location = snakeParts.get(i - 1).location;
        SnakePart head = snakeParts.getFirst();
        head.location = new Point((head.location.x + direction.x + mapWidth) % mapWidth,
                (head.location.y + direction.y + mapHeight) % mapHeight);
    }

    public void setDirection(Point direction) {
        this.direction = direction;
    }

    public Point getLocation(int mapWidth, int mapHeight) {
        return new Point((snakeParts.getFirst().location.x + direction.x + mapWidth) % mapWidth,
                (snakeParts.getFirst().location.y + direction.y+ mapHeight) % mapHeight);
    }
}
