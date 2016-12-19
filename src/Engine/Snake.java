package Engine;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;


/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Snake {
    public boolean isAlive;
    public LinkedList<SnakePart> snakeParts;
    public Point location;

    // TODO on future: different snake colors, spelling word clouds according snake actions
    // TODO create a new class generating objects positions
    // TODO invisible super-bonus

    public Snake(Point location) {
        this.location = location;
        this.isAlive = true;
        SnakePart head = new SnakePart(location);
        SnakePart tail = new SnakePart(new Point(location.x - 1, location.y));
        this.snakeParts = new LinkedList<>(Arrays.asList(head, tail));
    }

    public void move(Point vector, int mapWidth, int mapHeight) {
        for (int i = snakeParts.size() - 1; i > 0; --i)
            snakeParts.get(i).location = snakeParts.get(i - 1).location;
        SnakePart head = snakeParts.getFirst();
        head.location = new Point((head.location.x + vector.x + mapWidth) % mapWidth,
                (head.location.y + vector.y + mapHeight) % mapHeight);
    }
}
