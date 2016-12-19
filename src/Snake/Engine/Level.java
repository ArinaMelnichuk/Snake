package Snake.Engine;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        for (ICell[] row : field.objects)
            for (int i = 0; i < field.objects.length + 1; i++)
                for (int j = 0; j < field.objects[0].length + 1; j++)
                    Arrays.fill(row, new EmptyCell(new Point(j, i)));
        snake.snakeParts.forEach(snakePart -> {
            int x = snakePart.location.x;
            int y = snakePart.location.y;
            field.objects[y][x] = snakePart;
        });
        field.hedges.forEach(hedge -> {
            int x = hedge.location.x;
            int y = hedge.location.y;
            field.objects[y][x] = hedge;
        });
        field.bonusesRestart();
        if (!field.bonuses.isEmpty()) {
            Bonus bonus = field.bonuses.peek();
            field.objects[bonus.location.y][bonus.location.x] = bonus;
        }
    }
}
