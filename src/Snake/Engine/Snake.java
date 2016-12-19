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
//        SnakePart part2 = new SnakePart(new Point(location.x - 2, location.y));
//        SnakePart part3 = new SnakePart(new Point(location.x - 3, location.y));
//        SnakePart part4 = new SnakePart(new Point(location.x - 4, location.y));
//        SnakePart part5 = new SnakePart(new Point(location.x - 5, location.y));
//        SnakePart part6 = new SnakePart(new Point(location.x - 6, location.y));
//        SnakePart part7 = new SnakePart(new Point(location.x - 7, location.y));
//        SnakePart part8 = new SnakePart(new Point(location.x - 8, location.y));
//        SnakePart part9 = new SnakePart(new Point(location.x - 9, location.y));
//        SnakePart part10 = new SnakePart(new Point(location.x - 10, location.y));
        SnakePart tail = new SnakePart(new Point(location.x - 10, location.y - 1));
//        this.snakeParts = new LinkedList<>(Arrays.asList(head, part, part2, part3, part4, part5, part6, part7, part8, part9, part10, tail));
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
