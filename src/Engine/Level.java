package Engine;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public class Level {
    public Snake snake;
    public int score;
    public Field field;

    public Level(Field field, Snake snake)
    {
        this.field = field;
        this.snake = snake;
    }

    public void rearrangeFieldElements()
    {
        for (ICell[] row: field.objects)
            Arrays.fill(row, null);
        snake.snakeParts.forEach(snakePart -> {
            int x = snakePart.location.x;
            int y = snakePart.location.y;
            field.objects[y][x] = snakePart;
        });
    }
}
