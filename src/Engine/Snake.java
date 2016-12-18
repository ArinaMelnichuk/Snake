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
        SnakePart tail = new SnakePart(new Point(location.x - 1, location.y));
        snakeParts = new LinkedList<>(Arrays.asList(head, tail));
    }

    public void move(Point vector, int width, int height) {
        Point previousLocation = snakeParts.getFirst().location;
        Point currentLocation = previousLocation;
        for (SnakePart snakePart : snakeParts) {
            if (snakePart == snakeParts.getFirst()) {
                snakePart.location = new Point(previousLocation.x + vector.x, previousLocation.y + vector.y);
                continue;
            }
            currentLocation = snakePart.location;
            snakePart.location = previousLocation;
            previousLocation = currentLocation;
        }
//        loop(width, height);
    }

    private void loop(int width, int height) {
        this.location = new Point((this.location.x + width) % width, (this.location.y + height) % height);
    }
}
