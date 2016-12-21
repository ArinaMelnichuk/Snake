package Snake.Engine;

import java.awt.Point;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by Arina Melnichuk on 11/23/2016.
 */
public final class Generator {
    private final int x,y;
    private final ICell[][] objects;
    private final List<Hedge> hedges;
    private final Queue<Bonus> bonuses;
    private final Random random;

    public Generator(int x, int y) {
        this.x = x;
        this.y = y;
        objects = new ICell[y][x];
        hedges = new ArrayList<>();
        bonuses = new LinkedTransferQueue<>();
        random = new Random();
    }

    public static Generator createNewInstance(int x, int y) {
        return new Generator(x, y);
    }

    // TODO normal generator with Random

    public Level generateLevel() {
        for (ICell[] row : objects)
            for (int i = 0; i < y + 1; i++)
                for (int j = 0; j < x + 1; j++)
                    Arrays.fill(row, new EmptyCell(new Point(j, i)));
        Snake snake = new Snake(new Point(x / 2, y / 2));
        snake.snakeParts.forEach(snakePart -> objects[snakePart.location.y][snakePart.location.x] = snakePart);
        int xWall = random.nextInt(x - 2) + 1;
        int yWall = random.nextInt(y - 2) + 1;

        LinkedList<SnakePart> parts = snake.snakeParts;
        for (int i = 0; i < parts.size(); i++) {
            if (new Point(xWall, yWall).equals(parts.get(i).location)) {
                xWall = random.nextInt(x - 2) + 1;
                yWall = random.nextInt(y - 2) + 1;
            }
        }
        // форма преграды зависит от уровня
        hedges.add(new Wall(new Point(xWall, yWall)));
        hedges.add(new Wall(new Point(xWall - 1, yWall)));
        hedges.add(new Wall(new Point(xWall, yWall - 1)));
        hedges.add(new Wall(new Point(xWall - 1, yWall + 1)));
        hedges.forEach(hedge -> objects[hedge.location.y][hedge.location.x] = hedge);

        List<Point> bonusPositions = new LinkedList<>();
        // 5 - количество бонусов
        for (int i = 0; i < 5; i++) {
            Point point = new Point(random.nextInt(x), random.nextInt(y));
            bonusPositions.add(point);
            hedges.forEach(hedge -> {
                if (hedge.location.equals(point)) {
                    Point newPoint = new Point(random.nextInt(x), random.nextInt(y));
                    bonusPositions.add(newPoint);
                }
            });
            if (bonusPositions.contains(point))
                bonusPositions.add(new Point(random.nextInt(x), random.nextInt(y)));
            bonuses.add(new ScoreBonus(new Point(point.x, point.y)));
        }

        bonuses.forEach(bonus -> objects[bonus.location.y][bonus.location.x] = bonus);

        Field field = new Field(objects, hedges, bonuses);
        return new Level(field, snake);
    }
}