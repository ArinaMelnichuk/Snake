package Engine;

import java.awt.Point;
import java.util.Arrays;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Generator {

    public static Level generateLevel(int x, int y) {
        ICell[][] objects = new ICell[y][x];
        for (ICell[] row: objects)
            Arrays.fill(row, null);
        Snake snake = new Snake(new Point(x / 2, y / 2));
        snake.snakeParts.forEach(snakePart -> objects[snakePart.location.y][snakePart.location.x] = snakePart);
        return new Level(new Field(objects), snake);
    }
}
