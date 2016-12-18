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
        isAlive = true;
        SnakePart head = new SnakePart(location);
        SnakePart tail = new SnakePart(new Point(location.x + 1, location.y));
        snakeParts = new LinkedList<>(Arrays.asList(head, tail));
    }

    public void move(Point vector) {
        SnakePart head = snakeParts.getFirst();
        Point currentLocation = head.location;
        head.location = new Point(currentLocation.x + vector.x, currentLocation.y + vector.y);
    }
}
