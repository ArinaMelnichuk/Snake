package Snake.Engine;

import java.awt.Point;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public final class Generator {
    private final int x,y;
    private final ICell[][] objects;
    private final List<Hedge> hedges;
    private final Queue<Bonus> bonuses;

    public Generator(int x, int y) {
        this.x = x;
        this.y = y;
        objects = new ICell[y][x];
        hedges = new ArrayList<>();
        bonuses = new LinkedTransferQueue<>();
    }

    public static Generator createNewInstance(int x, int y) {
        return new Generator(x, y);
    }

    public Level generateLevel() {
        for (ICell[] row : objects)
            for (int i = 0; i < y + 1; i++)
                for (int j = 0; j < x + 1; j++)
                    Arrays.fill(row, new EmptyCell(new Point(j, i)));
        Snake snake = new Snake(new Point(x / 2, y / 2));
        snake.snakeParts.forEach(snakePart -> objects[snakePart.location.y][snakePart.location.x] = snakePart);

        hedges.add(new Wall(new Point(3, 3)));
        hedges.forEach(hedge -> objects[hedge.location.y][hedge.location.x] = hedge);

        bonuses.add(new ScoreBonus(new Point(6, 3)));
        bonuses.add(new ScoreBonus(new Point(23,32)));
        bonuses.add(new ScoreBonus(new Point(40,1)));
        bonuses.add(new ScoreBonus(new Point(10,15)));
        bonuses.forEach(bonus -> objects[bonus.location.y][bonus.location.x] = bonus);

        Field field = new Field(objects, hedges, bonuses);
        return new Level(field, snake);
    }
}